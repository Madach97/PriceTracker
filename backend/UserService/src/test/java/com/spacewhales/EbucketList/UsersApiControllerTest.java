package com.spacewhales.EbucketList;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.swagger.api.UsersApi;
import io.swagger.model.LoginToken;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersApiControllerTest {

    @Autowired
    UsersApi usersApiController;

    private LoginToken loginToken = new LoginToken();

    @LocalServerPort
    private int port;

    @BeforeClass
    public void setup(){
        RestAssured.port = port;
    }

//    @Test
//    public void testAuthenticateToken(){
//
//        loginToken.setUsername();
//        loginToken.setExpiryTime();
//        loginToken.setSessionToken();
//        Response response =
//                given().accept("application/json")
//                       .contentType(ContentType.JSON)
//                       .body()
//                        param("param_name", "param_value").
//                        when().
//                        get("/title").
//                        then().
//                        contentType(JSON).
//                        body("title", equalTo("My Title")).
//                        extract().
//                        response();
//        usersApiController.authenticateToken(LoginToken)
//        ResponseEntity<String>
//
//    }
//
//    @Test
//    public void testDeleteUser(){
//        deleteUser(LoginToken);
//        ResponseEntity<String>
//
//    }
//
//    @Test
//    public void testGetUserToken(){
//        getUserToken(LoginToken);
//        ResponseEntity<LoginToken>
//
//    }
//
//
//    @Test
//    public void testInvalidateToken(){
//        invalidateToken(LoginToken);
//        ResponseEntity<String>
//
//    }
//
//    @Test
//    public void testNewUser(){
//        newUser(NewUserRequest);
//        ResponseEntity<String>
//
//    }
//
//    @Test
//    public void testUpdateUser(){
//        updateUser(UpdateUserRequest);
//        ResponseEntity<String>
//
//    }


}
