package com.chrisl.runningtour;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;




public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Run> runList;
    private RecyclerViewClickListener mListener;


    // data is passed into the constructor
    public RecyclerViewAdapter(ArrayList<Run> runs, RecyclerViewClickListener listener) {
        //layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mListener = listener;
        this.runList = runs;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View listItemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new RowViewHolder(listItemView, mListener);
    }


//            @Override
//            public void onRun (int mPosition){
//                Run currentRun = runList.get(mPosition);
//                Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(currentRun.getNavigationString()));
//                mapIntent.setPackage("com.google.android.apps.maps");
//                //itemView.getContext().startActivity(mapIntent);
//            }
//
//        });


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RowViewHolder) {
            Run run = runList.get(position);

            ((RowViewHolder) holder).runLength.setText(String.valueOf(run.getRunDistance()) + " km");
            ((RowViewHolder) holder).runName.setText(run.getRunName());
            ((RowViewHolder) holder).runImage.setImageResource(run.getImageResourceID());
            ((RowViewHolder) holder).runType.setText(run.getRunType());
        }
    }

    @Override
    public int getItemCount() {
        return runList.size();
    }
}

















