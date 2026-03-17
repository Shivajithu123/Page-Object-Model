/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

/**
 *
 * @author HP
 */
import Pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");

        loginPage = new LoginPage(driver);
    }
   
    @Test
    public void validLoginTest() {
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickLogin();

        String message = loginPage.getSuccessMessage();
        Assert.assertTrue(message.contains("You logged into a secure area!"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

