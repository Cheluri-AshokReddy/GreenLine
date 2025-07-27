package com.example.GreenLine.Service;

import com.example.GreenLine.DTO.UserDTO;
import com.example.GreenLine.DTO.UserLoginResponseDTO;
import com.example.GreenLine.DTO.UserResponseDTO;
import com.example.GreenLine.Exceptions.InvalidPasswordException;
import com.example.GreenLine.Exceptions.UserAlreadyExistsException;
import com.example.GreenLine.Exceptions.UserNotFoundException;
import com.example.GreenLine.Model.User;
import com.example.GreenLine.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;


    @Override
    public UserResponseDTO saveUser(User user) {
        userRepository.findByEmail(user.getEmail()).ifPresent(u -> {
            throw new UserAlreadyExistsException("Email already exists: " + user.getEmail());
        });

        userRepository.findByMobileNumber(user.getMobileNumber()).ifPresent(u -> {
            throw new UserAlreadyExistsException("Mobile number already exists: " + user.getMobileNumber());
        });
        user.setCreatedAt(LocalDateTime.now());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserResponseDTO userResponseDTO= modelMapper.map(userRepository.save(user), UserResponseDTO.class);
        return userResponseDTO;
    }

    @Override
    public UserResponseDTO findByEmail(String email) {
        User user=userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User with email '" + email + "' not found."));
        return modelMapper.map(user, UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO findByFullName(String fullName) {
        User user= userRepository.findAll().stream()
                .filter(u -> u.getFullName().equalsIgnoreCase(fullName))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User with full name '" + fullName + "' not found."));
        return modelMapper.map(user, UserResponseDTO.class);
    }

    @Override
    public UserDTO getUserById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with Id '" + id + "' not found."));
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserLoginResponseDTO login(String emailOrFullName, String password) {
        Optional<User> userOptional = userRepository.findByEmail(emailOrFullName);

        if (userOptional.isEmpty()) {
            userOptional = userRepository.findByfullName(emailOrFullName);
            if (userOptional.isEmpty()) {
                throw new UserNotFoundException("User not found by email or full name: " + emailOrFullName);
            }
        }

        User user = userOptional.get();

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new InvalidPasswordException("Incorrect password");
        }

        return modelMapper.map(user, UserLoginResponseDTO.class);
    }

}