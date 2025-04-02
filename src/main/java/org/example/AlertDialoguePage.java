package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AlertDialoguePage {

    private WebDriver driver;

    public AlertDialoguePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"OK Cancel dialog with a message\"]")
    public WebElement alert_cancelWithMessage;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Single choice list\"]")
    public WebElement alert_singleChoiceList;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Text Entry dialog\"]")
    public WebElement alert_textEntryDialog;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Repeat alarm\"]")
    public WebElement alert_repeatAlarm;

    @FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Street view\"]")
    public WebElement radio_streetViewButton;

    @FindBy(id = "io.appium.android.apis:id/username_edit")
    public WebElement input_nameInEntryDialogue;

    @FindBy(id = "io.appium.android.apis:id/password_edit")
    public WebElement input_passwordInEntryDialogue;

    @FindBy(xpath = "(//android.widget.CheckedTextView[@resource-id=\"android:id/text1\"])")
    public List<WebElement> list_repeatAlarmPageOptionList;








}

