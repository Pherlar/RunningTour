package com.chrisl.runningtour;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RowViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    final TextView runName, runLength, runType;
    final ImageView runImage;
    ImageView runIcon;
    ImageView shareIcon;


    private RecyclerViewClickListener mListener;

    public RowViewHolder(View v, RecyclerViewClickListener listener) {
        super(v);
        runName = v.findViewById(R.id.run_name_tv);
        runLength = v.findViewById(R.id.run_length_tv);
        runImage = v.findViewById(R.id.run_image);
        runType = v.findViewById(R.id.run_type_tv);
        runIcon = v.findViewById(R.id.running_icon);
        shareIcon = v.findViewById(R.id.share_icon);



        this.mListener = listener;
        runIcon.setOnClickListener(this);
        shareIcon.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        mListener.onClick(view, getAdapterPosition());
    }



}

