package com.cmi.jegotrip;

import junit.framework.TestCase;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class BasicTest {
    protected AppiumDriver wd;
    protected static String PHONE_NUMBER;
    protected static String PASSWORD;

    @Before
    public void setUp() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        setupCapabilities(capabilities);

        try {
            wd = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
                    capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    /*
     * Setup the test device and package
     * Create your own device or emulator device.json file
     * Please don't check in your device.json file
     * Here is a sample device.json file:
     *  {
     *       "deviceName":"VS9804G9f168b75",
     *       "platformVersion":"5.0",
     *       "app":"/Users/charlie/Downloads/jegotrip.apk",
     *       "user":"13636477219",
     *       "password":"123789"
     *  }
     *
     */

    private void setupCapabilities(DesiredCapabilities capabilities) {

        capabilities.setCapability("appium-version", "1.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.cmi.jegotrip");

        JSONParser parser = new JSONParser();
        try {
            JSONObject prof = (JSONObject) parser.parse(new FileReader
                    ("device.json"));
            setupProperties(prof, capabilities);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void setupProperties(JSONObject prof, DesiredCapabilities
            capabilities) {
        for (String k : ((Set<String>) prof.keySet())) {
            String v = (String) prof.get(k);
            if (null != v && v.length() > 0) {
                if (k.equals("user")) {
                    PHONE_NUMBER = v;
                } else if (k.equals("password")) {
                    PASSWORD = v;
                } else {
                    capabilities.setCapability(k, v);
                }
            }
        }
    }

    protected void back() {
        wd.navigate().back();
    }

    protected WebElement find(String xp) {
        return wd.findElement(By.xpath(xp));
    }

    protected WebElement findByName(String name) {
        return wd.findElementByName(name);
    }

    @After
    public void tearDown() {
        if (wd != null) {
            wd.quit();
        }
    }

    protected void loginByPhone() {
        //点击“我的”
        findByName("我的").click();

        //输入正确国家码
        // Fixed. Not an option for now

        //输入正确手机号
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.RelativeLayout[2]/android.widget.EditText[1]")
                .sendKeys("18801496855");

        //输入正确密码
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.EditText[1]").sendKeys("123456");




        //点击登录
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.TextView[2]").click();

        TestCase.assertNotNull(wd.findElementByName("用户名"));
    }
}

