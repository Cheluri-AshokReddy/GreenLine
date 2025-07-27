package com.example.GreenLine.DTO;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String emailOrFullName;
    private String password;
}

