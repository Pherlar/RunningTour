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


    public ShortRunsFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        RecyclerView rootView =  new RecyclerView(getContext());
        rootView.setLayoutManager(new LinearLayoutManager(getContext()));

        //create the Array list of runs
        ArrayList<Run> runs = new ArrayList<>();
        //add runs to list
        runs.add(new Run("Run1",1.5,R.drawable.background_image, "https://www.google.com.au/maps/dir/-33.8581101,151.21536/-33.8600804,151.2227072/-33.8631271,151.2217689/-33.8596638,151.2226761/-33.8581078,151.2152171/@-33.8598843,151.2189876,17.62z/data=!4m2!4m1!3e2"));


        //TODO: FELIX I NEED A LITTLE HELP HERE!!!

        //rootView.setAdapter(new RunAdapter(runs


        //Create the run adapter
        //RunAdapter runAdapter = new RunAdapter(getActivity(),);

        //Find the object in the view hierarchy.
        //This is the Recycler View with the view ID called list_container

        //RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.list_container);

        //Make the Recycler View use the run adapter created above
        //recyclerView.setAdapter(runAdapter);




























        return rootView;
    }

}
