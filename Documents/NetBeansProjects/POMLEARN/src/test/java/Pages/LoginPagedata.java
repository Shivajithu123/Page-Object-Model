/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pages;

/**
 *
 * @author HP
 */


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagedata{

    WebDriver driver;

    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(css = "button[type='submit']")
    WebElement loginButton;

    @FindBy(id = "flash")
    WebElement message;

    public LoginPagedata(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Page Actions
    public void login(String user, String pass) {
        username.clear();
        username.sendKeys(user);

        password.clear();
        password.sendKeys(pass);

        loginButton.click();
    }

    public String getMessage() {
        return message.getText();
    }
}
