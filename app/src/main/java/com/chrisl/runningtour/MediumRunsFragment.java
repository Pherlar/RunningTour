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
public class MediumRunsFragment extends Fragment {

    private ArrayList<Run> runList;
    public MediumRunsFragment() {
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

    private void buildRunList()
    {
        runList = new ArrayList<>();
        runList.add(new Run("The Bay Run", 7.0, R.drawable.the_bay_run, getString(R.string.one_way),getString(R.string.bay_run_nav_string)));
        runList.add(new Run("Bondi to Coogee", 5.5,R.drawable.bondi_to_coogee, getString(R.string.one_way), getString(R.string.bondi_nav_string)));
        runList.add(new Run("Spit to Manly", 8.8,R.drawable.spit_to_manly, getString(R.string.one_way), getString(R.string.spit_nav_string)));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, getString(R.string.out_and_back_string),getString(R.string.placeholder_nav_string)));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, getString(R.string.out_and_back_string),getString(R.string.placeholder_nav_string)));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, getString(R.string.out_and_back_string),getString(R.string.placeholder_nav_string)));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, getString(R.string.out_and_back_string),getString(R.string.placeholder_nav_string)));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, getString(R.string.out_and_back_string),getString(R.string.placeholder_nav_string)));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, getString(R.string.out_and_back_string),getString(R.string.placeholder_nav_string)));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, getString(R.string.out_and_back_string),getString(R.string.placeholder_nav_string)));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, getString(R.string.out_and_back_string),getString(R.string.placeholder_nav_string)));

    }
}
