package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import utilities.AppiumBase;

import java.net.MalformedURLException;
import java.util.List;

public class Appıum12 extends AppiumBase {


    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        AndroidDriver driver= androidDriver();
        //Api Demos tikla
        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
        Thread.sleep(2000);
        // Preference tikla
        driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"Preference\")").click();
        Thread.sleep(2000);
        //Preference form code tikla
        driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"5. Preferences from code\")").click();
        Thread.sleep(2000);
        //Checkbox preference ve onayla

        String isChecked = driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"android:id/checkbox\").checkable(true)").getAttribute("checked");
        System.out.println(isChecked+" <===========");
        if(isChecked.equals("false")) {
            driver.findElementById("android:id/checkbox").click();
            System.out.println("if calisti");
        }

        Thread.sleep(2000);
        //Edit text preference tikla
        driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"Edit text preference\")").click();
        Thread.sleep(2000);
        //Metin gonder ve tamam tikla
        driver.findElementById("android:id/edit").clear();
        Thread.sleep(2000);
        driver.findElementById("android:id/edit").sendKeys("Esat");
        Thread.sleep(2000);
        driver.findElementByXPath("//android.widget.Button[@text='TAMAM']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//android.widget.TextView[@text='List preference']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("(//android.widget.CheckedTextView)[3]").click();

    }
    }

