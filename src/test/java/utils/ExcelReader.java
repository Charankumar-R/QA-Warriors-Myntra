package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;

public class ExcelReader {

    public static Object[][] readData(String sheetName) {

        String path = System.getProperty("user.dir")
                + "/src/test/resources/testdata/testdata.xlsx";

        Object[][] data = null;

        try {

            FileInputStream fis = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(fis);

            Sheet sheet = workbook.getSheet(sheetName);

            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

            data = new Object[rowCount - 1][colCount];

            for (int i = 1; i < rowCount; i++) {

                Row row = sheet.getRow(i);

                for (int j = 0; j < colCount; j++) {

                    Cell cell = row.getCell(j);

                    data[i - 1][j] = cell.toString();
                }
            }

            workbook.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}