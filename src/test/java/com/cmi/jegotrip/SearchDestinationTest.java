package com.cmi.jegotrip;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

import static org.junit.Assert.assertNotNull;

/*
 * Test 搜索目的地
 */
public class SearchDestinationTest extends BasicTest {


    /**
     * 目的地搜索页
     * 1.启动应用，点击“无忧助手”
     * 2.点击目的地搜索框
     * <p/>
     * precondition:
     * 应用已登录
     */
    @Test
    public void testSearchDestinationOne() throws Exception {

        // 应用登录
        loginByPhone();

        //点击 “无忧助手" tab in the main screen
        findByName("无忧助手").click();

        //点击目的地搜索框
        find("//android.widget.LinearLayout[1]/android.widget" +
                ".FrameLayout[1]/android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.RelativeLayout[1]/android.widget.RelativeLayout[1]").click();

        //Now do the check-ups
        //搜索框
        WebElement el = find("//android.widget" +
                ".LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.EditText[1]");
        assertNotNull(el);

        //您当前的所在地
        assertNotNull(findByName("您当前的所在地"));

        //热门国家或地区
        assertNotNull(findByName("热门国家或地区"));
    }

    /**
     * 搜索目的地
     * 1.启动应用，点击“无忧助手”
     * 2.点击目的地搜索框
     * 3.点击搜索框，输入搜索内容
     * 4.点击搜索结果
     * <p/>
     * precondition:
     * 应用已登录
     */
    @Test
    public void testSearchDestinationTwo() throws Exception {

        // 应用登录
        loginByPhone();

        //点击 “无忧助手" tab in the main screen
        findByName("无忧助手").click();

        searchHongKong();

        //Now do the check-ups
        assertNotNull(findByName("资费查询"));
        assertNotNull(findByName("中国香港"));
    }

    // search Hong Kong as the destination from main screen
    private void searchHongKong() {

        //点击目的地搜索框
        find("//android.widget.LinearLayout[1]/android.widget" +
                ".FrameLayout[1]/android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.ScrollView[1]/android.widget.LinearLayout[1]/android" +
                ".widget.RelativeLayout[1]/android.widget.RelativeLayout[1]").click();

        //点击搜索框，输入搜索内容
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.EditText[1]").sendKeys
                ("xiangg");

        //点击搜索结果
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".FrameLayout[1]/android.widget.ListView[1]/android.widget" +
                ".LinearLayout[1]/android.widget.LinearLayout[1]").click();

    }

    /**
     * 目的地详情页-当地资费标准
     * 启动应用，点击“无忧助手”
     * 点击当前所在地或热门国家地区或点击搜索的目的地
     * 点击该地漫游资费标准下的展开按钮"
     * <p/>
     * precondition:
     * 应用已登录
     */
    @Test
    public void testSearchDestinationThree() throws Exception {

        // 应用登录
        loginByPhone();

        //点击 “无忧助手" tab in the main screen
        findByName("无忧助手").click();

        searchHongKong();

        //点击该地漫游资费标准下的展开按钮
        find("//android.widget.LinearLayout[1]/android" +
                ".widget.FrameLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.FrameLayout[1]/android" +
                ".widget.LinearLayout[1]/android.widget.ScrollView[1]/android" +
                ".widget.LinearLayout[1]/android.widget" +
                ".LinearLayout[1]/android.widget.LinearLayout[2]/android" +
                ".widget.ImageView[1]").click();

        //Now do the check-ups
        assertNotNull(findByName("漫游标准"));
        assertNotNull(findByName("标准流量资费"));
        assertNotNull(findByName("拨打中国大陆"));
        assertNotNull(findByName("当地接听"));
        assertNotNull(findByName("拨打当地"));
        assertNotNull(findByName("拨打其他国家地区"));
        assertNotNull(findByName("发短信至中国大陆"));
        assertNotNull(findByName("发短信至其他国家地区"));

        //Scroll a little bit, so the items at the bottom of the screen
        //will be visible
        wd.scrollTo("当地收短信");
        assertNotNull(findByName("当地收短信"));
    }

    /**
     * 目的地详情页-已登录
     * 启动应用，点击“无忧助手”
     * 点击当前所在地或热门国家地区或点击搜索的目的地
     * 点击“立即申请”包天优惠流量包（或点击“立刻购买”流量包）
     * 点击“立即购买”"
     * <p/>
     * precondition:
     * 应用已登录
     */

    @Test
    public void testSearchDestinationFour() throws Exception {

        // 应用登录
        loginByPhone();

        //点击 “无忧助手" tab in the main screen
        findByName("无忧助手").click();

        searchHongKong();

        // 点击“立刻购买"
        findByName("立刻购买").click();
        assertNotNull(findByName("立即购买"));

        // 点击“立即购买"
        findByName("立即购买").click();
    }

}


