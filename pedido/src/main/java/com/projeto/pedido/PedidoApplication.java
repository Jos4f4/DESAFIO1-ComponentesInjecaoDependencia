package com.projeto.pedido;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projeto.pedido.entities.Order;
import com.projeto.pedido.services.OrderService;
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
		//CASO DE TESTE 1
		System.out.println("\n");
		Order order1 = new Order(1034, 150.0, 20.0);
		Double result1 = orderService.total(order1) + shippingService.shipment(order1);
		System.out.println("Pedido código: " + order1.getCode());
		System.out.println("Valor total: " + result1);
		
		//CASO DE TESTE 2
		System.out.println("\n");
		Order order2 = new Order(2282, 800.0, 10.0);
		Double result2 = orderService.total(order2) + shippingService.shipment(order2);
		System.out.println("Pedido código: " + order2.getCode());
		System.out.println("Valor total: " + result2);
		
		//CASO DE TESTE 3
		System.out.println("\n");
		Order order3 = new Order(1309, 95.90, 0.0);
		Double result3 = orderService.total(order3) + shippingService.shipment(order3);
		System.out.println("Pedido código: " + order3.getCode());
		System.out.println("Valor total: " + result3);
		
	}

}
