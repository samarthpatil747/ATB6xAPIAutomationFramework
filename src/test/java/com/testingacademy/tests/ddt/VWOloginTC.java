package com.testingacademy.tests.ddt;

import com.google.gson.Gson;
import com.testingacademy.actions.AssertActions;
import com.testingacademy.modules.PayloadManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import utils.UtilsExcel;


public class VWOloginTC {

    public RequestSpecification req;
    public AssertActions assertAc;
    public PayloadManager pmanager;
    public JsonPath jsonPath;
    public Response response;
    public ValidatableResponse validatableResponse;

    @Test(dataProvider = "getData", dataProviderClass = UtilsExcel.class)
    public void testVWOlogin(String email, String password) {
        System.out.println("Login API Test");
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        //Payload
        VWOLoginPojo vwo = new VWOLoginPojo();
        vwo.setUsername(email);
        vwo.setPassword(password);
        vwo.setRemember(false);
        vwo.setRecaptchaResponseField("");

        Gson gson = new Gson();
        String payload = gson.toJson(vwo);

        req = RestAssured.given();
        req.baseUri("https://app.vwo.com");
        req.basePath("/login");
        req.contentType(ContentType.JSON);
        req.body(payload).log().all();
        //OR
        //  req.body(vwo).log().all();
        response = req.when().post();
        validatableResponse = response.then();

        String responseString = response.asString();
        System.out.println(responseString);
        validatableResponse.body("id", Matchers.notNullValue());

        System.out.println("Responsee String="+responseString);
        validatableResponse.statusCode(200);


    }
}
