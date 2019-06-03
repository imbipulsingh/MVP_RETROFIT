package com.datacultr.mvp_demo.adapter;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.datacultr.mvp_demo.R;
import com.datacultr.mvp_demo.interfaces.RecyclerItemClickListener;
import com.datacultr.mvp_demo.model.Employee;

import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    private ArrayList<Employee> dataList;
    private RecyclerItemClickListener recyclerItemClickListener;

    public EmployeeAdapter(ArrayList<Employee> dataList, RecyclerItemClickListener recyclerItemClickListener) {
        this.dataList = dataList;
        this.recyclerItemClickListener = recyclerItemClickListener;
    }


    @Override
    public EmployeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_view_row, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EmployeeViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.txtEmpID.setText(dataList.get(position).getName());
        holder.txtEmpName.setText(dataList.get(position).getEmail());
        holder.txtEmpSalary.setText(dataList.get(position).getSalary());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerItemClickListener.onItemClick(dataList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder {

        TextView txtEmpID, txtEmpName, txtEmpSalary;


        EmployeeViewHolder(View itemView) {
            super(itemView);

            txtEmpID = itemView.findViewById(R.id.txt_employee_id);
            txtEmpName = itemView.findViewById(R.id.txt_employee_name);
            txtEmpSalary = itemView.findViewById(R.id.txt_employee_salary);

        }
    }
}