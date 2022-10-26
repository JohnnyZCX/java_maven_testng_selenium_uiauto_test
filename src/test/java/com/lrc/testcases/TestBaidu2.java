package com.lrc.testcases;

import com.lrc.businesslogic.BaiduFlow;
import com.lrc.common.BaseTest;
import com.lrc.config.GlobalDatas;
import com.lrc.page.BaiduPage;
import com.lrc.util.ExcelUtil;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.*;

/**
 * @param
 * @author lrc
 * @create 2021/12/23
 * @return
 * @description
 **/
public class TestBaidu2 extends BaseTest {
    @BeforeMethod
    public void setup() {
        //用例前置
        //1、打开浏览器
        openBrowser(GlobalDatas.BROWSER_NAME);
        maxBrowser();
        //2、进入百度页面
        toURL(GlobalDatas.INDEX_URL);
    }

    @Test(dataProvider = "datasFromExcel")  // 多条数据，且数据和代码分离
    public void test_baidu_01(String keyword, String time) {
        BaiduFlow baiduFlow = new BaiduFlow(driver);
        baiduFlow.selectTime(keyword, time);
    }

    @DataProvider(name = "datasFromExcel")
    public Object[][] datasFromExcel() {
        Object[][] datas = ExcelUtil.getdataFromExcel("D:\\IdeaProjects\\baidu_ui_auto_test\\src\\test\\resources\\casedata.xls", "data", 3, 2);
        return datas;
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
