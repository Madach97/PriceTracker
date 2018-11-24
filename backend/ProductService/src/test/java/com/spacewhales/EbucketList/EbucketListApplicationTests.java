package com.spacewhales.EbucketList;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.swagger.api.TrackingApi;
import io.swagger.model.LoginToken;
import io.swagger.model.ProductItem;
import io.swagger.model.ProductRequest;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class EbucketListApplicationTests {

	private LoginToken loginToken = new LoginToken();

	private int port = 9090;

	@Before
	public void setup() {
		RestAssured.port = port;
		loginToken.setUsername("new_user");
		loginToken.setSessionToken("6a50c36e-8be7-44e5-9990-eec401c12f98");
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