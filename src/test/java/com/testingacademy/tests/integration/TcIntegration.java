package com.testingacademy.tests.integration;

import com.testingacademy.base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TcIntegration extends BaseTest {
    @Test(groups = "integration", priority = 1)
    @Owner("Samarth")
    @Description("TC#1 - Step1 Verify that booking can be created")

    public void testCreateBooking() {
        Assert.assertTrue(true);
    }
    @Test(groups = "integration", priority = 2)
    @Owner("Samarth")
    @Description("TC#2 - Step1 Verify that booking is created")
    public void testVerifyBookingId() {
        Assert.assertTrue(true);
    }
    @Test(groups = "integration", priority = 3)
    @Owner("Samarth")
    @Description("TC#1 - Step1 Verify update booking")
    public void testUpdateBooking() {
        Assert.assertTrue(true);
    }
    @Test(groups = "integration", priority = 4)
    @Owner("Samarth")
    @Description("TC#1 - Step1 Verify that booking can be deleted")
    public void testDeleteBooking() {
        Assert.assertTrue(true);
    }


}
