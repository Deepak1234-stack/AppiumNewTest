package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {

         @Test(enabled = false, description = "")
        public void LaunchApk() throws MalformedURLException, URISyntaxException, InterruptedException {

            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName("DeepakPhone");
            options.setPlatformName("Android");
            options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
            options.setApp("D:\\QATestApp-1.1.apk");
            AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
            HomePage oHomePage = new HomePage(driver);
            oHomePage.input_userName.sendKeys("helloworld@gmail.com");
            oHomePage.input_password.sendKeys("testing1234");
            oHomePage.button_startTest.click();
            Thread.sleep(5000);
            Assert.assertTrue(true,"Logged In");

            //Registration

            RegistrationPage oRegistrationPage= new RegistrationPage(driver);

            oRegistrationPage.input_name.sendKeys("Deepak");
            oRegistrationPage.input_email.sendKeys("deepak@1234");
            oRegistrationPage.input_phoneNumber.sendKeys("7777777777");
            oRegistrationPage.input_subscribeCheck.click();
            Thread.sleep(2);
            oRegistrationPage.button_submit.click();
            Assert.assertTrue(true,"Registration Done");


        }

        @Test(enabled = true, description = "")
        public void secondAssignment() {

             try{
                 UiAutomator2Options options = new UiAutomator2Options();
                 options.setDeviceName("DeepakPhone");
                 options.setPlatformName("Android");
                 options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
                 options.setApp("D:\\ApiDemos-debug.apk");
                 AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
                 System.out.println("App Launched Successfully");
                 AccessibilityPage oAccessibilityPage = new AccessibilityPage(driver);
                 oAccessibilityPage.link_accessibilityLink.click();
                 System.out.println("Accessibility Option Clicked");
                 Thread.sleep(2000);
                 oAccessibilityPage.link_accessibilityNodeProviderLink.click();
                 System.out.println("Accessibility Node Provider Option Clicked Under Accessibility");
                 Thread.sleep(3000);
                 oAccessibilityPage.image_colorView.click();
                 System.out.println("Color Options Clicked In Accessibility Node Provider");
                 Thread.sleep(2000);
                 System.out.println("No Forward Options Are there");
                 driver.navigate().back();
                 Thread.sleep(2000);
                 oAccessibilityPage.link_accessibilityNodeQueryingLink.click();
                 System.out.println("Accessibility Node Querying Option Clicked Under Accessibility");
                 Thread.sleep(3000);
                 String status = "";

                 for(WebElement eTask : oAccessibilityPage.list_taskList){
                     int index = oAccessibilityPage.list_taskList.indexOf(eTask);
                     String taskText = eTask.getText();
                     System.out.println(taskText+" Task Displayed In Accessibility Node Querying");
                     String isChecked = oAccessibilityPage.list_taskCheckboxList.get(index).getDomAttribute("checked");
                     if(isChecked.equals("true")){
                         status = " Selected";
                     }else{
                         status = " Unselected";
                         // Selecting Unselected checkbox
                         oAccessibilityPage.list_taskCheckboxList.get(index).click();
                         Thread.sleep(1000);
                     }
                     System.out.println(taskText+" Check Box is Displayed And "+status +" By Default");

                 }


                 // Validating All Check Box are Selected

                 for(WebElement eTask : oAccessibilityPage.list_taskCheckboxList){
                     int index = oAccessibilityPage.list_taskCheckboxList.indexOf(eTask);
                     String isChecked = eTask.getDomAttribute("checked");
                     String taskText = oAccessibilityPage.list_taskList.get(index).getText();
                     if(isChecked.equals("true")){
                         status = " Selected";
                     }else{
                         status = " Unselected";
                     }
                     System.out.println(taskText+" Check Box is "+status +" After Click");

                 }

                 // Unselecting Check Box
                 for(WebElement eTask : oAccessibilityPage.list_taskCheckboxList){
                    eTask.click();
                     Thread.sleep(1000);
                 }


                 for(WebElement eTask : oAccessibilityPage.list_taskCheckboxList){
                     int index = oAccessibilityPage.list_taskCheckboxList.indexOf(eTask);
                     String isChecked = eTask.getDomAttribute("checked");
                     String taskText = oAccessibilityPage.list_taskList.get(index).getText();
                     if(isChecked.equals("true")){
                         status = " Selected";
                     }else{
                         status = " Unselected";
                     }
                     System.out.println(taskText+" Check Box is "+status +" After Unselecting");
                 }


                 driver.navigate().back();
                 Thread.sleep(2000);

                 oAccessibilityPage.link_accessibilityCustomViewLink.click();
                 System.out.println("Custom View Option Clicked Under Accessibility");
                 Thread.sleep(3000);

                 for(WebElement eTask : oAccessibilityPage.list_customCheckBoxList){
                     boolean check = eTask.isDisplayed();
                     Thread.sleep(1000);
                     if(check){
                         System.out.println("Custom Box Check Box Displayed");
                     }else {
                         System.out.println("Custom Box Check Box Not Displayed");

                     }

                 }






             }catch (Exception e){
                 e.printStackTrace();
             }

    }


}