package com.cmi.jegotrip;

import org.junit.Test;
import org.openqa.selenium.By;

/*
 * Test reset password by email
 */
public class ResetPasswordByEmailTest extends BasicTest {


    /**
     * 不输入邮箱获取验证码
     * 1.启动应用，点击“我的”->登录（手机号或用户名/邮箱）->忘记密码
     * 2.点击“邮箱找回”
     * 3.不输入邮箱，点击获取验证码"
     */
    @Test
    public void testResetPasswordByEmailOne() throws Exception {

        //点击 “我的” tab in the main screen
        findByName("我的").click();

        //点击"忘记密码"
        findByName("忘记密码").click();

        //点击 "邮箱找回"
        findByName("邮箱找回").click();

        //不输入邮箱
        //点击获取验证码
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.RelativeLayout[1]/android" +
                ".widget.TextView[1]").click();
    }

    /**
     * 错误邮箱，获取验证码
     * 1.启动应用，点击“我的”->登录（手机号或用户名/邮箱）->忘记密码
     * 2.点击“邮箱找回”
     * 3.输入错误邮箱，点击获取验证码"
     */
    @Test
    public void testResetPasswordByEmailTwo() throws Exception {

        //点击 “我的” tab in the main screen
        findByName("我的").click();

        //点击"忘记密码"
        findByName("忘记密码").click();

        //点击 "邮箱找回"
        findByName("邮箱找回").click();

        //输入错误邮箱
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.EditText[1]").sendKeys
                ("charliehan@gmail.com");

        //点击获取验证码
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.RelativeLayout[1]/android" +
                ".widget.TextView[1]").click();
    }

    /**
     * 正确邮箱，不输入验证码，点击下一步
     * 1.启动应用，点击“我的”->登录（手机号或用户名/邮箱）->忘记密码
     * 2.点击“邮箱找回”
     * 3.输入正确邮箱，不输入验证码，点击“下一步”"
     */
    @Test
    public void testResetPasswordByEmailThree() throws Exception {

        //点击 “我的” tab in the main screen
        findByName("我的").click();

        //点击"忘记密码"
        findByName("忘记密码").click();

        //点击 "邮箱找回"
        findByName("邮箱找回").click();

        //输入正确邮箱
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.EditText[1]").sendKeys
                ("charliehan@gmail.com");


        //不输入验证码
        //点击“下一步”
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.TextView[1]").click();

    }

    /**
     * 正确邮箱，错误格式验证码，点击下一步
     * 1.启动应用，点击“我的”->登录（手机号或用户名/邮箱）->忘记密码
     * 2.点击“邮箱找回”
     * 3.输入正确邮箱，输入错误验证码，点击“下一步”"
     */
    @Test
    public void testResetPasswordByEmailFour() throws Exception {

        //点击 “我的” tab in the main screen
        findByName("我的").click();

        //点击"忘记密码"
        findByName("忘记密码").click();

        //点击 "邮箱找回"
        findByName("邮箱找回").click();

        //输入正确邮箱
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.EditText[1]").sendKeys
                ("charliehan@chinamobile.com");

        //输入错误格式验证码
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.RelativeLayout[1]/android" +
                ".widget.EditText[1]").sendKeys("16888");

        //点击“下一步”
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.TextView[1]").click();

    }

}


