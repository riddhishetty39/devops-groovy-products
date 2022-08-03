package com.myapp.spring

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.GetMapping


@SpringBootApplication
class DevopsGroovyProductsApplication {

	static void main(String[] args) {
		SpringApplication.run(DevopsGroovyProductsApplication, args)
	}

	
	
	
	
	@GetMapping 
	def sayHello() {
		return "Hello"
	}
}
