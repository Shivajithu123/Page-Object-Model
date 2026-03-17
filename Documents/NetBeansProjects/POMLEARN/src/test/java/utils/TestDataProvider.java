/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author HP
 */


import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "loginData")
    public static Object[][] loginData() {

        return new Object[][] {
            // username, password, expectedResult
            {"tomsmith", "SuperSecretPassword!", "success"},
            {"tomsmith", "wrongPassword", "failure"},
            {"wrongUser", "SuperSecretPassword!", "failure"}
        };
    }
}
