package appium;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium16BSSauceApp {
    @Test
    public void test01() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "xowat_OMivft");
        caps.setCapability("browserstack.key", "NBPsc9K2rrZr1Usb3r96");

        // Set URL of the application under test
        caps.setCapability("app", "bs://026053ccc9c1a05adbf8037bd7902a4a3996ed34");

        // Specify device and os_version for testing
        caps.setCapability("device", "iPhone XS");
        caps.setCapability("os_version", "12");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(
                new URL("http://hub-cloud.browserstack.com/wd/hub"), caps);

        // Write your test case statements here.
        driver.findElementByAccessibilityId("test-Username").sendKeys("standard_user");
        driver.findElementByAccessibilityId("test-Password").sendKeys("secret_sauce");
        driver.findElementByAccessibilityId("test-LOGIN").click();
        Assert.assertTrue(driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"PRODUCTS\"]").isDisplayed());
        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();
    }
    }

