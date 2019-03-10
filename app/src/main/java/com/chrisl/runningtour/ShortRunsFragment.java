package com.chrisl.runningtour;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShortRunsFragment extends Fragment
{
    private ArrayList<Run> runList;

    public ShortRunsFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        buildRunList();
        //inflate the view
        View v = inflater.inflate(R.layout.list_container, container, false);
        //pass the inflated view into the Recycler View
        RecyclerView recyclerView = v.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        //Handle the onClick events for each button within the Rows using a switch
        RecyclerViewClickListener listener = new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int mPosition) {
                Run currentRun = runList.get(mPosition);
                switch (view.getId()) {
                    case R.id.running_icon:
                        Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(currentRun.getNavigationString()));
                        mapIntent.setPackage("com.google.android.apps.maps");
                        startActivity(mapIntent);
                        break;
                    case R.id.share_icon:
                        //pass navigation path to an intent to share via sms
                        try
                        {
                            Intent i = new Intent(Intent.ACTION_SEND);
                            i.setType("text/plain");
                            i.putExtra(Intent.EXTRA_SUBJECT, "@string/app_name");
                            String message = "I'm using "+ getResources().getString(R.string.app_name) + " to recommend this running route!\n";
                            message = message + " "+ currentRun.getNavigationString();
                            i.putExtra(Intent.EXTRA_TEXT, message);
                            startActivity(Intent.createChooser(i, "choose one"));

                        }catch(Exception e){
                            e.toString();
                        }
                        break;
                }
            }
        };

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(runList,listener);
        recyclerView.setAdapter(adapter);

        return v;
    }

//Separate run list builder - add all new runs in below here
    private void buildRunList()
    {
        runList = new ArrayList<>();
        runList.add(new Run("Botanic Blast", 1.5, R.drawable.botanic_gardens, getString(R.string.out_and_back_string),getString(R.string.placeholder_nav_string)));
        runList.add(new Run("Bridge Dash", 2.7,R.drawable.sydney_harbour_bridge, getString(R.string.one_way), getString(R.string.harbour_bridge_nav_string)));
        runList.add(new Run("Cremorne Crush", 2.9,R.drawable.cremorne_point, getString(R.string.loop), getString(R.string.cremorne_nav_string)));
        runList.add(new Run("Centennial Circuit", 3.6,R.drawable.centennial_park, getString(R.string.loop), getString(R.string.centennial_nav_string)));
        runList.add(new Run("Barangaroo Bounce", 1.5,R.drawable.barangaroo, getString(R.string.loop), getString(R.string.barangaroo_nav_string)));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, getString(R.string.out_and_back_string),getString(R.string.placeholder_nav_string)));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, getString(R.string.out_and_back_string),getString(R.string.placeholder_nav_string)));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, getString(R.string.out_and_back_string),getString(R.string.placeholder_nav_string)));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, getString(R.string.out_and_back_string),getString(R.string.placeholder_nav_string)));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, getString(R.string.out_and_back_string),getString(R.string.placeholder_nav_string)));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, getString(R.string.out_and_back_string),getString(R.string.placeholder_nav_string)));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, getString(R.string.out_and_back_string),getString(R.string.placeholder_nav_string)));

    }


}
