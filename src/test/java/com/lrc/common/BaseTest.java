package com.lrc.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.util.Set;

/**
 * @param
 * @author lrc
 * @create 2021/12/13
 * @return
 * @description 封装用例层的公用方法
 **/
public class BaseTest {
    private static Logger logger = Logger.getLogger(BaseTest.class);
    public RemoteWebDriver driver;

    /**
     * 打开所有浏览器通用方法封装
     *
     * @param browserName 浏览器名
     */
    public void openBrowser(String browserName) {
        RemoteWebDriver webDriver = null;
        if ("chrome".equalsIgnoreCase(browserName)) {
            System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
            webDriver = new ChromeDriver();
            logger.info("====================打开了chrome浏览器=====================");
        } else if ("firefox".equalsIgnoreCase(browserName)) {
            System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
            webDriver = new FirefoxDriver();
            logger.info("====================打开了Firefox浏览器=====================");
        } else if ("ie".equalsIgnoreCase(browserName)) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            //取消IE安全设置（忽略IE的Protected Mode的设置）
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            //忽略浏览器缩放设置
            capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
            System.setProperty("webdriver.ie.driver", "src\\test\\resources\\IEDriverServer.exe");
            webDriver = new InternetExplorerDriver(capabilities);
            logger.info("====================打开了IE浏览器=====================");
        }
        driver= webDriver;
    }

    /**
     * 关闭浏览器通用方法
     */
    public void closeBrowser(){
        logger.info("====================关闭浏览器=====================");
        driver.close();
    }

    /**
     * 退出浏览器通用方法
     */
    public void quitBrowser(){
        logger.info("====================退出浏览器=====================");
        driver.quit();
    }



    /**
     * 最大化浏览器
     */
    public void maxBrowser(){
        logger.info("================最大化浏览器===================");
        driver.manage().window().maximize();
    }

    /**
     * 访问指定网址
     * @param url 访问地址
     */
    public void toURL(String url){
        logger.info("================访问网址：==================="+url);
        driver.get(url);
    }


    /**
     * 封装的通用切换窗口的方法-根据对应窗口的标题来切换
     * @param title 窗口标题
     */
    public void switchWindowWithTitle(String title){
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String windowHandle: allWindowHandles){
            //根据窗口的标题来进行判断
            if(title.equals(driver.getTitle())){
                break;
            }else {
                logger.info("切换到标题为：【"+title+"】的窗口");
                driver.switchTo().window(windowHandle);
            }
        }
    }

    /**
     * 封装的通用切换窗口的方法-根据对应窗口的url来切换
     * @param url 窗口url
     */
    public void switchWindowWithURL(String url){
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String windowHandle: allWindowHandles){
            //根据窗口的URL来进行判断
            if (url.equals(driver.getCurrentUrl())){
                break;
            }else {
                logger.info("切换到url为:【"+url+"】的窗口");
                driver.switchTo().window(windowHandle);
            }
        }
    }



    public void myAssertTrue(boolean condition,String assertDescription){
        logger.info("断言：【"+assertDescription+"】条件表达式【"+condition+"】");
        Assert.assertTrue(condition);
    }

    public void myAssertEquals(String actual,String expected,String assertDescription){
        logger.info("断言：【"+assertDescription+"】实际值【"+actual+"】期望值【"+expected+"】");
        Assert.assertEquals(actual,expected);
    }

    public void myAssertEquals(int actual,int expected,String assertDescription){
        logger.info("断言：【"+assertDescription+"】实际值【"+actual+"】期望值【"+expected+"】");
        Assert.assertEquals(actual,expected);
    }

    public void myAssertEquals(double actual,double expected,String assertDescription){
        logger.info("断言：【"+assertDescription+"】实际值【"+actual+"】期望值【"+expected+"】");
        Assert.assertEquals(actual,expected);
    }

    public void myAssertEquals(float actual,float expected,String assertDescription){
        logger.info("断言：【"+assertDescription+"】实际值【"+actual+"】期望值【"+expected+"】");
        Assert.assertEquals(actual,expected);
    }

    public void myAssertEquals(Object actual,Object expected,String assertDescription){
        logger.info("断言：【"+assertDescription+"】实际值【"+actual+"】期望值【"+expected+"】");
        Assert.assertEquals(actual,expected);
    }
}

