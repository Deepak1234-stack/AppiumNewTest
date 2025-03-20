package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    @FindBy(id = "com.qatestapp:id/nameTextField")
    public WebElement input_name;

    @FindBy(id = "com.qatestapp:id/emailTextField")
    public WebElement input_email;

    @FindBy(id = "com.qatestapp:id/phoneNumberTextField")
    public WebElement input_phoneNumber;

    @FindBy(id = "com.qatestapp:id/subscribeCheckbox")
    public WebElement input_subscribeCheck;

    @FindBy(id = "com.qatestapp:id/button2")
    public WebElement button_submit;



}
