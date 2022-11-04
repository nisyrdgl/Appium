package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import utilities.AppiumBase;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Appium11 extends AppiumBase {
    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        AndroidDriver driver = androidDriver();
        //API demos tikla
        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
        Thread.sleep(2000);
        //Preference tikla
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        Thread.sleep(2000);
        //3. Preference dependencies tikla
        driver.findElementByXPath("//*[@text='3. Preference dependencies']").click();
        Thread.sleep(3000);
        //WiFi butonu tikli degilse tikla
        //check bosx a gore
      /* String isChecked=driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.CheckBox\").checkable(true)").getAttribute("checkable");
        if(isChecked.equals("false")){
            driver.findElementById("android:id/checkbox").click();
        }*/
        //WiFi Setting gorunurlulugune gore
        List<MobileElement> list = driver.findElementsByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"WiFi settings\").enabled(false)");
        Thread.sleep(2000);
        if (list.size() > 0) {
            String isEnabled = driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"WiFi settings\").enabled(false)").getAttribute("enabled");
            if (isEnabled.equals("false")) {
                driver.findElementById("android:id/checkbox").click();
            }
        }
        //WiFi settings tikla ve metin gonder
        driver.findElementByXPath("//*[@text='WiFi settings']").click();
        Thread.sleep(2000);
        driver.findElementById("android:id/edit").sendKeys("Rana");
        Thread.sleep(2000);
        //Tamam i tikla
        driver.findElementByXPath("//android.widget.Button[@text='TAMAM']").click();
        Thread.sleep(2000);
        driver.quit();


    }
}
