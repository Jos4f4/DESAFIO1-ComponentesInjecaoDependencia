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
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dados do pedido: \n");
		System.out.println("Código: ");
		Integer code = sc.nextInt();
		System.out.println("Valor básico: ");
		double basic = sc.nextDouble();
		System.out.println("Porcentagem de desconto: ");
		double discount = sc.nextDouble();
		
		Order order = new Order(code, basic, discount);		

		PaymentService paymentService = new PaymentService(orderService, shippingService);

		System.out.println("\n");
		System.out.printf("Pedido código: " + order.getCode() + "\n" + "Valor total: "
						+ paymentService.returnRequest(order));
		sc.close();
		
	}

}
