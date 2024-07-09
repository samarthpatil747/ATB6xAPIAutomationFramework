package com.testingacademy.tests.integration.retryLogic;

import com.testingacademy.base.BaseTest;
import com.testingacademy.endpoints.APIConstants;
import com.testingacademy.pojos.Booking;
import com.testingacademy.pojos.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import utils.PropertyReader;

import static org.assertj.core.api.Assertions.assertThat;

public class TcIntegrationFlowRetry extends BaseTest {
    @Test(groups = "integration", priority = 1)
    @Owner("Samarth")
    @Description("TC#1 - Step1 Verify that booking can be created")

    public void testCreateBooking(ITestContext iTestContext) {
        iTestContext.setAttribute("token", getToken());


        requestSpecification.basePath(APIConstants.Create_Update_Booking_URL);
        response = RestAssured
                .given(requestSpecification)
                .when().body(payloadManager.createPayloadBookingAsString()).post();

        validatableResponse = response.then().log().all();

        // Validatable Assertion
        validatableResponse.statusCode(200);
//        validatableResponse.body("booking.firstname", Matchers.equalTo("Pramod"));

        // DeSer
        BookingResponse bookingResponse = payloadManager.bookingResponseJAVA(response.asString());
        // AssertJ
        assertThat(bookingResponse.getBookingid()).isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isNotNull().isNotBlank();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Sameer");

        //  Set the booking ID
        iTestContext.setAttribute("bookingid", bookingResponse.getBookingid());


    }

    @Test(groups = "integration", priority = 2)
    @Owner("Samarth")
    @Description("TC#2 - Step1 Verify that booking is created")
    public void testVerifyBookingId(ITestContext iTestContext) {

        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
        String Base_Path_Get = APIConstants.Create_Update_Booking_URL + "/" + bookingid;
        System.out.println("URL="+Base_Path_Get);

        requestSpecification.basePath(Base_Path_Get);
        response = RestAssured.given().spec(requestSpecification)
                .when().get();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        Booking booking = payloadManager.bookingResponseFromJSON(response.asString());

        assertThat(booking.getFirstname()).isNotNull().isNotBlank();
        assertThat(booking.getFirstname()).isEqualTo(PropertyReader.readKey("booking.firstName"));

    }

    @Test(groups = "integration", priority = 3)
    @Owner("Samarth")
    @Description("TC#1 - Step1 Verify update booking")
    public void testUpdateBooking(ITestContext iTestContext) {
        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
        String Base_Path_Put_Patch = APIConstants.Create_Update_Booking_URL + "/" + bookingid;
        System.out.println("URL="+Base_Path_Put_Patch);
        String token = (String) iTestContext.getAttribute("token");

        requestSpecification.basePath(Base_Path_Put_Patch);
        response = RestAssured
                .given(requestSpecification).cookie("token",token)
                .when().body(payloadManager.fullUpdatePayloadAsString()).get();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        Booking booking = payloadManager.bookingResponseFromJSON(response.asString());

        assertThat(booking.getFirstname()).isNotNull().isNotBlank();
        assertThat(booking.getFirstname()).isEqualTo("Sameer");
        assertThat(booking.getLastname()).isEqualTo("Patil");
        assertThat(booking.getAdditionalneeds()).isEqualTo("Breakfast");
    }

    @Test(groups = "integration", priority = 4)
    @Owner("Samarth")
    @Description("TC#1 - Step1 Verify that booking can be deleted")
    public void testDeleteBooking(ITestContext iTestContext) {
        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
        String Base_Path_Delete = APIConstants.Create_Update_Booking_URL + "/" + bookingid;
        System.out.println("URL="+Base_Path_Delete);
        String token = (String) iTestContext.getAttribute("token");

        requestSpecification.basePath(Base_Path_Delete).cookie("token",token);
        validatableResponse = RestAssured
                .given(requestSpecification).cookie("token",token)
                .when().delete().then().log().all();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);


    }


}
