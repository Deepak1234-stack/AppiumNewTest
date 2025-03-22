package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccessibilityPage {

    private WebDriver driver;

    public AccessibilityPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Accessibility\"]")
    public WebElement link_accessibilityLink;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Accessibility Node Provider\"]")
    public WebElement link_accessibilityNodeProviderLink;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Accessibility Node Querying\"]")
    public WebElement link_accessibilityNodeQueryingLink;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Custom View\"]")
    public WebElement link_accessibilityCustomViewLink;

    @FindBy(xpath = "//android.widget.LinearLayout/android.view.View")
    public WebElement image_colorView;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='io.appium.android.apis:id/tasklist_label']")
    public List<WebElement> list_taskList;

    @FindBy(xpath = "//android.widget.CheckBox[@resource-id=\"io.appium.android.apis:id/tasklist_finished\"]")
    public List<WebElement> list_taskCheckboxList;

    @FindBy(xpath = "(//android.view.View[@text=\"Off\"])")
    public List<WebElement> list_customCheckBoxList;












}
