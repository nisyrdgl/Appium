package appium;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;
import utilities.AppiumBase;

import java.net.MalformedURLException;
import java.time.Duration;

public class Appium12Scroll extends AppiumBase {


    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        AndroidDriver driver =androidDriver();
        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
        Thread.sleep(2000);
        // Views'i tikla
        driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"Views\")").click();
        Thread.sleep(2000);
        Dimension dimension =driver.manage().window().getSize(); // cihazin olcusunu yani ekran olculerini aldik
        // baslangic olculeri
        int start_x = (int) (dimension.width * 0.5);
        int start_y = (int) (dimension.height * 0.8);
        // bitis noktasi
        int end_x = (int) (dimension.width*0.5);
        int end_y = (int) (dimension.height*0.2);
        TouchAction   touchAction = new TouchAction<>(driver);

        touchAction.press(PointOption.point(start_x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(end_x,end_y)).release().perform();


    }


}
