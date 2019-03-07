package com.chrisl.runningtour;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class RunAdapter extends RecyclerView.Adapter<RunAdapter.MyViewHolder>
{
    private List<Run> runs;
    private LayoutInflater mInflater;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView runName, runLength;
        public ImageView runImage;

        public MyViewHolder (View view){
            super (view);
            runName = (TextView) view.findViewById(R.id.run_name_tv);
            runLength = (TextView) view.findViewById(R.id.run_length_tv);
            runImage = (ImageView) view.findViewById(R.id.run_image);

        }
    }


    // data is passed into the constructor
    public RunAdapter(ArrayList<Run> runs) {
        this.runs = runs;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View listItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(listItemView);
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder, int positiion)
    {
        Run run = runs.get(positiion);
        holder.runLength.setText(Double.toString(run.getRunDistance()));
        holder.runName.setText(run.getRunName());
        holder.runImage.setImageResource(run.getImageResourceID());
    }

    @Override
    public int getItemCount()
    {
        return runs.size();
    }




}




