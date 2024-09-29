// package ApachePOI;
//
///*
//* Workbook -> Sheet -> Row -> cell
//* */
//
// import org.apache.poi.xssf.usermodel.XSSFCell;
// import org.apache.poi.xssf.usermodel.XSSFRow;
// import org.apache.poi.xssf.usermodel.XSSFSheet;
// import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
// import java.io.File;
// import java.io.FileInputStream;
//
//public class ReadExel {
//    public static void main(String[] args) throws Exception {
//        File file = new File("src/test/resources/SourceMultiParameterPOI.xlsx");
//        FileInputStream fis = new FileInputStream (file);
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//        XSSFSheet sheet = workbook.getSheet("Sheet1");
//        String cellValue1 = sheet.getRow(0).getCell(0).getStringCellValue();
//        String cellValue2 = sheet.getRow(0).getCell(1).getStringCellValue();
//        String cellValue3= sheet.getRow(0).getCell(2).getStringCellValue();
//        System.out.println("Cell value: " + cellValue1);
//        System.out.println("Cell Value2: " + cellValue2);
//        System.out.println("Cell Value3: " + cellValue3);
//
//        int rowCount = sheet.getPhysicalNumberOfRows();
//        for (int i = 0; i< rowCount; i++) {
//            XSSFRow row = sheet.getRow(i);
//            int cellCount = row.getPhysicalNumberOfCells();
//            for (int j = 0; j< cellCount; j++) {
//                XSSFCell cell = row.getCell(j);
//                String cellValue = getcellvalue(cell);
//                System.out.print("||"+cellValue);
//            }
//            System.out.println();
//        }
//        workbook.close();
//        fis.close();
//    }
//    public static String getcellvalue(XSSFCell cell) {
//        switch (cell.getCellType()) {
//            case NUMERIC:
//                return String.valueOf(cell.getNumericCellValue());
//            case BOOLEAN:
//                return String.valueOf(cell.getBooleanCellValue());
//            case STRING:
//                return String.valueOf(cell.getStringCellValue());
//            default:
//                return String.valueOf(cell.getStringCellValue());
//        }
//    }
//}
