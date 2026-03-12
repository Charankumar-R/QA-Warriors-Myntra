package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelUtils {

    static String path = "src/test/resources/testdata.xlsx";

    public static String getCellData(int row, int col) {

        try {

            FileInputStream file = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheet("Sheet1");

            String data = sheet.getRow(row).getCell(col).toString();

            workbook.close();

            return data;

        } catch (Exception e) {
            return "";
        }
    }

    public static void setCellData(int row, int col, String result) {

        try {

            FileInputStream file = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheet("Sheet1");

            Row rowData = sheet.getRow(row);
            Cell cell = rowData.createCell(col);

            cell.setCellValue(result);

            FileOutputStream output = new FileOutputStream(path);
            workbook.write(output);

            workbook.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}