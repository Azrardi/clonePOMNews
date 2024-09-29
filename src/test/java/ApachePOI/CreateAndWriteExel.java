package ApachePOI;

/*
* Workbook -> Sheet -> Row -> cell
* */

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class CreateAndWriteExel {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook Workbook = new XSSFWorkbook();
        XSSFSheet sheet = Workbook.createSheet("Sheet1");
        sheet.createRow(0);
        sheet.createRow(0).createCell(0).setCellValue("Hello");
        sheet.getRow(0).createCell(1).setCellValue("World");

        sheet.createRow(1);
        sheet.createRow(1).createCell(0).setCellValue("HYR");
        sheet.getRow(1).createCell(1).setCellValue("Tutorial");

        File file = new File("src/test/resources/exelSourcerTest.xls");
        Workbook.close();
    }
}
