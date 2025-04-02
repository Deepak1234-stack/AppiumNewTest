package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ViewPage {

    private WebDriver driver;

    public ViewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Views\"]")
    public WebElement link_viewsPageLink;

    @FindBy(xpath = "(//android.widget.TextView[@resource-id=\"android:id/text1\"])")
    public List<WebElement> list_viewsPageOptionList;







}
