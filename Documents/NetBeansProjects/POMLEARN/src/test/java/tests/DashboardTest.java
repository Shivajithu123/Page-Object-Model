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

public class DashboardTest extends BaseTest {

    @Test
    public void dashboardTitleTest() {

        driver.get("https://the-internet.herokuapp.com/secure");

        String title = driver.getTitle();
        Assert.assertEquals(title, "The Internet");
    }
}
