package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium10 {
    @Test
    public void test01() throws MalformedURLException, InterruptedException {


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Administrator\\IdeaProjects\\appiumProject\\src\\Apps\\apiDemos.apk");
        //capabilities.setCapability("appPackage","com.touchboarder.android.api.demos");
        //capabilities.setCapability("appActivity","com.touchboarder.androidapidemos.MainActivity");
        // app acılırken izin istediginde appPackage ve appActivity tanimlayarak bu sorunu gecebilirsiniz
        capabilities.setCapability("noReset", "true");
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Thread.sleep(4000);
             /*
        app ac(API Demos)
        APi demos
        Preference
        sonra Preference form code
        =>tkla Checkbox preference ve onayla
        =>Edit text preference tikla
        yazi yaz ve OK tikla
        => List preference tikla ce Option2 sec
         */
        //Api Demos tikla
        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
        Thread.sleep(2000);
        // Preference tikla
        driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"Preference\")").click();
        Thread.sleep(2000);
        //Preference form code tikla
        driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"5. Preferences from code\")").click();
        Thread.sleep(2000);
        //Checkbox preference ve onayla
        driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.CheckBox\")").click();
        Thread.sleep(2000);
        //Edit text preference tikla
        driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"Edit text preference\")").click();
        Thread.sleep(2000);
        //Metin gonder ve tamam tikla
        driver.findElementById("android:id/edit").sendKeys("Ali");
        Thread.sleep(2000);
        driver.findElementByXPath("//android.widget.Button[@text='TAMAM']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//android.widget.TextView[@text='List preference']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("(//android.widget.CheckedTextView)[2]").click();

    }
}

