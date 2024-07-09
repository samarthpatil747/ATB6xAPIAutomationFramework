package utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UtilsExcel {
    /**
     * This class contains utility methods for working with Excel files.
     */

    /**
     * Reads an Excel file and returns the data as a 2D array of strings.
     *
     * @param filePath The path to the Excel file.
     * @return A 2D array of strings containing the data from the Excel file.
     */
    /*public static String[][] readExcel(String filePath) {
        // Implementation details omitted for brevity
        return null; // Replace with the actual implementation
    }*/

    /**
     * Writes data to an Excel file.
     *
     * @param filePath The path to the Excel file.
     * @param data     A 2D array of strings containing the data to be written.
     */
    /*public static void writeExcel(String filePath, String[][] data) {
        // Implementation details omitted for brevity
    }*/

    // Open FileInputStream
    // Understnad the workbook
    // Sheet
    // Row
    // Column
    // Cell
    // Close the sheet

    public static String filePath = "src/test/resources/TD.xlsx";
    static Workbook workbook;
    static Sheet sheet;

    public static Object[][] getDataFromExcel(String sheetName) {
        // Implementation details omitted for brevity


        FileInputStream file=null;
        try {
            file = new FileInputStream(filePath);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            workbook = WorkbookFactory.create(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        sheet = workbook.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
            }
        }

        return data; // Replace with the actual implementation
    }

@DataProvider
    public Object[][] getData() {
        // In future we can write the code to select the sheet want to open
        return getDataFromExcel("Sheet1");

    }
}
