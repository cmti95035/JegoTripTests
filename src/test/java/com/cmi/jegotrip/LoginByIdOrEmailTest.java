package com.cmi.jegotrip;

import org.junit.Test;
import org.openqa.selenium.By;

import static junit.framework.TestCase.assertNotNull;

/*
 * Test login by ID or Email
 */
public class LoginByIdOrEmailTest extends BasicTest {


    /**
     * 不输入用户名/邮箱登录
     * 1.启动应用，点击“我的”->“用户名/邮箱登录”
     * 2.不输入用户名/邮箱，输入正确密码，点击登录"
     */
    @Test
    public void testLoginByIdOrEmailOne() throws Exception {

        //click “我的” tab in the main screen
        findByName("我的").click();

        //click "用户名/邮箱登录"
        findByName("用户名/邮箱登录").click();

        //不输入用户名/邮箱
        //输入正确密码
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[2]/android.widget.EditText[1]").sendKeys
                (PASSWORD);

        //点击登录
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget.TextView[1]").click();

    }

    /**
     * 不输入密码登录
     * 1.启动应用，点击“我的”->“用户名/邮箱登录”
     * 2.输入正确用户名/邮箱，不输入密码，点击登录"
     */
    @Test
    public void testLoginByIdOrEmailTwo() throws Exception {

        //click “我的” tab in the main screen
        findByName("我的").click();

        //click "用户名/邮箱登录"
        findByName("用户名/邮箱登录").click();

        //输入正确用户名/邮箱
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.EditText[1]").sendKeys
                (USER_ID);

        //不输入密码
        //点击登录
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget.TextView[1]").click();
    }

    /**
     * 正确用户名，错误密码，登录
     * 1.启动应用，点击“我的”->“用户名/邮箱登录”
     * 2.输入正确用户名，输入错误密码，点击登录"
     */
    @Test
    public void testLoginByIdOrEmailThree() throws Exception {

        //click “我的” tab in the main screen
        findByName("我的").click();

        //click "用户名/邮箱登录"
        findByName("用户名/邮箱登录").click();

        //输入正确用户名
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.EditText[1]").sendKeys
                (USER_ID);

        //输入错误密码
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[2]/android.widget.EditText[1]").sendKeys
                (PASSWORD_WRONG);

        //点击登录
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget.TextView[1]").click();
    }

    /**
     * 错误用户名，正确密码，登录
     * 1.启动应用，点击“我的”->“用户名/邮箱登录”
     * 2.输入错误用户名，输入正确密码，点击登录"
     */
    @Test
    public void testLoginByIdOrEmailFour() throws Exception {

        //click “我的” tab in the main screen
        findByName("我的").click();

        //click "用户名/邮箱登录"
        findByName("用户名/邮箱登录").click();

        //输入错误用户名
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.EditText[1]").sendKeys
                (USER_ID_WRONG);

        //输入正确密码
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[2]/android.widget.EditText[1]").sendKeys
                (PASSWORD);

        //点击登录
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget.TextView[1]").click();

    }

    /**
     * 正确用户名、密码，登录
     * 1.启动应用，点击“我的”->“用户名/邮箱登录”
     * 2.输入正确用户名，输入正确密码，点击登录"
     */
    @Test
    public void testLoginByIdOrEmailFive() throws Exception {

        //click “我的” tab in the main screen
        findByName("我的").click();

        //click "用户名/邮箱登录"
        findByName("用户名/邮箱登录").click();

        //输入正确用户名
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.EditText[1]").sendKeys
                (USER_ID);

        //输入正确密码
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[2]/android.widget.EditText[1]").sendKeys
                (PASSWORD);

        //点击登录
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget.TextView[1]").click();

        assertNotNull(findByName("用户名"));
    }

    /**
     * 正确邮箱，错误密码，登录
     * 1.启动应用，点击“我的”->“用户名/邮箱登录”
     * 2.输入正确邮箱，输入错误密码，点击登录"
     */
    @Test
    public void testLoginByIdOrEmailSix() throws Exception {

        //click “我的” tab in the main screen
        findByName("我的").click();

        //click "用户名/邮箱登录"
        findByName("用户名/邮箱登录").click();

        //输入正确邮箱
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.EditText[1]").sendKeys
                (EMAIL);

        //输入错误密码
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[2]/android.widget.EditText[1]").sendKeys
                (PASSWORD_MAL_FORMED);

        //点击登录
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget.TextView[1]").click();

    }

    /**
     * 错误格式邮箱，正确密码，登录
     * 1.启动应用，点击“我的”->“用户名/邮箱登录”
     * 2.输入错误格式邮箱，输入密码，点击登录"
     */
    @Test
    public void testLoginByIdOrEmailSeven() throws Exception {

        //click “我的” tab in the main screen
        findByName("我的").click();

        //click "用户名/邮箱登录"
        findByName("用户名/邮箱登录").click();

        //输入错误格式邮箱
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.EditText[1]").sendKeys
                (EMAIL_MAL_FORMED);

        //输入正确密码
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[2]/android.widget.EditText[1]").sendKeys
                (PASSWORD);

        //点击登录
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget.TextView[1]").click();

    }

    /**
     * 未注册邮箱，登录
     * 1.启动应用，点击“我的”->“用户名/邮箱登录”
     * 2.输入未注册邮箱，输入密码，点击登录"
     */
    @Test
    public void testLoginByIdOrEmailEight() throws Exception {

        //click “我的” tab in the main screen
        findByName("我的").click();

        //click "用户名/邮箱登录"
        findByName("用户名/邮箱登录").click();

        //输入未注册邮箱
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.EditText[1]").sendKeys
                (EMAIL_UNREGISTERED);

        //输入正确密码
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[2]/android.widget.EditText[1]").sendKeys
                (PASSWORD);

        //点击登录
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget.TextView[1]").click();
    }

    /**
     * 正确邮箱、密码登录
     * 1.启动应用，点击“我的”->“用户名/邮箱登录”
     * 2.输入正确邮箱，输入正确密码，点击登录"
     */
    @Test
    public void testLoginByIdOrEmailNine() throws Exception {

        //click “我的” tab in the main screen
        findByName("我的").click();

        //click "用户名/邮箱登录"
        findByName("用户名/邮箱登录").click();

        //输入正确邮箱
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.EditText[1]").sendKeys
                (EMAIL);

        //输入正确密码
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[2]/android.widget.EditText[1]").sendKeys
                (PASSWORD);

        //点击登录
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget.TextView[1]").click();

        //assertNotNull(findByName("用户名"));

    }
}
