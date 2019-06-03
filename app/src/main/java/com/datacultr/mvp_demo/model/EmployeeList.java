package com.datacultr.mvp_demo.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class EmployeeList {

    @SerializedName("employee")
    private ArrayList<Employee> employeeList;


    public ArrayList<Employee> getEmployeeArrayList() {
        return employeeList;

    }

}