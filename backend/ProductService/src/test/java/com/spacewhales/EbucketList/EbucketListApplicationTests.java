package com.spacewhales.EbucketList;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.swagger.model.LoginToken;
import io.swagger.model.ProductRequest;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static io.restassured.RestAssured.given;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class EbucketListApplicationTests {

	private static LoginToken loginToken;

	private static int port = 9090;

	@BeforeClass
	public static void setup() {
		RestTemplate restTemplate = new RestTemplate();
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setUsername("test_user");
		loginRequest.setPassword("test_user");
		ResponseEntity<LoginToken> response = restTemplate.postForEntity("http://localhost:8080/users/token/login", loginRequest, LoginToken.class);
		int status = response.getStatusCode().value();
		loginToken = response.getBody();
		if(status != 200){
		   throw new NullPointerException("cannot get user token");
		}
		RestAssured.port = port;
	}

	@Test
	public void testaddTrackedProduct() {

		ProductRequest productRequest = new ProductRequest();
		productRequest.setUrl("https://www.walmart.com/ip/Timex-Men-s-Classic-Digital-Watch-Gold-Tone-Stainless-Steel-Expansion-Band/10727980");
		productRequest.setLoginToken(loginToken);

		Response response =
				given().accept("application/json")
						.contentType(ContentType.JSON)
						.body(productRequest)
						.when().
						put("/tracking/all").
						then()
						.statusCode(200).extract().response();

	}

	public void testGetTrackedProductInfo() {

		String url = "https://www.walmart.com/ip/Timex-Men-s-Classic-Digital-Watch-Gold-Tone-Stainless-Steel-Expansion-Band/10727980";
		ProductRequest productRequest = new ProductRequest();
		productRequest.setUrl("https://www.walmart.com/ip/Timex-Men-s-Classic-Digital-Watch-Gold-Tone-Stainless-Steel-Expansion-Band/10727980");
		productRequest.setLoginToken(loginToken);
		Response response =
				given().accept("application/json")
						.contentType(ContentType.JSON)
						.body(productRequest)
						.when()
						.post("/tracking/"+url+"/info")
						.then()
						.statusCode(200).extract().response();

	}

	@Test
	public void testDeleteTrackedProduct(){

		String url = "https://www.walmart.com/ip/Timex-Men-s-Classic-Digital-Watch-Gold-Tone-Stainless-Steel-Expansion-Band/10727980";
		ProductRequest productRequest = new ProductRequest();
		productRequest.setUrl("https://www.walmart.com/ip/Timex-Men-s-Classic-Digital-Watch-Gold-Tone-Stainless-Steel-Expansion-Band/10727980");
		productRequest.setLoginToken(loginToken);
		Response response =
				given().accept("application/json")
						.contentType(ContentType.JSON)
						.body(productRequest)
						.when()
						.delete("/tracking/"+url+"/info")
						.then()
						.statusCode(200).extract().response();

	}

	@Test
	public void testGetTrackedProducts() {

		Response response =
				given().accept("application/json")
						.contentType(ContentType.JSON)
						.body(loginToken)
						.when()
						.post("/tracking/all")
						.then()
						.statusCode(200).extract().response();

	}

}