package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ExpandableListPage {
    private WebDriver driver;

    public ExpandableListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "(//android.widget.TextView[@resource-id=\"android:id/text1\"])")
    public List<WebElement> list_expandableListPageOptionList;


}
