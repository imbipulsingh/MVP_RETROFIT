package com.datacultr.mvp_demo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Employee {

//    {"id":"12811","employee_name":"vikas singh","employee_salary":"120000","employee_age":"28","
//"employee": [
//    {
//        "employee_id": 1001,
//            "name": "Abhishek",
//            "dob": "1994-08-28",
//            "designation": "Systems Engineer",
//            "contact_number": "8888888888",
//            "email": "abhi@androiddeft.com",
//            "salary": "30,000.00"
//    },
@SerializedName("employee_id")
@Expose
private Integer employeeId;

    @SerializedName("name")
    @Expose
    private String name;


    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("designation")
    @Expose
    private String designation;


    @SerializedName("contact_number")
    @Expose
    private String contactNumber;


    @SerializedName("email")
    @Expose
    private String email;


    @SerializedName("salary")
    @Expose
    private String salary;

    @SerializedName("id")
    private String id;



    public Employee(String id, String name, String salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String name) {
        this.email = email;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }


}