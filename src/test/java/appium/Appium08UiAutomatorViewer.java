package appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium08UiAutomatorViewer {
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
        //UI Automator Viewer ile locat alma
        driver.findElementByXPath("//android.widget.Button[@text='4']").click();
        driver.findElementByXPath("//android.widget.Button[@text='4']").click();
        driver.findElementByXPath("//android.widget.Button[@text='4']").click();


    }
}
