package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Appium14BrowserStackAndroid {
    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "xowat_OMivft");
        caps.setCapability("browserstack.key", "NBPsc9K2rrZr1Usb3r96");

        // Set URL of the application under test
        caps.setCapability("app", "bs://039bf96d2897d9afc731a0bfc52fa29413644b45");
        // Specify device and os_version for testing
        caps.setCapability("platformName", "android");
        caps.setCapability("device", "Samsung Galaxy S10");
        caps.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");
        caps.setCapability("noReset", "true");

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
                new URL("http://hub.browserstack.com/wd/hub"), caps);

        // Write your test case statements here
        Thread.sleep(7000);
       driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
        Thread.sleep(2000);
       driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        Thread.sleep(2000);

       driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();

        List<AndroidElement> list = driver.findElementsByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"WiFi settings\").enabled(false)");
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
        driver.findElementByXPath("//android.widget.Button[@text='OK']").click();
        Thread.sleep(2000);
        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();

    }
    }

