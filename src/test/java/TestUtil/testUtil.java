package TestUtil;

import java.util.ArrayList;

public class testUtil{
    static Xls_Reader reader;

    public static ArrayList<Object[]> getDataFromExel(){

        ArrayList<Object[]>  myData = new ArrayList<Object[]>();
        try {
            reader = new Xls_Reader("src/test/resources/DataproviderSourceIntegrasi.xlsx");

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int rowNum = 2; rowNum <= reader.getRowCount("Sheet1"); rowNum++){
            String firstName = reader.getCellData("Sheet1", "FirstName", rowNum);
            String lastName = reader.getCellData("Sheet1", "LastName", rowNum);
            String address = reader.getCellData("Sheet1", "Address", rowNum);
            String state = reader.getCellData("Sheet1", "State", rowNum);
            String zipCode = reader.getCellData("Sheet1", "ZipCode", rowNum);
            String phone = reader.getCellData("Sheet1","ZipCode",rowNum);
            String ssn = reader.getCellData("Sheet1","SSN",rowNum);
            String username = reader.getCellData("Sheet1","Username",rowNum);
            String password = reader.getCellData("Sheet1","Password",rowNum);
            String passwordConfirm = reader.getCellData("Sheet1","PasswordConfirm",rowNum);

            Object ob[] = {firstName,lastName,address,state, zipCode, phone, ssn, username, password, passwordConfirm};
            myData.add(ob);
        }
        return myData;
    }
}
