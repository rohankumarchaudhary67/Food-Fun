package com.foodnfun.backend.controller;

import com.foodnfun.backend.dto.UserDTO;
import com.foodnfun.backend.response.ApiResponse;
//import com.foodnfun.backend.entity.User;
import com.foodnfun.backend.service.UserService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	@PostMapping
	public ResponseEntity<ApiResponse<UserDTO>> createUser(
            @Valid @RequestBody UserDTO userDTO) {

        UserDTO savedUser = userService.createUser(userDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        true,
                        "User registered successfully",
                        savedUser
                ));
    }
	
	@GetMapping
	public List<UserDTO> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<UserDTO>> getUserById(
            @PathVariable Long id) {

        UserDTO user = userService.getUserById(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "User fetched successfully",
                        user
                ));
    }
}
