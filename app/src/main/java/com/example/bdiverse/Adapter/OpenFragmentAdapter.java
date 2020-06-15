package com.example.bdiverse.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bdiverse.Obgects.task;
import com.example.bdiverse.R;

import java.io.File;
import java.util.ArrayList;

public class OpenFragmentAdapter extends RecyclerView.Adapter<OpenFragmentAdapter.HolderOpen> implements Filterable{



    private ArrayList<task> mAreeyTask;
    private ArrayList<task> mFilerTask = new ArrayList<>();
    private LayoutInflater mLayoutInflater;
    private myFilter myFilterAdapter = new myFilter();


    public OpenFragmentAdapter(ArrayList<task> task) {
        this.mAreeyTask = task;
        mFilerTask.addAll(task);

    }

    @NonNull
    @Override
    public HolderOpen onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_opentascs, parent, false);
        return new HolderOpen(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderOpen holder, int position) {
        holder.setTask(mFilerTask.get(position));
    }

    @Override
    public int getItemCount() {
        return mFilerTask.size();
    }

    @Override
    public Filter getFilter() {
        return myFilterAdapter;
    }

    public class HolderOpen extends RecyclerView.ViewHolder {
        private TextView titel;
        private TextView draft;
        private TextView id;
        private TextView date;
        private TextView company;
        private TextView task;

        public HolderOpen(@NonNull View itemView) {
            super(itemView);
            titel = itemView.findViewById(R.id.IOrasc_titel_TV);
            draft = itemView.findViewById(R.id.IOrasc_Draft_TV);
            id = itemView.findViewById(R.id.IOrasc_id_TV);
            date = itemView.findViewById(R.id.IOrasc_date_ouers_TV);
            company = itemView.findViewById(R.id.IOrasc_company_TV);
            task = itemView.findViewById(R.id.IOrasc_task_TV);
        }

        public void setTask(task myTask) {
            titel.setText(myTask.getTitel());
            if (myTask.isDraft())
                draft.setText("Draft");
            id.setText(String.valueOf(myTask.getId()));
            date.setText(myTask.getDateManthDay() + " | " + myTask.getBeginningTime() + "-" + myTask.getFinishingTime());
            company.setText(myTask.getNameAddressCompany());
            task.setText(myTask.getTaskCharacteristics());
        }
    }
    private class myFilter extends Filter{

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {

        FilterResults mFilterResults = new FilterResults();
//        mFilerTask.clear();
        ArrayList<task> arreyResultTask = new ArrayList<>();
        for (task myTask : mAreeyTask) {
            if (myTask.getTitel().toLowerCase().contains(constraint.toString().toLowerCase())){
                arreyResultTask.add(myTask);
            }
        }
//        mFilerTask.addAll(resultTask);
        mFilterResults.values = arreyResultTask;
        mFilterResults.count = arreyResultTask.size();

        return mFilterResults;

    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        mFilerTask= (ArrayList<task>)  results.values;
        notifyDataSetChanged();
        }
    }
}
