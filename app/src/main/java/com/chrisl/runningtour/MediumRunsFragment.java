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
        runList.add(new Run("The Bay Run", 7.0, R.drawable.the_bay_run, "Loop","https://www.google.com/maps/dir/King+George+Park,+Manning+St,+Rozelle+NSW+2039/-33.8626115,151.1449694/-33.8700275,151.1470873/King+George+Park,+Manning+Street,+Rozelle+NSW/@-33.8662631,151.1494623,15.5z/data=!4m21!4m20!1m10!1m1!1s0x6b12afea1c97d6e9:0xf017d68f9f2fb70!2m2!1d151.1627858!2d-33.8627547!3m4!1m2!1d151.161527!2d-33.8589261!3s0x6b12afeaf43b4c97:0x482af63abcdf04e9!1m0!1m0!1m5!1m1!1s0x6b12afea1c97d6e9:0xf017d68f9f2fb70!2m2!1d151.1627858!2d-33.8627547!3e2"));
        runList.add(new Run("Bondi to Coogee", 5.5,R.drawable.bondi_to_coogee, "One way", "https://www.google.com/maps/dir/Bondi+Beach,+NSW+2026/-33.9191843,151.2585023/@-33.9030795,151.269103,15z/data=!4m19!4m18!1m15!1m1!1s0x6b12ad9c447281c7:0x20c31809c62de978!2m2!1d151.2766845!2d-33.8914755!3m4!1m2!1d151.2760736!2d-33.8984394!3s0x6b12ad8374779e7f:0x5e2427877f11bdee!3m4!1m2!1d151.2676922!2d-33.9148545!3s0x6b12b26fe6b625eb:0x8c1c379ab02f5145!1m0!3e2"));
        runList.add(new Run("Spit to Manly", 8.8,R.drawable.spit_to_manly, "One way", "https://www.google.com/maps/dir/Bondi+Beach,+NSW+2026/-33.9191843,151.2585023/@-33.9030795,151.269103,15z/data=!4m19!4m18!1m15!1m1!1s0x6b12ad9c447281c7:0x20c31809c62de978!2m2!1d151.2766845!2d-33.8914755!3m4!1m2!1d151.2760736!2d-33.8984394!3s0x6b12ad8374779e7f:0x5e2427877f11bdee!3m4!1m2!1d151.2676922!2d-33.9148545!3s0x6b12b26fe6b625eb:0x8c1c379ab02f5145!1m0!3e2"));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, "Out and back","https://www.google.com.au/maps/dir/-33.8581101,151.21536/-33.8600804,151.2227072/-33.8631271,151.2217689/-33.8596638,151.2226761/-33.8581078,151.2152171/@-33.8598843,151.2189876,17.62z/data=!4m2!4m1!3e2"));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, "Out and back","https://www.google.com.au/maps/dir/-33.8581101,151.21536/-33.8600804,151.2227072/-33.8631271,151.2217689/-33.8596638,151.2226761/-33.8581078,151.2152171/@-33.8598843,151.2189876,17.62z/data=!4m2!4m1!3e2"));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, "Out and back","https://www.google.com.au/maps/dir/-33.8581101,151.21536/-33.8600804,151.2227072/-33.8631271,151.2217689/-33.8596638,151.2226761/-33.8581078,151.2152171/@-33.8598843,151.2189876,17.62z/data=!4m2!4m1!3e2"));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, "Out and back","https://www.google.com.au/maps/dir/-33.8581101,151.21536/-33.8600804,151.2227072/-33.8631271,151.2217689/-33.8596638,151.2226761/-33.8581078,151.2152171/@-33.8598843,151.2189876,17.62z/data=!4m2!4m1!3e2"));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, "Out and back","https://www.google.com.au/maps/dir/-33.8581101,151.21536/-33.8600804,151.2227072/-33.8631271,151.2217689/-33.8596638,151.2226761/-33.8581078,151.2152171/@-33.8598843,151.2189876,17.62z/data=!4m2!4m1!3e2"));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, "Out and back","https://www.google.com.au/maps/dir/-33.8581101,151.21536/-33.8600804,151.2227072/-33.8631271,151.2217689/-33.8596638,151.2226761/-33.8581078,151.2152171/@-33.8598843,151.2189876,17.62z/data=!4m2!4m1!3e2"));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, "Out and back","https://www.google.com.au/maps/dir/-33.8581101,151.21536/-33.8600804,151.2227072/-33.8631271,151.2217689/-33.8596638,151.2226761/-33.8581078,151.2152171/@-33.8598843,151.2189876,17.62z/data=!4m2!4m1!3e2"));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, "Out and back","https://www.google.com.au/maps/dir/-33.8581101,151.21536/-33.8600804,151.2227072/-33.8631271,151.2217689/-33.8596638,151.2226761/-33.8581078,151.2152171/@-33.8598843,151.2189876,17.62z/data=!4m2!4m1!3e2"));

    }
}
