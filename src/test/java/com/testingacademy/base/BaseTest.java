package com.testingacademy.base;

import com.testingacademy.actions.AssertActions;
import com.testingacademy.modules.PayloadManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import com.testingacademy.endpoints.APIConstants;

public class BaseTest {
    public RequestSpecification requestSpecification;
    public AssertActions assertActions;
    public PayloadManager payloadManager;
    public JsonPath jsonPath;
    public Response response;
    public ValidatableResponse validatableResponse;

    @BeforeTest
    public void setUp(){
        System.out.println("Before Test");
        payloadManager = new PayloadManager();
        assertActions = new AssertActions();
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(APIConstants.Base_URL)
                .addHeader("Content-Type","application/json")
                .build().log().all();

//        requestSpecification = RestAssured.
//                given()
//                .baseUri(APIConstants.BASE_URL)
//                .contentType(ContentType.JSON)
//                .log().all();
    }

    public String getToken() {
        // Set up the URLs
        requestSpecification =
                RestAssured.given().baseUri(APIConstants.Base_URL)
                        .basePath(APIConstants.Auth_URL);

        // Setting the up the Payload
        String payload = payloadManager.setAuthPayload();

        // Getting the Response
        response = requestSpecification
                .contentType(ContentType.JSON)
                .body(payload)
                .when().post();

        // Extracting of the Token via Deserialization.
        String token = payloadManager.getTokenFromJSON(response.asString());

        // Verify
        return token;


    }
}
