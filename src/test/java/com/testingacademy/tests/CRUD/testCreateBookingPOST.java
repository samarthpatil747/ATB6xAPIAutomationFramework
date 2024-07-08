package com.testingacademy.tests.CRUD;

import com.testingacademy.base.BaseTest;
import com.testingacademy.pojos.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import com.testingacademy.endpoints.APIConstants;

import static org.assertj.core.api.Assertions.assertThat;

public class testCreateBookingPOST extends BaseTest {
    @Test(groups = "smoke")
    @Owner("Samarth")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC#1 - Verify that the Booking can be Created")
    public void testCreateBooking() {
        requestSpecification.basePath(APIConstants.Create_Update_Booking_URL);
        response = RestAssured
                .given(requestSpecification)
                .when().body(payloadManager.createPayloadBookingAsString()).post();

        validatableResponse = response.then().log().all();

        // Validatable Assertion
        validatableResponse.statusCode(200);
//        validatableResponse.body("booking.firstname", Matchers.equalTo("Pramod"));

        // DeSer
        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());
        // AssertJ
        assertThat(bookingResponse.getBookingid ()).isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isNotNull().isNotBlank();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Samarth");

        // TestNG Assertions
        assertActions.verifyStatusCode(response,200);
    }


    @Test(groups = "smoke")
    @Owner("Samarth")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC#1 - Verify that the Booking can be Created")
    public void testCreateBookingNegative() {
        requestSpecification.basePath(APIConstants.Create_Update_Booking_URL);
        response = RestAssured
                .given(requestSpecification)
                .when().body(payloadManager.createInvalidPayloadBookingAsString()).post();

        validatableResponse = response.then().log().all();

        // Validatable Assertion
        validatableResponse.statusCode(500);

    }
}
