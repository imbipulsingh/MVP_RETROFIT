package com.datacultr.mvp_demo.main_activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.datacultr.mvp_demo.R;
import com.datacultr.mvp_demo.adapter.EmployeeAdapter;
import com.datacultr.mvp_demo.interfaces.MainActivtyPresenter;
import com.datacultr.mvp_demo.interfaces.RecyclerItemClickListener;
import com.datacultr.mvp_demo.model.Employee;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainActivtyPresenter.DataView {

    private ProgressBar progressBar;
    private RecyclerView recyclerView;

    private MainActivtyPresenter.viewPresenter viewPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeToolbarAndRecyclerView();
        initProgressBar();


        viewPresenter = new DataPresenter(this, new GetRetrofitInstance());
        viewPresenter.requestDataFromServer();

    }



    private void initializeToolbarAndRecyclerView() {



        recyclerView = findViewById(R.id.recycler_view_employee_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);


    }



    private void initProgressBar() {
        progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);

        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setGravity(Gravity.CENTER);
        relativeLayout.addView(progressBar);

        RelativeLayout.LayoutParams params = new
                RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        progressBar.setVisibility(View.INVISIBLE);

        this.addContentView(relativeLayout, params);
    }


    /**
     * RecyclerItem click event listener
     * */
    private RecyclerItemClickListener recyclerItemClickListener = new RecyclerItemClickListener() {
        @Override
        public void onItemClick(Employee employee) {

            Toast.makeText(MainActivity.this,
                    "List title:  " + employee.getName(),
                    Toast.LENGTH_LONG).show();

        }
    };


    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }


    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }


    @Override
    public void setDataToRecyclerView(ArrayList<Employee> employeeArrayList) {

        EmployeeAdapter adapter = new EmployeeAdapter(employeeArrayList, recyclerItemClickListener);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(MainActivity.this,
                "Something went wrong...Error message: " + throwable.getMessage(),
                Toast.LENGTH_LONG).show();
        Log.e("Error message",""+ throwable.getMessage());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewPresenter.onDestroy();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_refresh) {
            viewPresenter.onRefreshButtonClick();
        }

        return super.onOptionsItemSelected(item);
    }


}

