package com.datacultr.mvp_demo.main_activity;

import com.datacultr.mvp_demo.interfaces.MainActivtyPresenter;
import com.datacultr.mvp_demo.model.Employee;

import java.util.ArrayList;



public class DataPresenter implements MainActivtyPresenter.viewPresenter, MainActivtyPresenter.GetEmpDataFromServer.OnFinishedListener {

    private MainActivtyPresenter.DataView dataView;
    private MainActivtyPresenter.GetEmpDataFromServer getEmpDataFromServer;

    public DataPresenter(MainActivtyPresenter.DataView dataView, MainActivtyPresenter.GetEmpDataFromServer getEmpDataFromServer) {
        this.dataView = dataView;
        this.getEmpDataFromServer = getEmpDataFromServer;
    }

    @Override
    public void onDestroy() {

        dataView = null;

    }

    @Override
    public void onRefreshButtonClick() {

        if(dataView != null){
            dataView.showProgress();
        }
        getEmpDataFromServer.getEmployeeArrayList(this);

    }

    @Override
    public void requestDataFromServer() {
        getEmpDataFromServer.getEmployeeArrayList(this);
    }


    @Override
    public void onFinished(ArrayList<Employee> employeeArrayList) {
        if(dataView != null){
            dataView.setDataToRecyclerView(employeeArrayList);
            dataView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        if(dataView != null){
            dataView.onResponseFailure(t);
            dataView.hideProgress();
        }
    }
}
