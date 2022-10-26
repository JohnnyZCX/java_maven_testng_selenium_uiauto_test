package com.lrc.businesslogic;

import com.lrc.page.BaiduPage;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @param
 * @author lrc
 * @create 2021/12/23
 * @return
 * @description
 **/
public class BaiduFlow {
    private RemoteWebDriver driver;

    public BaiduFlow(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public void selectTime(String keyword, String time) {
        try {
            BaiduPage baiduPage = new BaiduPage(driver);
            baiduPage.moveToSet();//移动到设置按钮
            Thread.sleep(1500);
            baiduPage.clickHighSearch();//点击高级搜索
            Thread.sleep(1500);
            baiduPage.inputKeyword(keyword);//输入关键词
            Thread.sleep(1500);
            baiduPage.clickSelectTime();//点击时间选择下拉框
            if ("最近一天".equals(time)) {
                baiduPage.clickRecentDay();
                Thread.sleep(1500);
            } else if ("最近一周".equals(time)) {
                baiduPage.clickRecentWeek();
                Thread.sleep(1500);
            } else if ("最近一月".equals(time)) {
                baiduPage.clickRecentMonth();
                Thread.sleep(1500);
            } else if ("最近一年".equals(time)) {
                baiduPage.clickRecentYear();
                Thread.sleep(1500);
            }
            baiduPage.clickHighSearchSubmit();//点击高级搜索提交按钮
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

