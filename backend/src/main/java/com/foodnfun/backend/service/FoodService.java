package com.foodnfun.backend.service;

import com.foodnfun.backend.dto.FoodDTO;
//import com.foodnfun.backend.entity.Food;

import java.util.List;

public interface FoodService {

	FoodDTO createFood(FoodDTO foodDTO);
	List<FoodDTO> getAllFoods();
	FoodDTO getFoodById(Long id);
}
