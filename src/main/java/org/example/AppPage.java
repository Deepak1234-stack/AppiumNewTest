package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AppPage {
    private WebDriver driver;

    public AppPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"App\"]")
    public WebElement link_appLink;

    @FindBy(xpath = "(//android.widget.TextView[@resource-id=\"android:id/text1\"])")
    public List<WebElement> list_appListPageOptionList;



}
