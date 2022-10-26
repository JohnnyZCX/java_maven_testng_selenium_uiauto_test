package com.lrc.page;

import com.lrc.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @param
 * @author lrc
 * @create 2021/12/22
 * @return
 * @description
 **/
public class BaiduPage extends BasePage {
    private RemoteWebDriver driver;
    //搜索输入框
    private By searchInputBy = By.id("kw");
    //百度一下按钮
    private By searchSubmitBy = By.id("su");
    //新闻链接
    private By newsLinkBy = By.xpath("//a[text()='新闻']");
    //hao123链接
    private By hao123LinkBy = By.xpath("//a[text()='hao123']");
    //地图链接
    private By mapLinkBy = By.xpath("//a[text()='地图']");
    //贴吧链接
    private By tieBaLinkBy = By.xpath("//a[text()='贴吧']");
    //视频链接
    private By videoLinkBy = By.xpath("//div[@id='s-top-left']/a[text()='视频']");
    //图片链接
    private By pictureLinkBy = By.xpath("//div[@id='s-top-left']/a[text()='图片']");
    //网盘链接
    private By panLinkBy = By.xpath("//div[@id='s-top-left']/a[text()='网盘']");
    //更多链接
    private By moreLinkBy = By.xpath("//div[@class='mnav s-top-more-btn']/a[text()='更多']");
    //设置的标签
    private By setSpanBy = By.xpath("//span[text()='设置']");
    //高级搜索
    private By highSearchBy = By.xpath("//span[text()='高级搜索']");
    //包含全部关键词输入框
    private By allKeywordsInputBy = By.id("adv_keyword");
    //时间选择下拉框
    private By timeSelectBy = By.xpath("//span[@id='adv-setting-gpc']//div[@class='c-select-selection']");
    //最近一天
    private By recentDayBy = By.xpath("//p[text()='最近一天']");
    //最近一周
    private By recentWeekBy = By.xpath("//p[text()='最近一周']");
    //最近一月
    private By recentMonthBy = By.xpath("//p[text()='最近一月']");
    //最近一年
    private By recentYearBy = By.xpath("//p[text()='最近一年']");
    //高级搜索确认按钮
    private By highSearchSubmitBy = By.xpath("//input[@value='高级搜索']");

    //生成百度页面的构造方法
    public BaiduPage(RemoteWebDriver driver) {
        this.driver = driver;
    }

    //在页面层封装向百度搜索框输入数据的方法
    public void inputData(String data) {
        sendKey(driver, searchInputBy, data, "百度搜索框");
    }

    //在页面层封装点击【百度一下】的方法
    public void clickBaidu() {
        click(driver, searchSubmitBy, "百度一下按钮");
    }

    //在页面层封装点击"新闻"的方法
    public void clickNews() {
        click(driver, newsLinkBy, "新闻链接");
    }

    //在页面层封装点击"hao123"的方法
    public void clickHao123() {
        click(driver, hao123LinkBy, "hao123链接");
    }

    //在页面层封装点击"地图"的方法
    public void clickMap() {
        click(driver, mapLinkBy, "地图链接");
    }

    //在页面层封装点击"贴吧"的方法
    public void clickTieBa() {
        click(driver, tieBaLinkBy, "贴吧链接");
    }

    //在页面层封装点击"视频"的方法
    public void clickVideo() {
        click(driver, videoLinkBy, "视频链接");
    }

    //在页面层封装点击"图片"的方法
    public void clickPicture() {
        click(driver, pictureLinkBy, "图片链接");
    }

    //在页面层封装点击"网盘"的方法
    public void clickPan() {
        click(driver, panLinkBy, "网盘链接");
    }

    //封装鼠标移动到"设置"的方法
    public void moveToSet() {
        moveToElement(driver, setSpanBy, "设置的Span标签");
    }

    //封装点击"高级搜索"的方法
    public void clickHighSearch() {
        click(driver, highSearchBy, "高级搜索");
    }

    //页面层封装向高级搜索包含全部关键词输入框输入数据
    public void inputKeyword(String data) {
        sendKey(driver, allKeywordsInputBy, data, "高级搜索-包含全部关键词输入框");
    }

    //封装点击"时间选择下拉框"
    public void clickSelectTime() {
        click(driver, timeSelectBy, "时间选择下拉框");
    }

    //封装点击"最近一天"
    public void clickRecentDay() {
        click(driver, recentDayBy, "最近一天");
    }

    //封装点击"最近一周"
    public void clickRecentWeek() {
        click(driver, recentWeekBy, "最近一周");
    }

    //封装点击"最近一月"
    public void clickRecentMonth() {
        click(driver, recentMonthBy, "最近一月");
    }

    //封装点击"最近一年"
    public void clickRecentYear() {
        click(driver, recentYearBy, "最近一年");
    }

    //封装点击"高级搜索确认按钮"
    public void clickHighSearchSubmit() {
        click(driver, highSearchSubmitBy, "高级搜索确认按钮");
    }
}
