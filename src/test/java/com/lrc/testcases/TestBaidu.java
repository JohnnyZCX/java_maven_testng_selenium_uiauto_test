
package com.lrc.testcases;

import com.lrc.common.BaseTest;
import com.lrc.config.GlobalDatas;
import com.lrc.page.BaiduPage;
import org.testng.annotations.*;

/**
 * @param
 * @author lrc
 * @create 2021/12/22
 * @return
 * @description
 **/
public class TestBaidu extends BaseTest {
    @BeforeMethod
    public void setup() {
        //用例前置
        //1、打开浏览器
        openBrowser(GlobalDatas.BROWSER_NAME);
        maxBrowser();
        //2、进入登录页面
        toURL(GlobalDatas.INDEX_URL);
    }

    //测试百度搜索功能
    @Test
    public void test_baidu_success() {
        BaiduPage baiduPage = new BaiduPage(driver);
        baiduPage.inputData(GlobalDatas.USER_NAME);
        baiduPage.clickBaidu();
    }

    //测试点击【新闻链接】
    @Test
    public void test_click_new() {
        BaiduPage baiduPage = new BaiduPage(driver);
        baiduPage.clickNews();
    }

    //测试点击【hao123】
    @Test
    public void test_click_hao123() {
        BaiduPage baiduPage = new BaiduPage(driver);
        baiduPage.clickHao123();
    }

    //测试点击【地图】
    @Test
    public void test_click_map() {
        BaiduPage baiduPage = new BaiduPage(driver);
        baiduPage.clickMap();
    }

    //测试点击【贴吧】
    @Test
    public void test_click_tieBa() {
        BaiduPage baiduPage = new BaiduPage(driver);
        baiduPage.clickTieBa();
    }

    //测试点击【视频】
    @Test
    public void test_click_video() {
        BaiduPage baiduPage = new BaiduPage(driver);
        baiduPage.clickVideo();
    }

    //测试点击【图片】
    @Test
    public void test_click_picture() {
        BaiduPage baiduPage = new BaiduPage(driver);
        baiduPage.clickPicture();
    }

    //测试点击【网盘】
    @Test
    public void test_click_pan() {
        BaiduPage baiduPage = new BaiduPage(driver);
        baiduPage.clickPan();
    }


    @AfterMethod
    public void teardown() {
        //用例后置
        //退出浏览器
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        quitBrowser();
    }
}
