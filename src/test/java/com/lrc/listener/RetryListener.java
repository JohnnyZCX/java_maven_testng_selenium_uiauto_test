package com.lrc.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @param
 * @author lrc
 * @create 2021/12/20
 * @return
 * @description
 **/
public class RetryListener implements IRetryAnalyzer {
    //最大重试次数
    private int maxRetryCount = 3;
    //当前的重试次数
    private int currentRetryCount = 0;

    @Override
    public boolean retry(ITestResult result) {
        //限制重试的最大次数，否则会进入死循环
        if (currentRetryCount < maxRetryCount) {
            //如果当前的重试次数没有达到限制，就去执行重试机制
            currentRetryCount++;
            return true;
        } else {
            return false;
        }
    }
}
