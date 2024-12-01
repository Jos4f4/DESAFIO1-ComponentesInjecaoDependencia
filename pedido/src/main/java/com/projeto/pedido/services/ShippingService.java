package com.projeto.pedido.services;

import org.springframework.stereotype.Service;

import com.projeto.pedido.entities.Order;

@Service
public class ShippingService {
	
	public double shipment(Order order) {
		if(order.getBasic()<100) {
			return 20;
		}
		if(order.getBasic()>=100 && order.getBasic()<=200) {
			return 12;
		}
		return 0;
	}
}
