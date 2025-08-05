package com.example.GreenLine.Service;

import com.example.GreenLine.DTO.ItemDTO;
import com.example.GreenLine.DTO.SalesSubmissionRequestDTO;
import com.example.GreenLine.Exceptions.ProductNotFoundException;
import com.example.GreenLine.Model.*;
import com.example.GreenLine.Repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesSubmissionServiceImpl implements SalesSubmissionService {

    private final SalesSubmissionRepository salesSubmissionRepository;
    private final SalesSubmissionItemRepository salesSubmissionItemRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Override
    @Transactional
    public Double submitSales(SalesSubmissionRequestDTO request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        double totalSubmissionPrice = 0.0;
        List<SalesSubmissionItems> items = new ArrayList<>();

        // Validate all products first and prepare item list
        for (ItemDTO itemDTO : request.getItems()) {
            Products product = productRepository.findById(itemDTO.getProductId())
                    .orElseThrow(() -> new ProductNotFoundException("Product with ID " + itemDTO.getProductId() + " not found"));

            double itemTotalPrice = (itemDTO.getMrp() + itemDTO.getGst()) * itemDTO.getQuantity();
            totalSubmissionPrice += itemTotalPrice;

            SalesSubmissionItems item = SalesSubmissionItems.builder()
                    .product(product)
                    .quantity(itemDTO.getQuantity())
                    .mrp(itemDTO.getMrp())
                    .gst(itemDTO.getGst())
                    .totalPrice(itemTotalPrice)
                    .build();
            items.add(item);
        }

        // Save submission only after validation
        SalesSubmissions submission = SalesSubmissions.builder()
                .user(user)
                .customerName(request.getCustomerName())
                .customerContact(request.getCustomerContact())
                .deliveryAddress(request.getDeliveryAddress())
                .expectedDeliveryDate(request.getExpectedDeliveryDate())
                .createdAt(LocalDateTime.now())
                .totalSubmissionPrice(totalSubmissionPrice)
                .build();

        SalesSubmissions savedSubmission = salesSubmissionRepository.save(submission);

        // Set salesSubmission reference and save items
        for (SalesSubmissionItems item : items) {
            item.setSalesSubmission(savedSubmission);
        }
        salesSubmissionItemRepository.saveAll(items);
        return totalSubmissionPrice;
    }

}
