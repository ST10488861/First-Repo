/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apppoe;

import java.util.Scanner;


/**
 *
 * @author ST10488861
 */
public class Login1 {
    public static boolean loginUser (String username, String passWord,String username2, String password2) {

        if(username2.equals(username)&& password2.equals(passWord)){
            System.out.println("Correct username and password");
        }else {
            System.out.println("Wrong username or password");
        }
        return username2.equals(username) && password2.equals(passWord);
    }

    public static String returnLoginStatus (Scanner myScanner, boolean login) {
        if (login) {
             return "Login successful";
        }else{
            return "Login failed";
        }

    }
}

// Code attribution 9
// This method was taken from W3 Schools
// https://www.w3schools.com/java/java_conditions.asp
// N/A
// N/A

    
       
