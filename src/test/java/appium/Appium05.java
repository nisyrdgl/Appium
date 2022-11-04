package appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium05 {
    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Administrator\\IdeaProjects\\appiumProject\\src\\Apps\\Calculator.apk");

        capabilities.setCapability("noReset", "true");
        //noReset app izin almadan yukle ve ac demek
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Thread.sleep(4000);
        /*
        install app
        do eny metametical operation
        and verify pre result and final result
        15*3=45
         */
        //15 tikla
        driver.findElementById("com.google.android.calculator:id/digit_1").click();
        Thread.sleep(2000);
        driver.findElementById("com.google.android.calculator:id/digit_5").click();
        Thread.sleep(2000);
        // * carpi tikla
        driver.findElementByXPath("//android.widget.Button[@content-desc=\"çarpı\"]").click();
        Thread.sleep(2000);
        //3 'u tikla
        driver.findElementById("com.google.android.calculator:id/digit_3").click();
        Thread.sleep(2000);

        String actualNumber=driver.findElementById("com.google.android.calculator:id/result_preview").getText();
        Thread.sleep(2000);
        Assert.assertEquals(actualNumber,"45");
        Thread.sleep(2000);

        driver.findElementById("com.google.android.calculator:id/eq").click();
        Thread.sleep(2000);
        String expecdetNumber=driver.findElementById("com.google.android.calculator:id/result_final").getText();
        Thread.sleep(2000);
        Assert.assertEquals(actualNumber,expecdetNumber);
        System.out.println("exp " + expecdetNumber);
        System.out.println("ac " + actualNumber);
        driver.unlockDevice();



    }
}
