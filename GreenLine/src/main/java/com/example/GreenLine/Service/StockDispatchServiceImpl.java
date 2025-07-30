package com.example.GreenLine.Service;

import com.example.GreenLine.DTO.StockDispatchItemDTO;
import com.example.GreenLine.DTO.StockDispatchRequestDTO;
import com.example.GreenLine.Exceptions.ProductNotFoundException;
import com.example.GreenLine.Exceptions.UserNotFoundException;
import com.example.GreenLine.Model.*;
import com.example.GreenLine.Repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockDispatchServiceImpl implements StockDispatchService {

    private final StockDispatchRepository stockDispatchRepository;
    private final StockDispatchProductsRepository stockDispatchProductsRepository;
    private final StockUpdateProductsRepository stockUpdateProductsRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public void dispatchStock(StockDispatchRequestDTO request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        // 1. Create and map StockDispatch
        StockDispatchs dispatch = new StockDispatchs();
        dispatch.setUser(user);
        dispatch.setNotes(request.getNotes());
        dispatch.setDispatchDate(LocalDateTime.now());

        StockDispatchs savedDispatch = stockDispatchRepository.save(dispatch);

        List<StockDispatchProducts> dispatchProducts = new ArrayList<>();

        for (StockDispatchItemDTO item : request.getStockItems()) {
            Products product = productRepository.findById(item.getProductId())
                    .orElseThrow(() -> new ProductNotFoundException("Product ID " + item.getProductId() + " not found"));

            StockUpdateProducts stock = stockUpdateProductsRepository.findByProduct_ProductId(product.getProductId())
                    .orElse(null);

            if (stock == null || stock.getQuantity() < item.getQuantity()) {
                throw new RuntimeException("Insufficient stock for product ID: " + product.getProductId());
            }

            // Deduct available quantity
            stock.setQuantity(stock.getQuantity() - item.getQuantity());
            stockUpdateProductsRepository.save(stock);

            // Create new dispatch product entry
            StockDispatchProducts dispatchProduct = new StockDispatchProducts();
            dispatchProduct.setProduct(product);
            dispatchProduct.setQuantity(item.getQuantity());
            dispatchProduct.setMrp(item.getMrp());
            dispatchProduct.setGst(item.getGst());
            dispatchProduct.setStockDispatch(savedDispatch);

            dispatchProducts.add(dispatchProduct);
        }

        stockDispatchProductsRepository.saveAll(dispatchProducts);
    }

}
