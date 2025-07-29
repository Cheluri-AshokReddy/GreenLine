package com.example.GreenLine.Service;

import com.example.GreenLine.DTO.ProductRequestDTO;
import com.example.GreenLine.DTO.ProductResponseDTO;
import com.example.GreenLine.Exceptions.SellerNotFoundException;
import com.example.GreenLine.Model.Products;
import com.example.GreenLine.Model.Sellers;
import com.example.GreenLine.Repository.ProductRepository;
import com.example.GreenLine.Repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final SellerRepository sellerRepository;
    private final ModelMapper modelMapper;

    @Override
    public ProductResponseDTO addProduct(ProductRequestDTO dto) {
        Sellers seller = sellerRepository.findById(dto.getSellerId())
                .orElseThrow(() -> new SellerNotFoundException("Seller with ID " + dto.getSellerId() + " not found"));

        // Map request DTO to entity
        Products product = modelMapper.map(dto, Products.class);
        product.setProductId(null);
        product.setCreatedAt(LocalDateTime.now());
        product.setSeller(seller);

        // Save to DB
        Products savedProduct = productRepository.save(product);

        // Map entity to response DTO
        ProductResponseDTO responseDTO = modelMapper.map(savedProduct, ProductResponseDTO.class);
        responseDTO.setSellerId(savedProduct.getSeller().getSellerId());

        return responseDTO;
    }

}
