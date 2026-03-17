/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

/**
 *
 * @author HP
 */

import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test
    public void logoutTest() {

        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(org.openqa.selenium.By.cssSelector("a.button")).click();

        Assert.assertTrue(driver.getPageSource().contains("You logged out"));
    }
}
