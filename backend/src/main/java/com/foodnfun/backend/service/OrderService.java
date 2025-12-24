package com.foodnfun.backend.service;
import com.foodnfun.backend.dto.OrderDTO;

//import com.foodnfun.backend.entity.Order;
import java.util.List;

public interface OrderService {

//	OrderDTO placeOrder(OrderDTO orderDTO);
	List<OrderDTO> getAllOrders();
	
	OrderDTO getOrderById(Long id);
	OrderDTO createOrder(OrderDTO orderDTO);
}
