package appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium15BrowserStackIOS {
    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "xowat_OMivft");
        caps.setCapability("browserstack.key", "NBPsc9K2rrZr1Usb3r96");

        // Set URL of the application under test
        caps.setCapability("app", "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d");

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

        // Test case for the BrowserStack sample iOS app.
        // If you have uploaded your app, update the test case here.
        String expecdetText = "IOS testing";
        //text butonunu tıkla
        driver.findElementByAccessibilityId("Text Button").click();
        //text butonuna metin gönder
        driver.findElementByAccessibilityId("Text Input").sendKeys("IOS testing");
        // Return tuşuna tıkla
        driver.findElementByAccessibilityId("Return").click();
        //UIElement yazızını assert et
        String actualText = driver.findElementByAccessibilityId("Text Output").getText();
        Assert.assertEquals(actualText, expecdetText);
        //ana sayfaya geri don
        driver.findElementByXPath("(//XCUIElementTypeButton[@name=\"UI Elements\"])[1]").click();
        //ana sayfaya geri dondugunu assert et
        Assert.assertEquals(driver.findElementByXPath("//XCUIElementTypeOther[@name=\"UI Elements\"]").getText(), "UI Elements");
        //Allert butonunu tıkla
        driver.findElementByAccessibilityId("Alert Button").click();
        //Allert yazısını assert et
        Assert.assertEquals(driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Alert\"]").getText(), "Alert");
        //ok butonuna tıkla
        driver.findElementByXPath("//XCUIElementTypeButton[@name=\"OK\"]").click();
        //ana sayfaya geri dondugunu assert et
        Assert.assertEquals(driver.findElementByXPath("//XCUIElementTypeOther[@name=\"UI Elements\"]").getText(), "UI Elements");


        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();
    }
}

