package models;

import java.util.Date;
import java.text.SimpleDateFormat;


public class Customer {

    private String name = "";
    private String gender = "female";
    private Date birthDate = new Date();
    private Integer jobCategory = 0;
    private Double salary = 0.0;
    private Double salaryBegin = 0.0;
    private Integer jobTime = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Customer() { }
    public Customer(String name, String gender, Date birthDate, Integer jobCategory, Double salary, Double salaryBegin, Integer jobTime) {
        this();
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.jobCategory = jobCategory;
        this.salary = salary;
        this.salaryBegin = salaryBegin;
        this.jobTime = jobTime;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }
    public String getStringBirthDate() {
        //'2015-11-04 18:06:25' yyyy-dd-MM HH:mm:ss
        //INSERT INTO tblCustomers(name,gender,birthdate,jobcategory,salary,salarybegin,jobtime) VALUES('Victuailles en stock','female', '1967-12-03 00:00:00','1','25050.0','10950.0','93');
        //INSERT INTO tblCustomers(name,gender,birthdate,jobcategory,salary,salarybegin,jobtime) VALUES('AdamWest','male', '1960-14-03 00:00:00',3,60625.0,22500.0,91);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = formatter.format(birthDate);
        return strDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(Integer jobCategory) {
        this.jobCategory = jobCategory;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getSalaryBegin() {
        return salaryBegin;
    }

    public void setSalaryBegin(Double salaryBegin) {
        this.salaryBegin = salaryBegin;
    }

    public Integer getJobTime() {
        return jobTime;
    }

    public void setJobTime(Integer jobTime) {
        this.jobTime = jobTime;
    }
}
