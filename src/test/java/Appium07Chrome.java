import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class Appium07Chrome {
    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("appPackage","com.android.chrome");
        capabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");
        //capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

        capabilities.setCapability("noReset", "true");
        //noReset app izin almadan yukle ve ac demek
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Thread.sleep(4000);
        driver.get("https://www.amazon.com");
        System.out.println("app acildigindaki tur "+ driver.getContext());
        //burda aplikasyonun hangi turleri oldugunu gormek  icin getContextHandles() kullaniyoruz.
        Set contextNames=driver.getContextHandles();
        //burada mevcut app turunu (context) bir bir yazdiriyoruz

        for (Object contextName : contextNames) {
            System.out.println(contextName);//natıve app  chromıum yani hibrit
            if (contextName.toString().contains("NATIVE_APP")) {
                //altaki kod hangi app turunde calisacaksak onu set ediyoruz
                driver.context((String) contextName);//WEBAPP devam edecegim anlamina geliyor
                Thread.sleep(10000);
            }
        }
        //artik set ettigimiz context ile test devam ediyor
        System.out.println("2 " + driver.getContext()); // 2 NATIVE_APP -->webapp
        //https://developer.chrome.com/docs/devtools/remote-debugging/
        //chrome://inspect/#devices
        //sing in butonunu tikla
        Thread.sleep(6000);
        //android.view.View[@content-desc='Sign in ›']/android.widget.TextView
        driver.findElementByXPath("(//android.view.View)[9]").click();
        //driver.findElementByXPath("//android.view.View[@content-desc='Sign in ›']/android.widget.TextView").click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElementByXPath("//android.view.View[@text='Welcome']").isDisplayed());
        Thread.sleep(3000);
        System.out.println("3 " + driver.getContext()); // 3 NATIVE_APP
        driver.quit();
    }
}
