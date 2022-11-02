import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium02 {
    @Test
    public void test01() throws InterruptedException, MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Administrator\\IdeaProjects\\appiumProject\\src\\Apps\\gestureTool.apk");
        //capabilities.setCapability("appPackage","com.touchboarder.android.api.demos");
      //  capabilities.setCapability("appActivity","com.touchboarder.androidapidemos.MainActivity");
        // app acılırken izin istediginde appPackage ve appActivity tanimlayarak bu sorunu gecebilirsiniz
        capabilities.setCapability("noReset", "true");
        //noReset app izin almadan yukle ve ac demek
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Thread.sleep(4000);

          //id ile bulduk
         // driver.findElementById("com.davemac327.gesture.tool:id/addButton").click();
         // id bu sekilde de bulunur
         // driver.findElementById("addButton").click();
        //xpath index ile
        // driver.findElementByXPath("(//android.widget.Button)[1]").click();
        //xpath text ile elementi bulma
        driver.findElementByXPath("//android.widget.Button[@text='Add gesture']").click();
       // driver.unlockDevice();
    }
}
