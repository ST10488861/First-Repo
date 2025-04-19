/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.apppoe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lab_services_student
 */
public class LoginTest1 {
    
    // Login
    @Test
    public void testLogin() {
        boolean Input2 = Login1.loginUser("H_ni","Javac0de!","H_ni","Javac0de!");
        assertTrue(Input2);
    }
    @Test
    public void testLoginWrongUserName() {
        boolean Input2 = Login1.loginUser("H_ni","Javac0de!","H1ni","Javac0de!");
        assertFalse(Input2);
    }
    @Test
    public void testLoginWrongPassword() {
        boolean Input2 = Login1.loginUser("H_ni","Javac0de!","H_ni","Javacode");
        assertFalse(Input2);
    }

    //Login status
    @Test
    public void testLoginStatusForSuccess() {
        assertEquals("Login successful",Login1.returnLoginStatus(null,true));
    }
    @Test
    public void testLoginStatusForFailure() {
        assertEquals("Login failed",Login1.returnLoginStatus(null,false));
    }

    }
// Code attribution 10
// This method was taken from YouTube
// https://www.youtube.com/
// Coding with John
// https://www.youtube.com/watch?v=vZm0lHciFsQ&list=LL&index=2&t=408s