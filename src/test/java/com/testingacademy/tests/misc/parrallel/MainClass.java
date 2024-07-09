package com.testingacademy.tests.misc.parrallel;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainClass {

    @BeforeMethod

    public void beforeMethod() {
        long id = Thread.currentThread().getId();
        System.out.println("Before test Thread getID " + id +getClass().getName());
    }
    @Test

    public void testMethods1() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test Thread 1 getID " + id+ getClass());
    }
    @Test
    public void testMethods2() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test Thread 2 getID " + id +getClass());
    }
    @Test
    public void testMethods3() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test Thread 3 getID " + id +getClass());
    }
    @Test
    public void testMethods4() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test Thread 4 getID" + id +getClass());
    }
    @Test
    public void testMethods5() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test Thread 5 getID " + id +getClass());
    }
    @Test
    public void testMethods6() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test Thread 6 getID " + id +getClass());
    }
    @AfterMethod
    public void afterMethod() {
        long id = Thread.currentThread().getId();
        System.out.println("After test Thread getID " + id +getClass().getName());
    }
}

