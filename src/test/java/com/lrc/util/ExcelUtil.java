package com.lrc.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class ExcelUtil {
    // 方法也可以根据情况定义更多参数，比如读取excel的列范围
    //excelPath指excel文件绝对路径，sheetName指表单名，rowNum指行数去掉列头从第2行开始数，cellNum指列数
    public static Object[][] getdataFromExcel(String excelPath, String sheetName, int rowNum, int cellNum) {
        Object[][] datas = null;
        try {
            // 获取workbook对象
            Workbook workbook = WorkbookFactory.create(new File(excelPath));
            // 获取sheet对象
            Sheet sheet = workbook.getSheet(sheetName);
            datas = new Object[rowNum][cellNum];
            // 获取行
            for (int i = 1; i < rowNum + 1; i++) {  //由于第1行是列头，从第2行开始遍历
                Row row = sheet.getRow(i);
                // 获取列
                for (int j = 0; j <= cellNum - 1; j++) {
                    Cell cell = row.getCell(j);
                    cell.setCellType(CellType.STRING);
                    String value = cell.getStringCellValue();
                    datas[i - 1][j] = value;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datas;
    }

    /*public static void main(String[] args) {
        String excelPath = "D:\\IdeaProjects\\baidu_ui_auto_test\\src\\test\\resources\\casedata.xls";
        Object[][] datas = getdataFromExcel(excelPath, "data", 3, 2);
        for (Object[] data : datas) {
            System.out.println(Arrays.toString(data));
        }
    }*/

}
