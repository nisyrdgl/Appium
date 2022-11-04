package appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium03 {
    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Administrator\\IdeaProjects\\appiumProject\\src\\Apps\\gestureTool.apk");

        capabilities.setCapability("noReset", "true");
        //noReset app izin almadan yukle ve ac demek
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Thread.sleep(4000);
        driver.findElementById("com.davemac327.gesture.tool:id/testButton").click();
        Thread.sleep(4000);
        String expecdetTitle="Test a gesture";
       String acualTitle= driver.findElementById("android:id/title").getText();
        Assert.assertEquals(acualTitle,expecdetTitle);
        driver.unlockDevice();
        /*
        lunch GesttureTool app
        click test button
        verify title "Test a gestrue"
        close app

         */

    }
}
