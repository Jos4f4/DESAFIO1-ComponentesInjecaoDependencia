package com.projeto.pedido.services;

import org.springframework.stereotype.Service;

import com.projeto.pedido.entities.Order;

@Service
public class OrderService {
	
	public double total(Order order) {
		return order.getBasic() * order.getDiscount()/100;
	}
}
