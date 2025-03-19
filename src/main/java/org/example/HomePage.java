package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    @FindBy(id = "com.qatestapp:id/emailTextField1")
    public WebElement input_userName;

    @FindBy(id = "com.qatestapp:id/passwordTextField")
    public WebElement input_password;

    @FindBy(id = "com.qatestapp:id/LoginButton")
    public WebElement button_startTest;


}
