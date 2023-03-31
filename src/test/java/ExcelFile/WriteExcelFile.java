package ExcelFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class WriteExcelFile {
    public WriteExcelFile() {
    }

    public void writeExcel(String filepath, String sheetName, String[] dataToWrite) throws IOException {
        File file = new File(filepath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
        // Cantidad de filas que existen
        int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();

        XSSFRow row = newSheet.getRow(0);
        XSSFRow newRow = newSheet.createRow(rowCount + 1);

        for (int i = 0; i < row.getLastCellNum(); i++) {
            XSSFCell newCell = newRow.createCell(i);
            newCell.setCellValue(dataToWrite[i]);
        }
        inputStream.close();
        // informacion para escribir
        FileOutputStream outputStream = new FileOutputStream(file);
        // escribir en el archivo
        newWorkbook.write(outputStream);
        newWorkbook.close();
        outputStream.close();
    }

    public void writeCellValue(String filepath, String sheetName, int nowNumber, int cellNumber, String resultText)
            throws IOException {
        File file = new File(filepath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet newSheet = newWorkbook.getSheet(sheetName);

        XSSFRow row = newSheet.getRow(nowNumber);

        XSSFCell firCell = row.getCell(cellNumber - 1);
        System.out.println("first cell value: " + firCell.getStringCellValue());

        XSSFCell nextCell = row.createCell(cellNumber);
        nextCell.setCellValue(resultText);
        System.out.println("next cell value: " + nextCell.getStringCellValue());

        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(file);
        newWorkbook.write(outputStream);
        newWorkbook.close();
        outputStream.close();
    }

    public WebDriver chromeDriverConnection() {
        return null;
    }
}
