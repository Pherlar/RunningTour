package com.chrisl.runningtour;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RunAdapter extends ArrayAdapter<Run>{
    public RunAdapter(Activity context, ArrayList<Run> runs){
        super(context,0, runs);
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the object located at this position in the list
        Run currentRun = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView runNameTV = (TextView) listItemView.findViewById(R.id.run_name_tv);
        // get the run name and set this text on the TextView
        runNameTV.setText(currentRun.getRunName());

        // Find the TextView in the list_item.xml layout with the run length
        TextView runLengthTV = (TextView) listItemView.findViewById(R.id.run_length_tv);

        ImageView defaultImageView = (ImageView) listItemView.findViewById(R.id.image);

        // Return the list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }




}
