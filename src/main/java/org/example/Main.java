package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {

        @Test
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


}