package com.example.GreenLine.Service;

import com.example.GreenLine.DTO.UserDTO;
import com.example.GreenLine.DTO.UserLoginResponseDTO;
import com.example.GreenLine.DTO.UserResponseDTO;
import com.example.GreenLine.Model.User;

public interface UserService {
    UserResponseDTO saveUser(User user);
    UserResponseDTO findByEmail(String email);
    UserResponseDTO findByFullName(String fullName);
    UserDTO getUserById(Integer id);
    UserLoginResponseDTO login(String emailOrFullName, String password);
}
