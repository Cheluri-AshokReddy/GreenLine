package com.example.GreenLine.DTO;
import lombok.Data;

@Data
public class UserLoginResponseDTO {

    private Integer userId;
    private String fullName;
    private String email;
    private String mobileNumber;
    private String role;
}
