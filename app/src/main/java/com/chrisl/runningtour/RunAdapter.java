package com.chrisl.runningtour;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class RunAdapter extends RecyclerView.Adapter<RunAdapter.MyViewHolder>
{
    private ArrayList<Run> runList;


    // data is passed into the constructor
    public RunAdapter(ArrayList<Run> runs) {
        this.runList = runs;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View listItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(listItemView, this);
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder, int position)
    {
        Run run = runList.get(position);
        holder.runLength.setText(String.valueOf(run.getRunDistance())+" km");
        holder.runName.setText(run.getRunName());
        holder.runImage.setImageResource(run.getImageResourceID());
    }

    @Override
    public int getItemCount()
    {
        return runList.size();
    }



    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        final TextView runName, runLength;
        final ImageView runImage;
        final RunAdapter rAdapter;

        MyViewHolder(View view, RunAdapter adapter){
            super (view);
            runName = view.findViewById(R.id.run_name_tv);
            runLength = view.findViewById(R.id.run_length_tv);
            runImage = view.findViewById(R.id.run_image);
            this.rAdapter = adapter;

            ImageView icon = view.findViewById(R.id.running_icon);
            icon.setOnClickListener(this);
        }

        @Override
        public void onClick(View v)
        {
            int mPosition = getLayoutPosition();
            Run currentRun = runList.get(mPosition);
            Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(currentRun.getNavigationString()));
            mapIntent.setPackage("com.google.android.apps.maps");
            itemView.getContext().startActivity(mapIntent);

            //Toast.makeText(v.getContext(), currentRun.getRunName(),Toast.LENGTH_SHORT).show();

        }
    }

}






