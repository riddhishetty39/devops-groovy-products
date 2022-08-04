package com.myapp.spring

import static org.junit.jupiter.api.Assertions.assertEquals
import static org.junit.jupiter.api.Assertions.assertTrue

import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.context.event.annotation.BeforeTestClass

import io.restassured.RestAssured
import io.restassured.response.Response

class DevopsGroovyProductsApplicationTests {
	
	static API_ROOT = 'http://localhost:9090/products'
	static productId = 1

	@BeforeTestClass
		static void populateData() {
	
	Product product1 = new Product(productId: 1,productName: 'Iphone13',
			description: 'Iphone13 Pro',price: 75453.5,
			starRating:4.7)
		
		
		
		Response response =
		RestAssured.given().contentType(MediaType.APPLICATION_JSON_VALUE)
		.body(product1).post(API_ROOT)
		
}
	

@Test
void whenGetAllProductList_thenOk(){
	final Response response = RestAssured.get(API_ROOT)
	
	assertEquals HttpStatus.OK.value(),response.getStatusCode()
	assertTrue response.as(List.class).size() > 0
}

@Test
void whenGetProductById_thenOk(){
	final Response response = RestAssured.get("$API_ROOT/$productId")
	
	assertEquals HttpStatus.OK.value(),response.getStatusCode()
	Product productResponse = response.as Product.class
	assertEquals productId,productResponse.getProductId()
}





@Test
void whenSaveProduct_thenOk(){
	Product product2 = new Product(productId: 4,productName:'Oneplus10',
			description: 'Oneplus10 Pro',price: 61453.5,
			starRating:4.6)
	final Response response =
	  RestAssured.given()
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		  .body(product2).post(API_ROOT)
		  
	assertEquals HttpStatus.OK.value(),response.getStatusCode()
}
	

}
