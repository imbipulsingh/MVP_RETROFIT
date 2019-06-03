package com.datacultr.mvp_demo.interfaces;

import com.datacultr.mvp_demo.model.EmployeeList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetEmployeeDataService {

    @GET("retrofit/json_object.json")
    Call<EmployeeList> getEmpData();




}