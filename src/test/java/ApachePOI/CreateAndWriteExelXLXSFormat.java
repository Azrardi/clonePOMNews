package ApachePOI;

/*
* Workbook -> Sheet -> Row -> cell
* */

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateAndWriteExelXLXSFormat {
    public static void main(String[] args) throws IOException {
        //Open Exel
        File exelFile = new File("src/test/resources/ExelSourceNew.xlsx");

        //Check Value true Exel -> true
        //System.out.println(exelFile.exists());

        FileInputStream fis = new FileInputStream(exelFile);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet2");

        sheet.createRow(0);
        sheet.createRow(0).createCell(0).setCellValue("Hello");
        sheet.getRow(0).createCell(1).setCellValue("World");

        sheet.createRow(1);
        sheet.createRow(1).createCell(0).setCellValue("HYR");
        sheet.getRow(1).createCell(1).setCellValue("Tutorial");

        FileOutputStream fos = new FileOutputStream(exelFile);
        workbook.write(fos);
        workbook.close();
    }
}
