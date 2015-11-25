package com.cmi.jegotrip;

import junit.framework.TestCase;
import org.junit.Test;
import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;

import static junit.framework.TestCase.assertNotNull;

/*
 * Test login by Phone number
 */
public class LoginAndPurchaseTest extends BasicTest {


    @Test
    public void testLoginAndPurchaseOne() throws Exception {

//        findByName("立即体验").click();

        // click one from the "大家都在抢"
        find("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.HorizontalScrollView[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ImageView[1]").click();
//        find("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.HorizontalScrollView[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ImageView[1]").click();

        findByName("立即购买").click();
        findByName("马上登录").click();
        assertNotNull(findByName("手机号登录"));

        //输入正确手机号
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.RelativeLayout[2]/android.widget.EditText[1]")
                .sendKeys("15801503625");
//                .sendKeys("18801496855");

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

//        TestCase.assertNotNull(wd.findElementByName("用户名"));

        findByName("立即购买").click();

//        TestCase.assertNotNull(wd.findElementByName("确认订单"));

        // 取消订单
        find("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.widget.ImageButton[1]").click();
        find("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.TabHost[1]/android.widget.LinearLayout[1]/android.widget.TabWidget[1]/android.widget.LinearLayout[3]/android.widget.ImageView[1]").click();
//        find("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]").click();
        find("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]").click();
        find("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[1]").click();
        find("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.TextView[1]").click();
        find("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[2]").click();



    }
}
