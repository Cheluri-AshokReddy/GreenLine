package com.example.GreenLine.Service;

import com.example.GreenLine.DTO.ProductRequestDTO;
import com.example.GreenLine.DTO.ProductResponseDTO;
import com.example.GreenLine.Model.Products;

public interface ProductService {
    ProductResponseDTO addProduct(ProductRequestDTO productRequestDTO);
}
