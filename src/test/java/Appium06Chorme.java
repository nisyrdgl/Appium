import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class Appium06Chorme {
    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

        capabilities.setCapability("noReset", "true");
        //noReset app izin almadan yukle ve ac demek
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Thread.sleep(4000);
        driver.get("https://www.amazon.com");
        System.out.println("app acildigindaki tur "+ driver.getContext());
        //https://developer.chrome.com/docs/devtools/remote-debugging/
        //chrome://inspect/#devices
        //sing in butonunu tikla
        driver.findElementByXPath("//div[@id='nav-progressive-greeting']").click();
        Thread.sleep(3000);
       Assert.assertTrue(driver.findElementByXPath("//h2").isDisplayed());
        //burda aplikasyonun hangi turleri oldugunu gormek  icin getContextHandles() kullaniyoruz.
        Set contextNames=driver.getContextHandles();
        //burada mevcut app turunu (context) bir bir yazdiriyoruz

         for (Object contextName : contextNames) {
            System.out.println(contextName);
          if (contextName.toString().contains("CHROMIUM")) {
                driver.context((String) contextName);
            }
        }
         //artik set ettigimiz context ile test devam ediyor
        System.out.println("2 " + driver.getContext());
       driver.unlockDevice();

    }
}
