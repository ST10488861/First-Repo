/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.apppoe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author @ST10488861
 */
public class AppPOETest1 {
    
      //Username
     @Test
    public void  usernameShouldAccept(){
         assertTrue(AppPOE1.checkUserName("H_ni") );

     }
     @Test
    public void  usernameShouldRejectNoUppercase(){
         assertFalse(AppPOE1.checkUserName("hani") );

     }
     @Test
    public void  usernameShouldRejectLength(){
         assertFalse(AppPOE1.checkUserName("Hanhdsf") );
     }
     //Password
     @Test
    public void  passwordComplexityAccepts(){
         assertTrue(AppPOE1.checkPasswordComplexity("Iampassw0rd!") );
     }
     @Test
    public void  passwordComplexityRejectsNoUppercase(){
         assertFalse(AppPOE1.checkPasswordComplexity("iampassw0rd!") );
     }
     @Test
    public void  passwordComplexityRejectsLength(){
         assertFalse(AppPOE1.checkPasswordComplexity("w0rd!") );
     }
     @Test
    public void  passwordComplexityRejectsNoNumbers(){
         assertFalse(AppPOE1.checkPasswordComplexity("word!") );
     }
     @Test
    public void  passwordComplexityRejectsNoSpecialCharacters(){
         assertFalse(AppPOE1.checkPasswordComplexity("w0rd") );
     }
     //Phone number
    @Test
    public void  phoneNumberCheckAccepts(){
         assertTrue(AppPOE1.checkPhoneNumber("+27123456789") );
    }
    @Test
    public void  phoneNumberCheckRejectsNoCountryCode(){
         assertFalse(AppPOE1.checkPhoneNumber("00123456789") );
    }
    @Test
    public void  phoneNumberCheckRejectsWrongLength(){
        assertFalse(AppPOE1.checkPhoneNumber("+271234567") );
    }
    // Registration status
    @Test
    public void  testRegistrationInput(){

         String Input = AppPOE1.registerUser("ab_d","Javac0de!", "+27123456789",null);
         assertEquals("The user is registered successfully",Input);
    }
    @Test
        public void testRegistrationWrongInput1(){
         String Input = AppPOE1.registerUser("abcd","Javac0de!", "+27123456789",null);
         assertEquals("The username is incorrect",Input);
    }
    @Test
    public void testRegistrationWrongInput2(){
         String Input = AppPOE1.registerUser("ab_d","javacode", "+27123456789",null);
         assertEquals("The password does not meet complexity requirements",Input);
    }
    @Test
    public void testRegistrationWrongInput3(){
         String Input = AppPOE1.registerUser("ab_d","Javac0de!", "7123456789",null);
         assertEquals("The phone number is incorrectly formatted",Input);
    }

}
  // Code attribution 8
  // This method was taken from YouTube
  // https://www.youtube.com/
  // Coding with John
  // https://www.youtube.com/watch?v=vZm0lHciFsQ&list=LL&index=2&t=408s   
     