package com.datacultr.mvp_demo.interfaces;

import com.datacultr.mvp_demo.model.Employee;

import java.util.ArrayList;


public interface MainActivtyPresenter {


    interface viewPresenter {

        void onDestroy();

        void onRefreshButtonClick();

        void requestDataFromServer();

    }


    interface DataView {

        void showProgress();

        void hideProgress();

        void setDataToRecyclerView(ArrayList<Employee> empArrayList);

        void onResponseFailure(Throwable throwable);

    }


    interface GetEmpDataFromServer {

        interface OnFinishedListener {
            void onFinished(ArrayList<Employee> employeeArrayList);

            void onFailure(Throwable t);
        }

        void getEmployeeArrayList(OnFinishedListener onFinishedListener);
    }
}
