package excel;

import models.Customer;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;


public class ExcelManager {
    private String filePath = "/Users/duongnguyen/NetBeansProjects/UngDungJava/DataExamples.xls";
    private Workbook workbook;
    private Sheet sheet0;
    private Integer i = 0;
    private ArrayList<Customer> customers = new ArrayList<>();

    private String textFileName = "sqlFileOutput.sql";
    public void readExcelFile(){
      try{
          workbook = WorkbookFactory.create(new File(filePath));
          sheet0 = workbook.getSheetAt(0);
          sheet0.forEach(row->{
              if(i > 0){
                  String name = row.getCell(0).getStringCellValue();
                  String gender = row.getCell(1).getStringCellValue();
                  Date birthDate = row.getCell(2).getDateCellValue();
                  Integer jobCategory = ((Double)row.getCell(4).getNumericCellValue()).intValue();

                  //String strSalary = row.getCell(5).getStringCellValue().replace('$',' ');
                  Double salary = row.getCell(5).getNumericCellValue();

                  Double salaryBegin = row.getCell(6).getNumericCellValue();
                  Integer jobTime = ((Double)row.getCell(7).getNumericCellValue()).intValue();
                  Customer customer = new Customer(name,gender,birthDate,jobCategory,salary,salaryBegin,jobTime);
                  if(!name.equals("")) {
                      customers.add(customer);
                  }
              }
              i++;
          });
          saveToSqlFile();

      }
      catch (Exception e){
          System.out.println("GIDO" + e);
      }

    }

    public void saveToSqlFile() throws Exception{
        //open file
        //for loop customers de ghi vao file
        //close file
        PrintWriter writer = new PrintWriter(textFileName, "UTF-8");
        /*
            CREATE TABLE tblCustomers(
        	CustomerID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
           	name nvarchar(300) NOT NULL,
        	gender nvarchar(100) NOT NULL,
        	birthdate datetime,
        	jobcategory int,
        	salary float,
        	salarybegin float,
        	jobtime int
            );
        * */
        customers.forEach(customer -> {
            //INSERT INTO tblCustomers(name,gender,birthdate,jobcategory,salary,salarybegin,jobtime) VALUES('Alfreds Futterkiste','m', '2015-11-04 18:06:25','3','57000.0','27000.0','98');
            String name = customer.getName();
            String gender = customer.getGender().equals("f") ? "female" : "male";
            String strBirthDate = customer.getStringBirthDate();
            Integer jobCategory = customer.getJobCategory();
            Double salary = customer.getSalary();
            Double salaryBegin = customer.getSalaryBegin();
            Integer jobTime = customer.getJobTime();

            String line = "INSERT INTO tblCustomers(name,gender,birthdate,jobcategory,salary,salarybegin,jobtime) VALUES('"+name
                    +"','"+gender+"', '"+strBirthDate+"','"
                    +jobCategory+"','"+salary +"','"
                    +salaryBegin+"','"+jobTime+"');";
            writer.println(line);
            //System.out.println(line);
        });
        writer.close();
    }
}
