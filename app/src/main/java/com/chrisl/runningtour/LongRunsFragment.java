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

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class LongRunsFragment extends Fragment {


    private ArrayList<Run> runList;
    public LongRunsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        buildRunList();

        View v = inflater.inflate(R.layout.list_container, container, false);

        RecyclerView recyclerView = v.findViewById(R.id.recycler_view);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
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
                        //Toast.makeText(getContext(), "Share Icon at Position " + mPosition, Toast.LENGTH_SHORT).show();
                        try
                        {
                            Intent i = new Intent(Intent.ACTION_SEND);
                            i.setType("text/plain");
                            i.putExtra(Intent.EXTRA_SUBJECT, "@string/app_name");
                            String message = getString(R.string.im_using_string)+ getResources().getString(R.string.app_name) + getString(R.string.to_recommend_String);
                            message = message + " "+ currentRun.getNavigationString();
                            i.putExtra(Intent.EXTRA_TEXT, message);
                            startActivity(Intent.createChooser(i, getString(R.string.choose_one_string)));

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


    private void buildRunList()
    {
        runList = new ArrayList<>();
        runList.add(new Run(getString(R.string.brighton_le_sands_tourer_string), 16.1, R.drawable.brighton_le_sands, getString(R.string.out_and_back_string),getString(R.string.brighton_nav_string)));
        runList.add(new Run(getString(R.string.cooks_river_run_string), 19.6,R.drawable.cooks_river_run, getString(R.string.one_way_String), getString(R.string.cooks_river_nav_string)));
        runList.add(new Run(getString(R.string.sydney_harbour_explorer_string), 18.0,R.drawable.anzac_bridge, getString(R.string.urban_loop_string), getString(R.string.opera_house_nav_string)));
        runList.add(new Run(getString(R.string.placeholder_string), 1.0, R.drawable.background_image, getString(R.string.out_and_back_string),getString(R.string.placeholder_nav_string)));
        runList.add(new Run(getString(R.string.placeholder_string), 1.0, R.drawable.background_image, getString(R.string.out_and_back_string),getString(R.string.placeholder_nav_string)));
        runList.add(new Run(getString(R.string.placeholder_string), 1.0, R.drawable.background_image, getString(R.string.out_and_back_string),getString(R.string.placeholder_nav_string)));
        runList.add(new Run(getString(R.string.placeholder_string), 1.0, R.drawable.background_image, getString(R.string.out_and_back_string),getString(R.string.placeholder_nav_string)));
        runList.add(new Run(getString(R.string.placeholder_string), 1.0, R.drawable.background_image, getString(R.string.out_and_back_string),getString(R.string.placeholder_nav_string)));
        runList.add(new Run(getString(R.string.placeholder_string), 1.0, R.drawable.background_image, getString(R.string.out_and_back_string),getString(R.string.placeholder_nav_string)));
        runList.add(new Run(getString(R.string.placeholder_string), 1.0, R.drawable.background_image, getString(R.string.out_and_back_string),getString(R.string.placeholder_nav_string)));
        runList.add(new Run(getString(R.string.placeholder_string), 1.0, R.drawable.background_image, getString(R.string.out_and_back_string),getString(R.string.placeholder_nav_string)));
        runList.add(new Run(getString(R.string.placeholder_string), 1.0, R.drawable.background_image, getString(R.string.out_and_back_string),getString(R.string.placeholder_nav_string)));
        runList.add(new Run(getString(R.string.placeholder_string), 1.0, R.drawable.background_image, getString(R.string.out_and_back_string),getString(R.string.placeholder_nav_string)));
        runList.add(new Run(getString(R.string.placeholder_string), 1.0, R.drawable.background_image, getString(R.string.out_and_back_string),getString(R.string.placeholder_nav_string)));

    }
}
