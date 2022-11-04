import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Appium09Uiselector {
    @Test
    public void test01() throws MalformedURLException, InterruptedException {
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
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Thread.sleep(4000);
        //UiSelectorda ' kullanamiyoruz " kullanmamiz gerekiyor
        //resourceId
        //driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\")").click();
        //className() ile
        // driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\")").click();

        // className() text ile
        //  driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"Add gesture\")").click();
        // className() index ile
     /*   driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").index(1)").click();
     // birden fazla classname element varsa list e atilip islem yapilir
        List<MobileElement> buttons=driver.findElementsByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\")");
        for (MobileElement bottun : buttons) {
            if (bottun.getText().equals("Add gesture")){
                 bottun.click();
                 break;

        }

        }*/
        // icerdigi kelime ile elementi bulma
        //driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").textContains(\"load\")").click();
     //   Thread.sleep(3000);
        // baslangis harfi ile bulma
       // driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").textStartsWith(\"Te\")").click();
       // Thread.sleep(3000);

       // UiSelector ile kullanilan methodlar
        System.out.println(driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\").checkable(false)").getAttribute("checkable"));

        System.out.println(driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\").clickable(true)").getAttribute("clickable"));

        // driver.quit();


    }
}
