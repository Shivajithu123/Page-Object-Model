/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
package tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import Factory.DriverFactory;

public class BaseTestenv {

    protected WebDriver driver;

    @BeforeSuite
    public void setupConfig() {
        // IMPORTANT: You must call loadConfig first!
        // Replace "env1" with your actual filename (e.g., "staging" or "config")
        ConfigReader.loadConfig("prod"); 
        System.out.println("Config Loaded Successfully");
    }

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getDriver();
        // This will now work because properties is no longer null
        driver.get(ConfigReader.get("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
