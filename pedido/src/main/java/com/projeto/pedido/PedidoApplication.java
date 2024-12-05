package com.projeto.pedido;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projeto.pedido.entities.Order;
import com.projeto.pedido.services.OrderService;
import com.projeto.pedido.services.PaymentService;
import com.projeto.pedido.services.ShippingService;

@SpringBootApplication
public class PedidoApplication implements CommandLineRunner {
	private OrderService orderService = new OrderService();
	private ShippingService shippingService = new ShippingService();
	
	public PedidoApplication(OrderService orderService, ShippingService shippingService) {
		super();
		this.orderService = orderService;
		this.shippingService = shippingService;
	}

	public static void main(String[] args) {
		SpringApplication.run(PedidoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Order order1 = new Order(1034, 150.0, 20.0);
		System.out.println("Pedido código: " + order1.getCode());
		System.out.println("Valor total: " + orderService.total(order1));
		
		Order order2 = new Order(2282, 800.0, 10.0);
		System.out.println("Pedido código: " + order2.getCode());
		System.out.println("Valor total: " + orderService.total(order2));
		
		Order order3 = new Order(1309, 95.90, 0.0);
		System.out.println("Pedido código: " + order3.getCode());
		System.out.println("Valor total: " + orderService.total(order3));
		
	}

}
