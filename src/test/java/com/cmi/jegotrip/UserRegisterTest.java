package com.cmi.jegotrip;

import org.junit.Test;
import org.openqa.selenium.Keys;

/*
 * Test user registration
 */
public class UserRegisterTest extends BasicTest {


    /**
     * 不输入验证码注册
     * 1.启动应用，点击“我的”->“注册”
     * 2.输入正确手机号码，不输入验证码，输入正确密码，点击注册"
     */
    @Test
    public void testUserRegistrationOne() throws Exception {

        goRegistration();

        //输入正确手机号码
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.LinearLayout[1]/android" +
                ".widget.EditText[1]").sendKeys("13539709517");

        //设置密码
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.LinearLayout[2]/android" +
                ".widget.EditText[1]").sendKeys("dso7rz@w");
        //点击注册
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.TextView[1]").click();

    }

    /**
     * 错误格式验证码，正确密码，注册
     * 1.启动应用，点击“我的”->“注册”
     * 2.输入正确手机号码，输入错误格式验证码，输入正确密码，点击注册"
     */

    @Test
    public void testUserRegistrationTwo() throws Exception {

        goRegistration();

        //输入正确手机号码
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.LinearLayout[1]/android" +
                ".widget.EditText[1]").sendKeys("13539709517");

        //输入错误格式验证码
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.RelativeLayout[2]/android" +
                ".widget.EditText[1]").sendKeys("16888");

        //设置密码
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.LinearLayout[2]/android" +
                ".widget.EditText[1]").sendKeys("dso7rz@w");
        //点击注册
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.TextView[1]").click();

    }

    //点击去注册，并输入邀请码
    private void goRegistration() {
        //click “我的” tab in the main screen
        findByName("我的").click();

        //click "去注册"
        findByName("去注册").click();

        //输入邀请码
        find("//android.widget.LinearLayout[1]/android.widget" +
                ".FrameLayout[1]/android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget.ScrollView[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.EditText[1]").sendKeys
                (REGISTER_CODE);

        // soft keyboard sometimes presents and covers the "立即体验" button,
        // sometimes not
        hideKeyboard("goRegistration");

        //click "立即体验"
        findByName("立即体验").click();
    }

}


