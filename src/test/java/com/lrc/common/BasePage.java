package com.lrc.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @param
 * @author lrc
 * @create 2021/12/13
 * @return
 * @description 封装页面层的公用方法
 **/
public class BasePage {
    private static Logger logger = Logger.getLogger(BasePage.class);

    /**
     * 显式等待元素可见二次封装
     *
     * @param driver 驱动对象
     * @param by     元素定位信息
     */
    public WebElement waitElementVisible(RemoteWebDriver driver, By by) {
        WebElement webElement = null;
        try {
            //1、实例化WebDriverWait 超时时间10s
            WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
            //2、通过until方法等到某个条件满足时为止
            webElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            logger.error("定位元素【" + by + "】异常");
        }

        return webElement;
    }

    /**
     * 显式等待元素可被点击二次封装
     *
     * @param driver 驱动对象
     * @param by     元素定位信息
     */
    public WebElement waitElementClickable(RemoteWebDriver driver, By by) {
        WebElement webElement = null;
        try {
            //1、实例化WebDriverWait 超时时间10s
            WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
            //2、通过until方法等到某个条件满足时为止
            webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Exception e) {
            logger.error("定位元素【" + by + "】异常");
        }
        return webElement;
    }

    /**
     * 输入框输入数据通用方法
     *
     * @param driver 驱动对象
     * @param by     元素定位信息
     * @param data   输入的数据
     */
    public void sendKey(RemoteWebDriver driver, By by, String data, String elementName) {
        logger.info("往元素【" + elementName + "】输入数据【" + data + "】");
        waitElementVisible(driver, by).sendKeys(data);
    }

    /**
     * 点击操作的通用方法
     *
     * @param driver 驱动对象
     * @param by     元素定位信息
     */
    public void click(RemoteWebDriver driver, By by, String elementName) {
        logger.info("对元素【" + elementName + "】进行点击");
        waitElementClickable(driver, by).click();
    }


    /**
     * 获取元素文本方法封装
     *
     * @param driver      驱动对象
     * @param by          元素定位信息
     * @param elementName 元素名称
     * @return
     */
    public String getText(RemoteWebDriver driver, By by, String elementName) {
        String text = waitElementVisible(driver, by).getText();
        logger.info("获取元素【" + elementName + "】文本【" + text + "】");
        return text;
    }

    /**
     * 切换到指定IFrame封装
     *
     * @param driver    驱动对象
     * @param by        元素定位信息
     * @param frameInfo 自定义frame信息
     */
    public void switchFrame(RemoteWebDriver driver, By by, String frameInfo) {
        WebElement element = waitElementVisible(driver, by);
        logger.info("切换IFrame:" + frameInfo);
        driver.switchTo().frame(element);
    }

    /**
     * 从IFrame中切换到默认页面封装
     *
     * @param driver 驱动对象
     */
    public void switchDefaultFrame(RemoteWebDriver driver) {
        logger.info("切换回默认的页面");
        driver.switchTo().defaultContent();
    }

    /**
     * Alert弹窗切换
     *
     * @param driver 驱动对象
     */
    public void switchAlert(RemoteWebDriver driver) {
        logger.info("切换到alert窗口");
        Alert alert = driver.switchTo().alert();
        // alert.accept();  //点击确定
        //alert.dismiss(); //点击取消
        alert.getText();  //获取弹窗文本
    }

    /**
     * 鼠标聚焦到指定元素的通用方法
     *
     * @param driver      驱动对象
     * @param by          元素单位信息
     * @param elementName 元素名称
     */
    public void moveToElement(RemoteWebDriver driver, By by, String elementName) {
        Actions actions = new Actions(driver);
        actions.moveToElement(waitElementVisible(driver, by)).perform();
        logger.info("鼠标移动到元素【" + elementName + "】上了");
    }

}

