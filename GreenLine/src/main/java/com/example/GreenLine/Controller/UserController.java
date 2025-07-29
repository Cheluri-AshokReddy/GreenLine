package com.example.GreenLine.Controller;

import com.example.GreenLine.DTO.LoginRequestDTO;
import com.example.GreenLine.DTO.UserDTO;
import com.example.GreenLine.DTO.UserLoginResponseDTO;
import com.example.GreenLine.DTO.UserResponseDTO;
import com.example.GreenLine.Model.User;
import com.example.GreenLine.Service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserServiceImpl userService;

    // Save a new user
    @PostMapping("/save")
    public ResponseEntity<UserResponseDTO> saveUser(@RequestBody User user) {
        UserResponseDTO savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

    }

    // Find user by email
    @GetMapping("/email/{email}")
    public ResponseEntity<UserResponseDTO> getUserByEmail(@PathVariable String email) {
        UserResponseDTO user = userService.findByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Find user by full name
    @GetMapping("/name/{name}")
    public ResponseEntity<UserResponseDTO> getUserByName(@PathVariable String name) {
        UserResponseDTO user = userService.findByEmail(name);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id) {
        UserDTO userDTO = userService.getUserById(id);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponseDTO> login(@RequestBody LoginRequestDTO request) {
        UserLoginResponseDTO dto = userService.login(request.getEmailOrFullName(), request.getPassword());
        return ResponseEntity.ok(dto);
    }
}
