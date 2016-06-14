package com.example.switchyard.switchyard_rest_demo;

public interface OrderService {
	
	public Order newOrder(Order order);
	public Order getOrder(Long orderId);

}
