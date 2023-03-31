package ExcelFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

//Permite leer un archivo excel
public class ReadExcelFile {
    public ReadExcelFile() {
    }

    public void readExcel(String filepath, String sheetName) throws IOException {

        File file = new File(filepath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet newSheet = newWorkbook.getSheet(sheetName);

        // Leer fila por fila
        int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();
        for (int i = 0; i < rowCount; i++) {
            XSSFRow row = newSheet.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                System.out.print(row.getCell(j).getStringCellValue() + "||");
            }
        }
        newWorkbook.close();
    }

    public String getCellValue(String filePath, String sheetName, int rowNumber, int cellNumber) throws IOException {
        FileInputStream inputStream = new FileInputStream(new File(filePath));
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNumber);
        Cell cell = row.getCell(cellNumber);
        String cellValue = cell.getStringCellValue();
        workbook.close();
        inputStream.close();
        return cellValue;
    }

}
