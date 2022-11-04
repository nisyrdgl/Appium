package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium1 {
    @Test

    public void test01() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Administrator\\IdeaProjects\\appiumProject\\src\\Apps\\Amazon Shopping Search Find Ship and Save_v22.2.0.100_apkpure.com.apk:");
       //capabilities.setCapability("appPackage","com.touchboarder.android.api.demos");
        //capabilities.setCapability("appActivity","com.touchboarder.androidapidemos.MainActivity");
        // app acılırken izin istediginde appPackage ve appActivity tanimlayarak bu sorunu gecebilirsiniz
        capabilities.setCapability("noReset", "true");
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Thread.sleep(4000);
        driver.unlockDevice();
        /*
        eger telefon kullanmak istiyorsaniz develepor
         */
    }
}
