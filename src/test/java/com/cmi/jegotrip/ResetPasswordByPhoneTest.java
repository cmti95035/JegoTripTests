package com.cmi.jegotrip;

import org.junit.Test;
import org.openqa.selenium.By;

/*
 * Test reset password by phone number
 */
public class ResetPasswordByPhoneTest extends BasicTest {


    /**
     * 不输入手机号码获取验证码
     * 1.启动应用，点击“我的”->登录（手机号或用户名/邮箱）->忘记密码
     * 2.点击“手机找回”
     * 3.不输入手机号码，点击获取验证码"
     */
    @Test
    public void testResetPasswordByPhoneOne() throws Exception {

        //点击 “我的” tab in the main screen
        findByName("我的").click();

        //点击"忘记密码"
        findByName("忘记密码").click();

        //点击 "手机号找回"
        findByName("手机号找回").click();

        //不输入手机号码
        //点击获取验证码
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.RelativeLayout[2]/android" +
                ".widget.TextView[1]").click();
    }

    /**
     * 正确国家码、手机号，不输入验证码，点击下一步
     * 1.启动应用，点击“我的”->登录（手机号或用户名/邮箱）->忘记密码
     * 2.点击“手机找回”
     * 3.输入正确国家码、手机号，不输入验证码，点击“下一步”"
     */
    @Test
    public void testResetPasswordByPhoneTwo() throws Exception {

        //点击 “我的” tab in the main screen
        findByName("我的").click();

        //点击"忘记密码"
        findByName("忘记密码").click();

        //点击 "手机号找回"
        findByName("手机号找回").click();

        //输入正确国家码, not an option for now
        //输入手机号码
        //不输入验证码
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.LinearLayout[1]/android" +
                ".widget.EditText[1]").sendKeys("18801496855");

        //点击“下一步”
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.TextView[1]").click();
    }

    /**
     * 正确国家码、手机号，错误格式验证码，点击下一步
     * 1.启动应用，点击“我的”->登录（手机号或用户名/邮箱）->忘记密码
     * 2.点击“手机找回”
     * 3.输入正确国家码、手机号，输入错误验证码，点击“下一步”"
     */
    @Test
    public void testResetPasswordByPhoneThree() throws Exception {

        //点击 “我的” tab in the main screen
        findByName("我的").click();

        //点击"忘记密码"
        findByName("忘记密码").click();

        //点击 "手机号找回"
        findByName("手机号找回").click();

        //输入正确国家码, not an option for now
        //输入手机号码
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.LinearLayout[1]/android" +
                ".widget.EditText[1]").sendKeys("18801496855");

        //输入错误格式验证码
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.RelativeLayout[2]/android" +
                ".widget.EditText[1]").sendKeys("16888");

        //点击“下一步”
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.TextView[1]").click();

    }
}


