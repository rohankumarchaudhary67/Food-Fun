package com.foodnfun.backend.controller;

import com.foodnfun.backend.dto.FoodDTO;
import com.foodnfun.backend.response.ApiResponse;
//import com.foodnfun.backend.entity.Food;
import com.foodnfun.backend.service.FoodService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
public class FoodController {

	private final FoodService foodService;
	
	public FoodController(FoodService foodService) {
		this.foodService=foodService;
	}
	
	// Create Food
    @PostMapping
    public ResponseEntity<ApiResponse<FoodDTO>> createFood(@Valid @RequestBody FoodDTO foodDTO) {
        FoodDTO savedFood = foodService.createFood(foodDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(true,"Food created succesfully",savedFood));
    }

    // Get all foods
    @GetMapping
    public ResponseEntity<ApiResponse<List<FoodDTO>>> getAllFoods() {
    	 List<FoodDTO> foods = foodService.getAllFoods();

         return ResponseEntity.ok(
                 new ApiResponse<>(
                         true,
                         "Foods fetched successfully",
                         foods
                 ));
        
    }

    // Get food by ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<FoodDTO>> getFoodById(@PathVariable Long id) {
    	 FoodDTO food = foodService.getFoodById(id);

         return ResponseEntity.ok(
                 new ApiResponse<>(
                         true,
                         "Food fetched successfully",
                         food
                 ));
    }
}
