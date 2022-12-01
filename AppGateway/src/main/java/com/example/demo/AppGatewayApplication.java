package com.example.demo;

import java.net.InetAddress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class AppGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppGatewayApplication.class, args);
	}

	@Bean
	public EurekaInstanceConfigBean eurekaInstanceConfig(InetUtils inetUtils) {
	EurekaInstanceConfigBean config = new EurekaInstanceConfigBean(inetUtils);
	String ip = null;
	try {
	ip = InetAddress.getLocalHost().getHostAddress();
	} catch (Exception e) {
	System.out.println("Exception");
	}
	config.setNonSecurePort(8087);
	config.setIpAddress(ip);
	config.setPreferIpAddress(true);
	return config;
	}
	
	
	
	
	@Bean
	public RouteLocator getRouteLocator(RouteLocatorBuilder builder) {

	return builder.routes()
	.route(t->t.path("/validate/**").uri("lb://jwtserver"))
	.route(t->t.path("/authenticate/**").uri("lb://jwtserver"))
	.route(t->t.path("/registerUser/**").uri("lb://jwtserver"))
	.route(t->t.path("/registerUser/**").uri("lb://jwtserver"))
	.route(t->t.path("/addTrain/**").uri("lb://trainms"))
	.route(t->t.path("/deleteTrain/**").uri("lb://trainms"))
	.route(t->t.path("/uodateTrain/**").uri("lb://trainms"))
	.route(t->t.path("/showallTrain/**").uri("lb://trainms"))
	.route(t->t.path("/getTrainById/**").uri("lb://trainms"))
	.route(t->t.path("/getTrainByName/**").uri("lb://trainms"))
	.route(t->t.path("/getSource/**").uri("lb://trainms"))
	.route(t->t.path("/getDestination/**").uri("lb://trainms"))
	.route(t->t.path("/getTrainByFromAndToStation/**").uri("lb://trainms"))
	.route(t->t.path("/getTrainByStationAndDate/**").uri("lb://trainms"))
	.route(t->t.path("/saveorder/**").uri("lb://ordersms"))
	.route(t->t.path("/getOrderById/**").uri("lb://ordersms"))
	.route(t->t.path("/getOrdersByUserId/**").uri("lb://ordersms"))
	.route(t->t.path("/getOrdersByStatus/**").uri("lb://ordersms"))
	.route(t->t.path("/getOrdersByTravelDate/**").uri("lb://ordersms"))
	.route(t->t.path("/saveorder/**").uri("lb://ordersms"))
	.build();


	}

	
	
	
}
