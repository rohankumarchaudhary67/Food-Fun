package com.foodnfun.backend.service.impl;

import com.foodnfun.backend.dto.OrderDTO;
import com.foodnfun.backend.entity.Food;
import com.foodnfun.backend.entity.Order;
import com.foodnfun.backend.entity.User;
import com.foodnfun.backend.exception.ResourceNotFoundException;
import com.foodnfun.backend.repository.FoodRepository;
import com.foodnfun.backend.repository.OrderRepository;
import com.foodnfun.backend.repository.UserRepository;
import com.foodnfun.backend.service.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final FoodRepository foodRepository;

    public OrderServiceImpl(OrderRepository orderRepository,
                            UserRepository userRepository,
                            FoodRepository foodRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.foodRepository = foodRepository;
    }

    // ---------- CREATE ----------
    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {

        // 1️⃣ Fetch User
        User user = userRepository.findById(orderDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        // 2️⃣ Fetch Food
        Food food = foodRepository.findById(orderDTO.getFoodId())
                .orElseThrow(() -> new ResourceNotFoundException("Food not found"));

        // 3️⃣ Create Order entity
        Order order = new Order();
        order.setUser(user);
        order.setFood(food);
        order.setQuantity(orderDTO.getQuantity());

        // 4️⃣ Business logic
        double total = food.getPrice() * orderDTO.getQuantity();
        order.setTotalAmount(total);
        order.setOrderDate(LocalDateTime.now());

        // 5️⃣ Save
        Order saved = orderRepository.save(order);

        // 6️⃣ Return DTO
        return mapToDTO(saved);
    }

    // ---------- READ ALL ----------
    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    // ---------- READ BY ID ----------
    @Override
    public OrderDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return mapToDTO(order);
    }

    // ---------- MAPPING ----------
    private OrderDTO mapToDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setUserId(order.getUser().getId());
        dto.setFoodId(order.getFood().getId());
        dto.setQuantity(order.getQuantity());
        dto.setTotalAmount(order.getTotalAmount());
        dto.setOrderDate(order.getOrderDate());
        return dto;
    }
}
