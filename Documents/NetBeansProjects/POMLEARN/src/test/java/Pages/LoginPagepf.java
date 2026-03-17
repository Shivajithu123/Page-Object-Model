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

public class LoginPagepf{

    WebDriver driver;

    // Web elements using @FindBy
    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(css = "button[type='submit']")
    WebElement loginButton;

    @FindBy(id = "flash")
    WebElement successMessage;

    // Constructor
    public LoginPagepf(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Page Actions (Business Methods)
    public void enterUsername(String user) {
        username.sendKeys(user);
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}
