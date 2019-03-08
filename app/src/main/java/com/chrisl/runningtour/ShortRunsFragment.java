package com.chrisl.runningtour;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

        View rootView = inflater.inflate(R.layout.list_container, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view);
        RunAdapter adapter = new RunAdapter(runList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return rootView;
    }


    private void buildRunList()
    {
        runList = new ArrayList<>();
        runList.add(new Run("Botanic Blast", 1.5, R.drawable.background_image, "https://www.google.com.au/maps/dir/-33.8581101,151.21536/-33.8600804,151.2227072/-33.8631271,151.2217689/-33.8596638,151.2226761/-33.8581078,151.2152171/@-33.8598843,151.2189876,17.62z/data=!4m2!4m1!3e2"));
        runList.add(new Run("Bridge Dash", 2.7,R.drawable.sydney_harbour_bridge, "https://www.google.com/maps/dir/Milsons+Point+Station,+Milsons+Point+NSW+2061/-33.8546212,151.2094913/-33.860883,151.2068382/Cahill+Expressway+Lookout,+Sydney+NSW/@-33.853855,151.208523,16z/data=!4m16!4m15!1m5!1m1!1s0x6b12ae8b18dd9acb:0x4e8f9030e179e59b!2m2!1d151.2118241!2d-33.8458572!1m0!1m0!1m5!1m1!1s0x6b12ae684e18c45d:0x58d3153c800c0dc8!2m2!1d151.2124704!2d-33.8614186!3e2"));
    }
}
;