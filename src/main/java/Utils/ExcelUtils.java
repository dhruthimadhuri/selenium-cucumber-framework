package Utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    private static final String path = "src/main/resources/testdata.xlsx";

    // Read one row as HashMap<ColumnHeader, Value>
    public static HashMap<String, String> getTestData(String sheetName, int rowNumber) {
        HashMap<String, String> data = new HashMap<>();
        try (
        		FileInputStream file = new FileInputStream(path);
        		
             XSSFWorkbook workbook = new XSSFWorkbook(file)) {

            XSSFSheet sheet = workbook.getSheet(sheetName);
            int colCount = sheet.getRow(0).getLastCellNum();

            for (int i = 0; i < colCount; i++) {
                String key = sheet.getRow(0).getCell(i).getStringCellValue();
                String value = sheet.getRow(rowNumber).getCell(i).getStringCellValue();
                data.put(key, value);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    // Get number of data rows (exclude header)
    public static int getRowCount(String sheetName) {
        int rowCount = 0;
        try (FileInputStream file = new FileInputStream(path);
             XSSFWorkbook workbook = new XSSFWorkbook(file)) {
            rowCount = workbook.getSheet(sheetName).getLastRowNum();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowCount;
    }
    
 // NEW: Get all values of a specific column as a List<String>
    public static List<String> getColumnValues(String sheetName, String columnName) {
        List<String> values = new ArrayList<>();
        try (FileInputStream file = new FileInputStream(path);
             XSSFWorkbook workbook = new XSSFWorkbook(file)) {

            XSSFSheet sheet = workbook.getSheet(sheetName);
            int colCount = sheet.getRow(0).getLastCellNum();
            int targetCol = -1;

            // Find column index by name
            for (int i = 0; i < colCount; i++) {
                String key = sheet.getRow(0).getCell(i).getStringCellValue();
                if (key.equalsIgnoreCase(columnName)) {
                    targetCol = i;
                    break;
                }
            }

            if (targetCol == -1) {
                throw new RuntimeException("Column not found: " + columnName);
            }

            int rowCount = sheet.getLastRowNum();
            for (int i = 1; i <= rowCount; i++) { // skip header
                String cellValue = sheet.getRow(i).getCell(targetCol).getStringCellValue();
                values.add(cellValue);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return values;
    }

}