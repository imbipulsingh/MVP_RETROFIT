package com.datacultr.mvp_demo.main_activity;

import android.util.Log;

import com.datacultr.mvp_demo.interfaces.MainActivtyPresenter;
import com.datacultr.mvp_demo.model.EmployeeList;
import com.datacultr.mvp_demo.interfaces.GetEmployeeDataService;
import com.datacultr.mvp_demo.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GetRetrofitInstance implements MainActivtyPresenter.GetEmpDataFromServer {

    @Override
    public void getEmployeeArrayList(final OnFinishedListener onFinishedListener) {



        GetEmployeeDataService service = RetrofitInstance.getRetrofitInstance().create(GetEmployeeDataService.class);


        Call<EmployeeList> call = service.getEmpData();

        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<EmployeeList>() {
            @Override
            public void onResponse(Call<EmployeeList> call, Response<EmployeeList> response) {
                Log.wtf("URL Responce", response.body() + "");
                onFinishedListener.onFinished(response.body().getEmployeeArrayList());

            }

            @Override
            public void onFailure(Call<EmployeeList> call, Throwable t) {
                Log.wtf("URL onFailure", t.getMessage() + "");
                onFinishedListener.onFailure(t);
            }
        });

    }

}
