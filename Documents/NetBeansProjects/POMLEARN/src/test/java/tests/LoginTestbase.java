/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

/**
 *
 * @author HP
 */


import Pages.LoginPagebs;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestbase extends BaseTest {

    @Test
    public void validLoginTest() {

        driver.get("https://the-internet.herokuapp.com/login");

        LoginPagebs loginPage = new LoginPagebs(driver);
        loginPage.login("tomsmith", "SuperSecretPassword!");

        Assert.assertTrue(loginPage.getMessage()
                .contains("You logged into a secure area!"));
    }
}
