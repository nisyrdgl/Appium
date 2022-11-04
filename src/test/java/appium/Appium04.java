package appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium04 {
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
        /*
        lunch Gesturetool app
        click addGesture button
        clic done
        verify testing gesture is created
         */
        //Add gesture yi tikla
        driver.findElementByXPath("//android.widget.Button[@text='Add gesture']").click();
        Thread.sleep(4000);
        //metin gonder
        driver.findElementById("com.davemac327.gesture.tool:id/gesture_name").sendKeys("Esat");
        Thread.sleep(2000);
        //ekranda bos bir yere tikla
        driver.findElementById("com.davemac327.gesture.tool:id/gestures_overlay").click();
        Thread.sleep(2000);
        //done butonunu tikla
        driver.findElementById("com.davemac327.gesture.tool:id/done").click();
        Thread.sleep(2000);
        // Esat gesture'yi assert et
       String actualText= driver.findElementByXPath("//android.widget.TextView[@text='Esat']").getText();
       String ecpecdettext="Esat";
        Assert.assertEquals(actualText,ecpecdettext);
        driver.unlockDevice();
    }
}
