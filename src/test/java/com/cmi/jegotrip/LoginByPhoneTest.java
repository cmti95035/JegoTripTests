package com.cmi.jegotrip;

import org.junit.Test;
import org.openqa.selenium.By;

import static junit.framework.TestCase.assertNotNull;

/*
 * Test login by Phone number
 */
public class LoginByPhoneTest extends BasicTest {


    /**
     * 登录入口
     * 1.启动应用，点击“我的”
     * 2.流量包详情页，点击“立即支付”
     * 3.点击未登录无忧助手页数据面板"
     */
    @Test
    public void testLoginByPhoneOne() throws Exception {

        //click the tab in the main screen
        findByName("流量商店").click();

        // click the first item in liuliang shangdian
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".FrameLayout[1]/android.widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ListView[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ImageView[1]").click();

        findByName("立即购买").click();
        findByName("马上登录").click();
        assertNotNull(findByName("手机号登录"));
    }

    /**
     * 不输入手机号登录
     * 1.启动应用，点击“我的”->“手机号登录”
     * 2.不输入手机号码，输入正确密码，点击登录"
     *
     * @throws Exception
     */
    @Test
    public void testLoginByPhoneTwo() throws Exception {
        //点击“我的”
        findByName("我的").click();

        //输入正确密码
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.EditText[1]").sendKeys(PASSWORD);

        //点击登录
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.TextView[2]").click();
    }

    /**
     * 不输入密码登录
     * 1.启动应用，点击“我的”->“手机号登录”
     * 2.输入正确手机号码，不输入密码，点击登录"
     *
     * @throws Exception
     */
    @Test
    public void testLoginByPhoneThree() throws Exception {
        //点击“我的”
        findByName("我的").click();

        //输入正确手机号码
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.RelativeLayout[2]/android.widget.EditText[1]")
                .sendKeys(PHONE_NUMBER);

        //点击登录
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.TextView[2]").click();
    }

    /**
     * 正确国家码，错误格式手机号，登录
     * 1.启动应用，点击“我的”->“手机号登录”
     * 2.输入正确国家码，输入错误手机号，输入密码，输入密码"
     *
     * @throws Exception
     */
    @Test
    public void testLoginByPhoneFour() throws Exception {
        //点击“我的”
        findByName("我的").click();

        //输入正确国家码
        // Fixed. Not an option for now

        //输入错误格式手机号, e.g. "188014968tt"
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.RelativeLayout[2]/android.widget.EditText[1]")
                .sendKeys(PHONE_NUMBER_MAL_FORMED);

        //输入密码
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.EditText[1]").sendKeys(PASSWORD);

        //点击登录
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.TextView[2]").click();

    }

    /**
     * 正确国家码，未注册手机号，登录
     * 1.启动应用，点击“我的”->“手机号登录”
     * 2.输入正确国家码，输入未注册手机号，输入密码，点击登录"
     *
     * @throws Exception
     */
    @Test
    public void testLoginByPhoneFive() throws Exception {
        //点击“我的”
        findByName("我的").click();

        //输入正确国家码
        // Fixed. Not an option for now

        //输入未注册手机号,e.g. "13705715745"
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.RelativeLayout[2]/android.widget.EditText[1]")
                .sendKeys(PHONE_NUMBER_UNREGISTERED);

        //输入密码
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.EditText[1]").sendKeys(PASSWORD);

        //点击登录
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.TextView[2]").click();

    }

    /***
     * 正确国家码，正确手机号，错误密码，登录
     * 1.启动应用，点击“我的”->“手机号登录”
     * 2.输入正确国家码，输入正确手机号，输入错误密码，点击登录"
     *
     * @throws Exception
     */
    @Test
    public void testLoginByPhoneSix() throws Exception {
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

        //输入错误密码, e.g."12345"
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.EditText[1]").sendKeys(PASSWORD_MAL_FORMED);

        //点击登录
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.TextView[2]").click();

    }

    /**
     * 正确国家码、手机号、密码登录
     * 1.启动应用，点击“我的”->“手机号登录”
     * 2.输入正确国家码，输入正确手机号，输入正确密码，点击登录"
     *
     * @throws Exception
     */
    @Test
    public void testLoginByPhoneSeven() throws Exception {
        loginByPhone();
    }
}
