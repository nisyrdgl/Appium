package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
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
        //1.yol
       List<MobileElement> check=driver.findElementsByXPath("(//android.widget.CheckBox)[1]");
        System.out.println(check.size());
        System.out.println(check.get(0).getAttribute("checked"));
        if(check.get(0).getAttribute("checked").equals("false")){
            check.get(0).click();
        }else {
            Assert.assertEquals(check.get(0).getAttribute("checked"),"true");
        }




        Thread.sleep(2000);
        //Edit text preference tikla
        driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"Edit text preference\")").click();
        Thread.sleep(2000);
        //Metin varsa sil
        driver.findElementById("android:id/edit").clear();
        Thread.sleep(2000);
        //Metin gonder ve tamam tikla
        driver.findElementById("android:id/edit").sendKeys("Esat");
        Thread.sleep(2000);
        driver.findElementByXPath("//android.widget.Button[@text='TAMAM']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//android.widget.TextView[@text='List preference']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("(//android.widget.CheckedTextView)[3]").click();

    }
    }

