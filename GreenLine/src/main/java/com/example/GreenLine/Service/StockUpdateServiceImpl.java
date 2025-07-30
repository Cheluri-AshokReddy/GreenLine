package com.example.GreenLine.Service;

import com.example.GreenLine.DTO.StockUpdateItemDTO;
import com.example.GreenLine.DTO.StockUpdateRequestDTO;
import com.example.GreenLine.Exceptions.ProductNotFoundException;
import com.example.GreenLine.Exceptions.SellerNotFoundException;
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
public class StockUpdateServiceImpl implements StockUpdateService {

    private final UserRepository userRepository;
    private final SellerRepository sellerRepository;
    private final ProductRepository productRepository;
    private final StockUpdateRepository stockUpdateRepository;
    private final StockUpdateProductsRepository stockUpdateProductsRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public void updateStock(StockUpdateRequestDTO request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        Sellers seller = sellerRepository.findById(request.getSellerId())
                .orElseThrow(() -> new SellerNotFoundException("Seller not found with ID: " + request.getSellerId()));

        // Create StockUpdates entry
        StockUpdates stockUpdate = new StockUpdates();
        stockUpdate.setUser(user);
        stockUpdate.setSeller(seller);
        stockUpdate.setNotes(request.getNotes());
        stockUpdate.setUpdateDate(LocalDateTime.now());

        List<StockUpdateProducts> updateList = new ArrayList<>();

        for (StockUpdateItemDTO itemDTO : request.getStockItems()) {
            Products product = productRepository.findById(itemDTO.getProductId())
                    .orElseThrow(() -> new ProductNotFoundException("Product ID " + itemDTO.getProductId() + " not found"));

            // Check if StockUpdateProduct exists by product ID
            StockUpdateProducts existing = stockUpdateProductsRepository
                    .findByProduct_ProductId(itemDTO.getProductId())
                    .orElse(null);

            if (existing != null) {
                existing.setQuantity(existing.getQuantity() + itemDTO.getQuantity());
                updateList.add(existing);
            } else {
                StockUpdateProducts newStock = new StockUpdateProducts();
                newStock.setProduct(product);
                newStock.setQuantity(itemDTO.getQuantity());
                newStock.setMrp(product.getMrp());
                newStock.setGst(product.getGst());
                newStock.setStockUpdate(stockUpdate); // important
                updateList.add(newStock);
            }
        }

        stockUpdate.setStockProducts(updateList); // maintain relationship
        StockUpdates savedUpdate = stockUpdateRepository.save(stockUpdate);
        stockUpdateProductsRepository.saveAll(updateList);
    }


}
