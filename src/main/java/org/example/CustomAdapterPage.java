package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CustomAdapterPage {

    private WebDriver driver;

    public CustomAdapterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//android.widget.ExpandableListView[@resource-id=\"android:id/list\"]//android.widget.TextView")
    public List<WebElement> list_customAdapterPageOptionList;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Sample action\"]")
    public WebElement option_sampleAction;


}
