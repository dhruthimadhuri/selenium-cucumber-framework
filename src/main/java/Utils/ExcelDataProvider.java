package Utils;


import java.util.HashMap;
import org.testng.annotations.DataProvider;

public class ExcelDataProvider {

    // Generic DataProvider: takes sheet name dynamically
    @DataProvider(name = "excelData")
//    public static Object[][] getData() {
//        return getData("LoginData"); // default sheet, can be overridden
//    }

    // Overloaded method: allows any sheet name
    public static Object[][] getData(String sheetName) {

        int rowCount = ExcelUtils.getRowCount(sheetName);
        Object[][] data = new Object[rowCount][1];

        for (int i = 1; i <= rowCount; i++) { // skip header
            HashMap<String, String> rowData = ExcelUtils.getTestData(sheetName, i);
            data[i - 1][0] = rowData;
        }

        return data;
    }
}