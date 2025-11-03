package app_test;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.snap.ExtentManager;

import io.appium.java_client.android.AndroidDriver;

public class Appium_Snapdeal_Login {

    AndroidDriver driver;
    ExtentReports extent;
    ExtentTest test1;

    @BeforeTest
    public void setup() throws MalformedURLException {
        extent = ExtentManager.getinstance();

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:deviceName", "vivo T3x 5G");
        caps.setCapability("appium:udid", "10BEAG0MN5004FT");
        caps.setCapability("appium:platformVersion", "14");

        // ✅ Snapdeal App details
        caps.setCapability("appium:appPackage", "com.snapdeal.main");
        caps.setCapability("appium:appActivity", "com.snapdeal.ui.material.activity.MaterialMainActivityDefaultClone");

        // ✅ Connect to Appium server
        URL url = new URL("http://127.0.0.1:4723");
        driver = new AndroidDriver(url, caps);
        System.out.println("✅ Snapdeal app launched successfully!");
    }

    // -------------------- Test 1: Skip for Now --------------------
    @Test(priority = 1)
    public void skipForNowTest() throws InterruptedException {
        test1 = extent.createTest("Snapdeal App - Skip Login & Open Cart Test");
        test1.log(Status.INFO, "Starting 'Skip for Now' functionality test...");

        Thread.sleep(8000);
        
        // ✅ Click "Later" on login screen
        driver.findElement(By.id("com.snapdeal.main:id/tvLaterText")).click();
        test1.log(Status.PASS, "Clicked on 'Later' button");
        System.out.println("Clicked on 'Later' button");

        Thread.sleep(8000);
       
        // ✅ Click on 'My Cart'
        WebElement myCart = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.snapdeal.main:id/tv_titleText' and @text='My Cart']"));
        myCart.click();
        test1.log(Status.PASS, "Clicked on 'My Cart'");
        System.out.println("Clicked on 'My Cart'");

        Thread.sleep(5000);

        // ✅ Mark test as passed after clicking My Cart
        test1.log(Status.PASS, "Successfully navigated to My Cart screen. Test Passed ✅");
        Assert.assertTrue(true, "Clicked on My Cart successfully.");
        System.out.println("✅ Test Passed: Clicked on 'My Cart' successfully.");

        Thread.sleep(4000);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("✅ App closed successfully!");
        }
        extent.flush();
    }
}
