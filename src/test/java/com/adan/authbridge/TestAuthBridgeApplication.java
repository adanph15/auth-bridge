package com.adan.authbridge;

import org.springframework.boot.SpringApplication;

public class TestAuthBridgeApplication {

	public static void main(String[] args) {
		SpringApplication.from(AuthBridgeApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
