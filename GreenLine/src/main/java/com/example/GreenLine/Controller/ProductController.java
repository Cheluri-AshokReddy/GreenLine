package com.example.GreenLine.Controller;

import com.example.GreenLine.DTO.ProductRequestDTO;
import com.example.GreenLine.DTO.ProductResponseDTO;
import com.example.GreenLine.Model.Products;
import com.example.GreenLine.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponseDTO> addProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        ProductResponseDTO savedProduct = productService.addProduct(productRequestDTO);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
}

