package com.projeto.pedido.services;

import org.springframework.stereotype.Service;

import com.projeto.pedido.entities.Order;

@Service
public class PaymentService {

	private OrderService orderService = new OrderService();
	private ShippingService shippingService = new ShippingService();
	
	
	public PaymentService(OrderService orderService, ShippingService shippingService) {
		super();
		this.orderService = orderService;
		this.shippingService = shippingService;
	}

	public double returnRequest(Order order) {
		return order.getBasic() - orderService.total(order) 
				+ shippingService.shipment(order);
	}
}
