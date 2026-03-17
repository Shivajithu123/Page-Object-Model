/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

/**
 *
 * @author HP
 */


import Pages.LoginPagedata;
import utils.TestDataProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTestdata {

    WebDriver driver;
    LoginPagedata loginPage;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
      
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");

        loginPage = new LoginPagedata(driver);
    }

    @Test(dataProvider = "loginData", dataProviderClass = TestDataProvider.class)
    public void loginTest(String username, String password, String expectedResult) {

        loginPage.login(username, password);
        String message = loginPage.getMessage();

        if (expectedResult.equals("success")) {
            Assert.assertTrue(message.contains("You logged into a secure area!"));
        } else {
            Assert.assertTrue(message.contains("Your username is invalid!")
                    || message.contains("Your password is invalid!"));
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
