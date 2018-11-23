package com.spacewhales.EbucketList;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.swagger.api.TrackingApi;
import io.swagger.model.LoginToken;
import io.swagger.model.ProductItem;
import io.swagger.model.ProductRequest;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EbucketListApplicationTests {

	@Autowired
	TrackingApi trackingApi;

	private LoginToken loginToken = new LoginToken();

	@LocalServerPort
	private int port;

	@BeforeClass
	public void setup() {
		RestAssured.port = port;
		loginToken.setUsername("new_user");
		loginToken.setSessionToken("d3334599-124e-43b2-8183-482e4a532da9");
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

	public void testgetTrackedProductInfo() {

		String url = "https://www.walmart.com/ip/Timex-Men-s-Classic-Digital-Watch-Gold-Tone-Stainless-Steel-Expansion-Band/10727980";
		ProductRequest productRequest = new ProductRequest();
		productRequest.setUrl("https://www.walmart.com/ip/Timex-Men-s-Classic-Digital-Watch-Gold-Tone-Stainless-Steel-Expansion-Band/10727980");
		productRequest.setLoginToken(loginToken);
		Response response =
				given().accept("application/json")
						.contentType(ContentType.JSON)
						.body(productRequest)
						.when().
						post("/tracking/"+url+"/info").
						then()
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
						.when().
						delete("/tracking/"+url+"/info").
						then()
						.statusCode(200).extract().response();

	}

	@Test
	public void testGetTrackedProducts() {

		Response response =
				given().accept("application/json")
						.contentType(ContentType.JSON)
						.body(loginToken)
						.when().
						put("/tracking/all").
						then()
						.statusCode(200).extract().response();

	}

}