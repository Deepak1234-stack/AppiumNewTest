package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AnimationPage {

    private WebDriver driver;

    public AnimationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Animation\"]")
    public WebElement link_animationLink;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Flip\"]")
    public WebElement button_flipButton;

    @FindBy(xpath = "(//android.widget.TextView[@resource-id=\"android:id/text1\"])")
    public List<WebElement> list_flipListPageOptionList;



}
