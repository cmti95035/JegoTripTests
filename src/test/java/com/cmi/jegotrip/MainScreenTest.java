package com.cmi.jegotrip;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class MainScreenTest {
    private AppiumDriver wd;
    private static String PHONE_NUMBER;
    private static String PASSWORD;

    @Before
    public void setUp() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        setupCapabilities(capabilities);

        try {
            wd = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
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

    private void setupProperties(JSONObject prof, DesiredCapabilities
            capabilities) {
        for (String k: ((Set<String>) prof.keySet())) {
            String v = (String) prof.get(k);
            if ( null!=v && v.length()>0) {
                if ( k.equals("user")) {
                    PHONE_NUMBER = v;
                } else if ( k.equals("password")) {
                    PASSWORD = v;
                } else {
                    capabilities.setCapability(k, v);
                }
            }
        }
    }

    @Test
    public void testMainScreen() throws Exception {

        WebElement el = wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]"));
        assertNotNull(el);
        assertEquals("JEGO TRIP", el.getText());

        el = wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]"));
        assertNotNull(el);
        assertEquals("无忧 无缝 无国界", el.getText());

        el = wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]"));
        assertNotNull(el);
        assertEquals("出行帮助台", el.getText());
        el.click();
        testBangzhuTai();
        wd.navigate().back();

        el = wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]"));
        assertNotNull(el);
        assertEquals("资费计算器", el.getText());
        el.click();
        testJiSuanQi();
        wd.navigate().back();

        el = wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.TextView[1]"));
        assertNotNull(el);
        assertEquals("拨号助手", el.getText());
        el.click();
        testBoHaoZhuShou();
        wd.navigate().back();

        el = wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.TabHost[1]/android.widget.LinearLayout[1]/android.widget.TabWidget[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]"));
        assertNotNull(el);
        assertEquals("无忧助手", el.getText());

        el = wd.findElement(By.xpath("//android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".FrameLayout[1]/android.widget.LinearLayout[1]/android" +
                ".widget.TabHost[1]/android.widget.LinearLayout[1]/android" +
                ".widget.TabWidget[1]/android.widget.LinearLayout[2]/android" +
                ".widget.TextView[1]"));
        assertNotNull(el);
        assertEquals("流量商店", el.getText());
        el.click();
        testLiuLiangShangDian();
        wd.navigate().back();

        el = wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.TabHost[1]/android.widget.LinearLayout[1]/android.widget.TabWidget[1]/android.widget.LinearLayout[3]/android.widget.TextView[1]"));
        assertNotNull(el);
        assertEquals("我的", el.getText());
        el.click();
        testWoDe();
        wd.navigate().back();
    }

    private void testBangzhuTai() throws Exception{
        WebElement el = wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.widget.TextView[1]"));
        assertNotNull(el);
        assertEquals("出行帮助台", el.getText());

        el = wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]"));
        assertNotNull(el);
        assertEquals("价格查询", el.getText());

        el = wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]"));
        assertNotNull(el);
        assertEquals("故障解决", el.getText());

        el = wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.TextView[1]"));
        assertNotNull(el);
        assertEquals("开通漫游", el.getText());
    }

    private void testJiSuanQi() throws Exception{
        WebElement el = wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.widget.TextView[1]"));
        assertNotNull(el);
        assertEquals("资费计算器", el.getText());

        el = wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]"));
        assertNotNull(el);
        assertEquals("您的使用情况", el.getText());

        el = wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]"));
        assertNotNull(el);
        assertEquals("我要去", el.getText());

        el = wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]"));
        assertNotNull(el);
        assertEquals("与国内通话需求", el.getText());

        el = wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]"));
        assertNotNull(el);
        assertEquals("计算结果", el.getText());

        el = wd.findElement(By.xpath("//android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".FrameLayout[1]/android.widget.LinearLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.LinearLayout[3]/android" +
                ".widget.TextView[1]\n"));
        assertNotNull(el);
        assertEquals("上网需求", el.getText());
    }

    private void testBoHaoZhuShou() throws Exception{
        WebElement el = wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.TextView[1]"));
        assertNotNull(el);
        assertEquals("拨号助手", el.getText());

        el = wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]"));
        assertNotNull(el);
        assertEquals("国际漫游免费客服热线", el.getText());

        el = wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]"));
        assertNotNull(el);
        assertEquals("当地热线", el.getText());

        /** Emergency number is optional
        el = wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]"));
        assertNotNull(el);
        assertEquals("紧急电话", el.getText());
        **/
    }

    private void testLiuLiangShangDian() throws Exception{
        WebElement el = wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.widget.TextView[1]"));
        assertNotNull(el);
        assertEquals("流量商店", el.getText());

        wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ListView[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]")).click();
        testLiuLiangBaoXiangQing();
        wd.navigate().back();
    }

    private void testLiuLiangBaoXiangQing() throws Exception {
        WebElement el = wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.widget.TextView[1]"));
        assertNotNull(el);
        assertEquals("流量包详情", el.getText());

        el = wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]"));
        assertNotNull(el);
        assertEquals("适用客户", el.getText());

        el = wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.TextView[1]"));
        assertNotNull(el);
        assertEquals("如何激活", el.getText());

        el = wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[3]/android.widget.RelativeLayout[1]/android.widget.TextView[1]"));
        assertNotNull(el);
        assertEquals("使用说明", el.getText());

        el = wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[4]/android.widget.RelativeLayout[1]/android.widget.TextView[1]"));
        assertNotNull(el);
        assertEquals("温馨提示", el.getText());
    }

    private void testWoDe() throws Exception{
        WebElement el = wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.widget.TextView[1]"));
        assertNotNull(el);
        assertEquals("去注册", el.getText());

        el = wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]"));
        assertNotNull(el);
        assertEquals("国家和地区", el.getText());

        el = wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[2]/android.widget.EditText[1]"));
        assertNotNull(el);
        assertEquals("手机号", el.getText());

        el = wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]"));
        assertNotNull(el);
        assertEquals("忘记密码", el.getText());

        el = wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]"));
        assertNotNull(el);
        assertEquals("手机号登录", el.getText());

        el = wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[3]"));
        assertNotNull(el);
        assertEquals("用户名/邮箱登录", el.getText());

        el = wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]"));
        assertNotNull(el);
        assertEquals("其他方式登录", el.getText());
    }

    private void testABC() throws Exception{

    }


    @After
    public void tearDown() {
        if (wd != null) {
            wd.quit();
        }
    }
}

