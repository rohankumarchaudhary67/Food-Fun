package com.foodnfun.backend.controller;
import com.foodnfun.backend.dto.OrderDTO;
import com.foodnfun.backend.response.ApiResponse;
//import com.foodnfun.backend.entity.Order;
import com.foodnfun.backend.service.OrderService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	private final OrderService orderService;
	
	public OrderController(OrderService orderService) {
		this.orderService=orderService;
	}
	
	 // Create Order
    @PostMapping
    public ResponseEntity<ApiResponse<OrderDTO>> placeOrder(
            @Valid @RequestBody OrderDTO orderDTO) {

        OrderDTO order = orderService.createOrder(orderDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        true,
                        "Order placed successfully",
                        order
                ));
    }

    // Get all orders
    @GetMapping
    public ResponseEntity<ApiResponse<List<OrderDTO>>> getAllOrders() {

        List<OrderDTO> orders = orderService.getAllOrders();

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Orders fetched successfully",
                        orders
                ));
    }

    // Get order by ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<OrderDTO>> getOrderById(
            @PathVariable Long id) {

        OrderDTO order = orderService.getOrderById(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Order fetched successfully",
                        order
                ));
    }
}
