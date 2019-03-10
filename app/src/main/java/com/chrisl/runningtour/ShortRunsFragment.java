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
        runList.add(new Run("Botanic Blast", 1.5, R.drawable.botanic_gardens, "Out and back","https://www.google.com.au/maps/dir/-33.8581101,151.21536/-33.8600804,151.2227072/-33.8631271,151.2217689/-33.8596638,151.2226761/-33.8581078,151.2152171/@-33.8598843,151.2189876,17.62z/data=!4m2!4m1!3e2"));
        runList.add(new Run("Bridge Dash", 2.7,R.drawable.sydney_harbour_bridge, "One way", "https://www.google.com/maps/dir/Milsons+Point+Station,+Milsons+Point+NSW+2061/-33.8546212,151.2094913/-33.860883,151.2068382/Cahill+Expressway+Lookout,+Sydney+NSW/@-33.853855,151.208523,16z/data=!4m16!4m15!1m5!1m1!1s0x6b12ae8b18dd9acb:0x4e8f9030e179e59b!2m2!1d151.2118241!2d-33.8458572!1m0!1m0!1m5!1m1!1s0x6b12ae684e18c45d:0x58d3153c800c0dc8!2m2!1d151.2124704!2d-33.8614186!3e2"));
        runList.add(new Run("Cremorne Crush", 2.9,R.drawable.cremorne_point, "Loop", "https://www.google.com/maps/dir/Cremorne+Reserve,+Milson+Road,+Cremorne+Point+NSW/-33.8379401,151.2286578/-33.8389253,151.2248535/-33.8452684,151.2283012/-33.847272,151.2310475/@-33.8430087,151.2283764,15.75z/data=!4m17!4m16!1m5!1m1!1s0x6b12ae9643c40311:0xa527a60a46503169!2m2!1d151.2317134!2d-33.8480337!1m5!3m4!1m2!1d151.2281929!2d-33.8381283!3s0x6b12ae9c05b27bf9:0xecd4149f536960ce!1m0!1m0!1m0!3e2"));
        runList.add(new Run("Centennial Circuit", 3.6,R.drawable.centennial_park, "Loop", "https://www.google.com/maps/dir/-33.894397,151.2331242/-33.8967864,151.2394943/-33.904451,151.2343437/-33.8978439,151.2280225/-33.8945443,151.2328624/@-33.8995063,151.2304804,16.5z/data=!4m2!4m1!3e2"));
        runList.add(new Run("Barangaroo Bounce", 1.5,R.drawable.barangaroo, "Loop", "https://www.google.com/maps/dir/-33.8616499,151.2006867/-33.8586052,151.2014258/-33.8556581,151.2008579/-33.8583196,151.2015326/@-33.858329,151.2022749,17.12z/data=!3m1!5s0x6b12ae67d234a27f:0xd6d4e9380ca1e32f!4m11!4m10!1m0!1m0!1m5!3m4!1m2!1d151.2021315!2d-33.856131!3s0x6b12ae5b27f9e323:0xf3872c8a65b4b879!1m0!3e2"));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, "Out and back","https://www.google.com.au/maps/dir/-33.8581101,151.21536/-33.8600804,151.2227072/-33.8631271,151.2217689/-33.8596638,151.2226761/-33.8581078,151.2152171/@-33.8598843,151.2189876,17.62z/data=!4m2!4m1!3e2"));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, "Out and back","https://www.google.com.au/maps/dir/-33.8581101,151.21536/-33.8600804,151.2227072/-33.8631271,151.2217689/-33.8596638,151.2226761/-33.8581078,151.2152171/@-33.8598843,151.2189876,17.62z/data=!4m2!4m1!3e2"));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, "Out and back","https://www.google.com.au/maps/dir/-33.8581101,151.21536/-33.8600804,151.2227072/-33.8631271,151.2217689/-33.8596638,151.2226761/-33.8581078,151.2152171/@-33.8598843,151.2189876,17.62z/data=!4m2!4m1!3e2"));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, "Out and back","https://www.google.com.au/maps/dir/-33.8581101,151.21536/-33.8600804,151.2227072/-33.8631271,151.2217689/-33.8596638,151.2226761/-33.8581078,151.2152171/@-33.8598843,151.2189876,17.62z/data=!4m2!4m1!3e2"));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, "Out and back","https://www.google.com.au/maps/dir/-33.8581101,151.21536/-33.8600804,151.2227072/-33.8631271,151.2217689/-33.8596638,151.2226761/-33.8581078,151.2152171/@-33.8598843,151.2189876,17.62z/data=!4m2!4m1!3e2"));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, "Out and back","https://www.google.com.au/maps/dir/-33.8581101,151.21536/-33.8600804,151.2227072/-33.8631271,151.2217689/-33.8596638,151.2226761/-33.8581078,151.2152171/@-33.8598843,151.2189876,17.62z/data=!4m2!4m1!3e2"));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, "Out and back","https://www.google.com.au/maps/dir/-33.8581101,151.21536/-33.8600804,151.2227072/-33.8631271,151.2217689/-33.8596638,151.2226761/-33.8581078,151.2152171/@-33.8598843,151.2189876,17.62z/data=!4m2!4m1!3e2"));

    }


}
