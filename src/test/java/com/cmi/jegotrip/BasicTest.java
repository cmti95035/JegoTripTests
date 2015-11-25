package com.cmi.jegotrip;

import junit.framework.TestCase;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class BasicTest {
    protected AppiumDriver wd;

    protected static String PHONE_NUMBER;
    protected static String PHONE_NUMBER_MAL_FORMED;
    protected static String PHONE_NUMBER_UNREGISTERED;

    protected static String PASSWORD;
    protected static String PASSWORD_MAL_FORMED;
    protected static String PASSWORD_WRONG;

    protected static String USER_ID;
    protected static String USER_ID_WRONG;

    protected static String EMAIL;
    protected static String EMAIL_MAL_FORMED;
    protected static String EMAIL_UNREGISTERED;

    protected static String REGISTER_CODE;

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
        skipSplashIfPresent();
        //skipUpgradeIfPresent();
    }

    /*
     * Setup the test device and package
     * Create your own device or emulator device.json file
     * to overwrite the default one.
     * Please don't check in your device.json file.
     * Here is a sample device.json file:
    {
       "deviceName":"VS9804G9f168b75",
        "platformVersion":"5.0",
        "app":"/Users/charlie/Downloads/jegotrip.apk",
        "phone":"18801496855",
        "password":"123456",
        "mal_formed_phone":"188014968",
        "unregistered_phone":"13705715745",
        "mal_formed_password":"12345",
        "wrong_password":"123457",
        "user_id":"charlie",
        "wrong_user_id":"charles",
        "email":"charliehan@chinamobile.com",
        "mal_formed_email":"charliehan#chinamobile.com",
        "unregistered_email":"charliehan@gmail.com",
        "register_code":"GZH"
    }
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
                switch(k) {
                    case "phone": PHONE_NUMBER = v;
                        break;
                    case "password": PASSWORD = v;
                        break;
                    case "mal_formed_phone": PHONE_NUMBER_MAL_FORMED = v;
                        break;
                    case "unregistered_phone": PHONE_NUMBER_UNREGISTERED = v;
                        break;
                    case "mal_formed_password": PASSWORD_MAL_FORMED = v;
                        break;
                    case "wrong_password": PASSWORD_WRONG = v;
                        break;
                    case "user_id": USER_ID = v;
                        break;
                    case "wrong_user_id": USER_ID_WRONG = v;
                        break;
                    case "email": EMAIL = v;
                        break;
                    case "mal_formed_email": EMAIL_MAL_FORMED = v;
                        break;
                    case "unregistered_email": EMAIL_UNREGISTERED = v;
                        break;
                    case "register_code": REGISTER_CODE = v;
                        break;
                    default: capabilities.setCapability(k, v);
                        break;
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

    protected void hideKeyboard(String caller) {
        try {
            wd.hideKeyboard();
        } catch(Exception e) {
            System.out.println("Soft keyboard is not present in " + caller);
        }
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
                .sendKeys(PHONE_NUMBER);

        //输入正确密码
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.EditText[1]").sendKeys(PASSWORD);
        hideKeyboard("loginByPhone");

        //点击登录
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.TextView[2]").click();

        TestCase.assertNotNull(wd.findElementByName("用户名"));
    }

    private void skipSplashIfPresent() {
        WebElement el = find("//android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".FrameLayout[1]/android.widget.RelativeLayout[1]/android" +
                ".widget.TextView[1]");
        if (el != null) {
            el.click();
        }
    }

    /**
     * If upgrade dialog is not present, UiAnimator will shutdown
     * So it works for upgrade case, but not work for normal case
     * Need further tuning
     */
    private void skipUpgradeIfPresent() {
        WebElement el = null;

        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        try {
            el =  wd.findElement(By.xpath("//android.widget.FrameLayout[1]/android" +
                            ".widget.FrameLayout[1]/android.widget" +
                            ".LinearLayout[1]/android.widget.LinearLayout[2]/android" +
                            ".widget.Button[1]"));
        } finally {
            if (el != null) {
                el.click();
            }
        }
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
}

