/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

import org.testng.annotations.Test;

import Pages.LoginPageenv;
import org.testng.Assert;
import utils.ConfigReader;
/**
 *
 * @author HP
 */
public class LoginTestenv extends BaseTestenv {

    @Test
    public void loginTest() {

        LoginPageenv page = new LoginPageenv(driver);
        page.login(
                
            ConfigReader.get("username"),
            ConfigReader.get("password")
        );

        Assert.assertTrue(page.getMessage().contains("secure"));
    }
}
