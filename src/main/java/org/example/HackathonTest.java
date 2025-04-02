package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.net.URL;
import java.sql.DriverManager;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class HackathonTest {
    ViewPage oViewPage ;
    ExpandableListPage oExpandableListPage ;
    CustomAdapterPage oCustomAdapterPage;
    GalleryPage oGalleryPage;

    AnimationPage oAnimationPage ;

    AppPage oAppPage ;

    AlertDialoguePage oAlertDialoguePage ;

    static AndroidDriver driver ;

    static String repeatAlarmOptions[] = {"Every Monday","Every Tuesday","Every Wednesday","Every Thursday","Every Thursday","Every Saturday","Every Saturday"};

    @Test(enabled = true, description = "")
    public void longPressGestureAssignment() {
        try{
            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName("DeepakPhone");
            options.setPlatformName("Android");
            options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
            options.setApp("D:\\ApiDemos-debug.apk");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
            System.out.println("App Launched Successfully");
            Thread.sleep(5000);
             oViewPage = new ViewPage(driver);
             oExpandableListPage = new ExpandableListPage(driver);
             oCustomAdapterPage = new CustomAdapterPage(driver);
             oGalleryPage = new GalleryPage(driver);
             oAnimationPage = new AnimationPage(driver);

             // Validating Long Press
            clickElement(oViewPage.link_viewsPageLink,"View Option Clicked");

            selectElementFromList(oViewPage.list_viewsPageOptionList,"Expandable Lists");
            System.out.println("Expandable Lists Option Clicked In Views");

            selectElementFromList(oExpandableListPage.list_expandableListPageOptionList,"1. Custom Adapter");
            System.out.println("Custom Adapter Option Clicked In Expandable List");

            for(WebElement eCustomElement :oCustomAdapterPage.list_customAdapterPageOptionList){
                String customOptionText = eCustomElement.getText();
                if(customOptionText.equals("Cat Names")){
                    new Actions(driver).clickAndHold(eCustomElement).perform();
                   System.out.println("Long Pressed Cat Names");
                    Thread.sleep(1000);
                    break;
                }
            }

            clickElement(oCustomAdapterPage.option_sampleAction,"Sample Action Option Clicked In Cat Names ");
            driver.navigate().back();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);

            //Validating Scroll

            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"WebView3\"))")).isDisplayed();
            System.out.println("Scrolled To WebView3 in Views");
            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Animation\"))")).isDisplayed();
            System.out.println("Scrolled To Animation in Views");

            //Validating Swipe

            selectElementFromList(oViewPage.list_viewsPageOptionList,"Gallery");
            System.out.println("Gallery Option Clicked In Views");

            selectElementFromList(oGalleryPage.list_galleryPageOptionList,"1. Photos");
            System.out.println("1. Photos Option Clicked In Gallery");

            Point pt = oGalleryPage.img_firstPhoto.getLocation();
            for(int i = 0;i<5;i++){
                swipeLeft(pt);
            }
            System.out.println("SWipe Photo from left to right");

            driver.navigate().back();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);

            //Validating Tap

            clickElement(oAnimationPage.link_animationLink,"Animation Option Clicked");

            selectElementFromList(oViewPage.list_viewsPageOptionList,"View Flip");
            System.out.println("View Flip Option Clicked In Animation");

            ArrayList<String> beforeFlip = new ArrayList<>();
            for(WebElement eViewElement :oAnimationPage.list_flipListPageOptionList){
                String optionText = eViewElement.getText();
                beforeFlip.add(optionText);
            }

            tap(oAnimationPage.button_flipButton,"Flip");
            Thread.sleep(2000);


            for(WebElement eViewElement :oAnimationPage.list_flipListPageOptionList){
                String optionText = eViewElement.getText();
                if(optionText.equalsIgnoreCase("Un")){
                    System.out.println("Flip Button Clicked and Working");
                    break;
                }
            }

            driver.navigate().back();
            Thread.sleep(1000);
            driver.navigate().back();
            Thread.sleep(1000);


            //validating Drag And Drop

            DragAndDropPage oDragAndDropPage = new DragAndDropPage(driver);
            clickElement(oViewPage.link_viewsPageLink,"View Option Clicked");
            selectElementFromList(oViewPage.list_viewsPageOptionList,"Drag and Drop");
            System.out.println("Drag and Drop Clicked In Views");

            dragAndDrop(oDragAndDropPage.img_firstDot,oDragAndDropPage.img_secondDot);
            System.out.println("Drag Photo 1  and Drop to Photo 2");
            Thread.sleep(1000);

            driver.navigate().back();
            Thread.sleep(2000);





        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test(enabled = true, description = "")
    public void alertHandlingAssignment() {
        try{
            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName("DeepakPhone");
            options.setPlatformName("Android");
            options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
            options.setApp("D:\\ApiDemos-debug.apk");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
            System.out.println("App Launched Successfully");
            Thread.sleep(5000);
            oAppPage = new AppPage(driver);
            oAlertDialoguePage = new AlertDialoguePage(driver);
            clickElement(oAppPage.link_appLink, "App Link Clicked");

            selectElementFromList(oAppPage.list_appListPageOptionList,"Alert Dialogs");
            System.out.println("Alert Dialogs Option Clicked In App");

            //Validating First alert and print message
            clickElement(oAlertDialoguePage.alert_cancelWithMessage,"Cancel With Message");
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println("Alert Message Displayed as "+alertText);
            alert.accept();

            //Validating Single Choice alert and select Street View message

            clickElement(oAlertDialoguePage.alert_singleChoiceList,"Single Choice List Alert Clicked");
            alert = driver.switchTo().alert();
            clickElement(oAlertDialoguePage.radio_streetViewButton,"Street View Radio Button Clicked");
            alert.accept();
            Thread.sleep(2000);
            clickElement(oAlertDialoguePage.alert_singleChoiceList,"Single Choice List Alert Clicked");
            alert = driver.switchTo().alert();
            String isChecked = oAlertDialoguePage.radio_streetViewButton.getDomAttribute("checked");
            if(isChecked.equals("true")){
                System.out.println("Street View Radio button Saved");
            }else {
                System.out.println("Street View Radio button not Saved");
            }
            alert.accept();
            Thread.sleep(2000);

            //Validating  Text Entry Alert and Enter details

            clickElement(oAlertDialoguePage.alert_textEntryDialog,"Text Entry Dialogue Alert Clicked");
            alert = driver.switchTo().alert();
            oAlertDialoguePage.input_nameInEntryDialogue.clear();
            oAlertDialoguePage.input_nameInEntryDialogue.sendKeys("Deepak");
            oAlertDialoguePage.input_passwordInEntryDialogue.clear();
            oAlertDialoguePage.input_passwordInEntryDialogue.sendKeys("Health222");
            System.out.println("Name Entered as Deepak");
            System.out.println("Password Entered as Health222");
            alert.accept();
            Thread.sleep(2000);
            System.out.println("Saved Information In Entry Dialogue");

            // Validating Repeat Alarm Alert
            clickElement(oAlertDialoguePage.alert_repeatAlarm,"Repeat Alarm Alert Clicked");
            alert = driver.switchTo().alert();
            for(WebElement element : oAlertDialoguePage.list_repeatAlarmPageOptionList){
                String optionText = element.getText();
                 isChecked = element.getDomAttribute("checked");

                if(optionText.contains("Saturday") || optionText.contains("Sunday")){
                    if(isChecked.equals("true")){
                        clickElement(element,optionText+" Unchecked From List");
                    }else{
                        System.out.println(optionText+" is already unchecked");
                    }
                }else {
                    if(isChecked.equals("false")){
                        clickElement(element,optionText+" Checked From List");
                    }else{
                        System.out.println(optionText+" is already checked");
                    }
                }

            }
            alert.accept();
            Thread.sleep(2000);
            clickElement(oAlertDialoguePage.alert_repeatAlarm,"Repeat Alarm Alert Clicked");
            for(WebElement element : oAlertDialoguePage.list_repeatAlarmPageOptionList){
                String optionText = element.getText();
                 isChecked = element.getDomAttribute("checked");
                if(optionText.contains("Saturday") || optionText.contains("Sunday")){
                    if(isChecked.equals("false")){
                        System.out.println(optionText+" is Unchecked");
                    }else{
                        System.out.println(optionText+" is checked incorrectly");
                    }
                }else {
                    if(isChecked.equals("true")){
                        System.out.println(optionText+" Selected From List");
                    }else{
                        System.out.println(optionText+" is unchecked incorrectly ");
                    }
                }

            }
            alert.accept();









        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public static boolean clickElement(WebElement element,String text) throws Exception {
        boolean flag = false;

        try {
//			Cls_Generic_Methods.scrollToElementByJS(element);
            element.click();
            Thread.sleep(2000);
            flag = true;
            System.out.println(text);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Element not clicked " + e);
        }

        return flag;
    }

    public static void swipe(AndroidDriver driver) {
        // Get screen width and height
        int screenWidth = driver.manage().window().getSize().getWidth();
        int screenHeight = driver.manage().window().getSize().getHeight();

        // Starting and ending points for swipe (left to right)
        int startX = (int) (screenWidth * 0.1); // 10% of screen width
        int endX = (int) (screenWidth * 0.9); // 90% of screen width
        int startY = screenHeight / 2; // middle of screen height

        // Perform the swipe action
        new TouchAction<>(driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))) // Optional wait
                .moveTo(PointOption.point(endX, startY))
                .release()
                .perform();
    }

    public static void swipeLeft(Point point) {



        try {
            PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

            Sequence sequence = new Sequence(finger1, 1)
                    .addAction(finger1.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), point.getX(), point.getY()))
                    .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(new Pause(finger1, Duration.ofMillis(100)))
                    .addAction(finger1.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), 0, point.getY()))
                    .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Collections.singletonList(sequence));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void tap(WebElement element,String elementName){
        try {
            Point location = element.getLocation();
            Dimension size = element.getSize();
            Point center = centerOfGravity(location,size);

            PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH,"finger1");

            Sequence sequence=new Sequence(finger1,1)
                    .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),center))
                    .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(new Pause(finger1,Duration.ofMillis(300)))
                    .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Collections.singletonList(sequence));


        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static Point centerOfGravity(Point location,Dimension size){
        return new Point(location.getX()+ size.width/2, location.getY()+size.height/2);
    }

    public static boolean selectElementFromList(List<WebElement> elementList, String text) throws Exception {
        boolean flag = false;

        try {

            for(WebElement element : elementList){
                String optionText = element.getText();
                if(optionText.equalsIgnoreCase(text)){
                    clickElement(element,optionText+" is selected");
                    flag = true;
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Element not clicked " + e);
        }

        return flag;
    }


    public static void dragAndDrop(WebElement source,WebElement destination){
    }

}
