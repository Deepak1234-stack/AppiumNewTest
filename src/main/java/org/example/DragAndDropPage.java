package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPage {
    private WebDriver driver;

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.view.View[@resource-id=\"io.appium.android.apis:id/drag_dot_1\"]")
    public WebElement img_firstDot;

    @FindBy(xpath = "//android.view.View[@resource-id=\"io.appium.android.apis:id/drag_dot_2\"]")
    public WebElement img_secondDot;

}
