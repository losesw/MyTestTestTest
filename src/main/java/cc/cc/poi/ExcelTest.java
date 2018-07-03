/**
 * @Version 1.0.0
 * Copyright (c) 2018上海相诚金融-版权所有
 */
package cc.cc.poi;

import lombok.Data;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Class ExcelTest
 * @Description
 * @Author 张超超
 * @Date 2018/5/14 18:00
 */
@Data
public class ExcelTest {

    public static void main(String[] args) throws Exception{
        String filePath = "C:\\Users\\xw37\\Desktop\\dagt_list.xlsx";
        ExcelTest.readDagtList(filePath);
    }

    /**
     * excle的格式如下
     * 列A    列B       列C
     * 空     空        空
     *        0x1235    10
     *        0x1234    11
     * 第一行为空，获取第二行起的 列B和列C数据
     * 格式为 Map<String, List<String>>
     *
     * @throws Exception
     */
    public static Map<String, List<String>> readDagtList(String filepath) throws Exception{
        String fileType = filepath.substring(filepath.lastIndexOf(".") + 1, filepath.length());
        InputStream is = null;
        Workbook wb = null;
        try {
            is = new FileInputStream(filepath);

            if (fileType.equals("xls")) {
                wb = new HSSFWorkbook(is);
            } else if (fileType.equals("xlsx")) {
                wb = new XSSFWorkbook(is);
            } else {
                throw new Exception("读取的不是excel文件");
            }

            Map<String, List<String>> map = new HashMap<>();//对应excel文件

            //只读取第一页
            Sheet sheet = wb.getSheetAt(0);

            int rowSize = sheet.getLastRowNum() + 1;

            String key = "";
            String value = "";
            for (int j = 0; j < rowSize; j++) {//遍历行
                Row row = sheet.getRow(j);
                if (row == null) {//略过空行
                    continue;
                }

                Cell cell = row.getCell(1);
                Cell cell2 = row.getCell(2);
                if (cell != null && cell2 != null) {
                    key = cell2.toString();
                    value = cell.getStringCellValue();
                    if (!map.keySet().contains(key)) {
                        map.put(key, new ArrayList<>());
                    }
                    ((List<String>)map.get(key)).add(value);
                }
            }

            return map;
        } catch (FileNotFoundException e) {
            throw e;
        } finally {
            if (wb != null) {
                wb.close();
            }
            if (is != null) {
                is.close();
            }
        }
    }

    /**
     * 适用于没有标题行的excel，例如
     * 张三   25岁     男   175cm
     * 李四   22岁     女   160cm
     * 每一行构成一个map，key值是列标题，value是列值。没有值的单元格其value值为null
     * 返回结果最外层的list对应一个excel文件，第二层的list对应一个sheet页，第三层的map对应sheet页中的一行
     * @throws Exception
     */
    public static List<List<List<String>>> readExcelWithoutTitle(String filepath) throws Exception{
        String fileType = filepath.substring(filepath.lastIndexOf(".") + 1, filepath.length());
        InputStream is = null;
        Workbook wb = null;
        try {
            is = new FileInputStream(filepath);

            if (fileType.equals("xls")) {
                wb = new HSSFWorkbook(is);
            } else if (fileType.equals("xlsx")) {
                wb = new XSSFWorkbook(is);
            } else {
                throw new Exception("读取的不是excel文件");
            }

            List<List<List<String>>> result = new ArrayList<List<List<String>>>();//对应excel文件

            int sheetSize = wb.getNumberOfSheets();
            for (int i = 0; i < sheetSize; i++) {//遍历sheet页
                Sheet sheet = wb.getSheetAt(i);
                List<List<String>> sheetList = new ArrayList<List<String>>();//对应sheet页

                int rowSize = sheet.getLastRowNum() + 1;
                for (int j = 0; j < rowSize; j++) {//遍历行
                    Row row = sheet.getRow(j);
                    if (row == null) {//略过空行
                        continue;
                    }
                    int cellSize = row.getLastCellNum();//行中有多少个单元格，也就是有多少列
                    List<String> rowList = new ArrayList<String>();//对应一个数据行
                    for (int k = 0; k < cellSize; k++) {
                        Cell cell = row.getCell(k);
                        String value = null;
                        if (cell != null) {
                            value = cell.toString();
                        }
                        rowList.add(value);
                    }
                    sheetList.add(rowList);
                }
                result.add(sheetList);
            }

            return result;
        } catch (FileNotFoundException e) {
            throw e;
        } finally {
            if (wb != null) {
                wb.close();
            }
            if (is != null) {
                is.close();
            }
        }
    }
}
