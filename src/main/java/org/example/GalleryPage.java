package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GalleryPage {

    private WebDriver driver;

    public GalleryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//android.widget.TextView[@resource-id=\"android:id/text1\"])")
    public List<WebElement> list_galleryPageOptionList;

    @FindBy(xpath = "//android.widget.Gallery[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView[1]")
    public WebElement img_firstPhoto;


}
