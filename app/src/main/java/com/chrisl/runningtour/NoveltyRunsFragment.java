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
public class NoveltyRunsFragment extends Fragment {

    private ArrayList<Run> runList;
    public NoveltyRunsFragment() {
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


    private void buildRunList() {
        runList = new ArrayList<>();

        runList.add(new Run("Sydney Colour Run", 5.0, R.drawable.colour_run, "Fun Run - Official Event","https://www.google.com/maps/place/Cathy+Freeman+Park/@-33.8461001,151.0642342,17z/data=!3m1!4b1!4m5!3m4!1s0x6b12a4b6e8fe8907:0x29d253d349bbaf78!8m2!3d-33.8461001!4d151.0664229"));
        runList.add(new Run("Waverton Stair Sesh", 1.0, R.drawable.gas_works, "Stairs and Hills Loop","https://www.google.com/maps/dir/-33.8369084,151.1936562/-33.8389141,151.1951991/-33.8362678,151.1985424/14+Ross+St,+Waverton+NSW+2060/@-33.8386406,151.1953206,16.83z/data=!4m16!4m15!1m0!1m5!3m4!1m2!1d151.1944042!2d-33.8362059!3s0x6b12aefb0d4f5a51:0xcd4a0ba762c1a00e!1m0!1m5!1m1!1s0x6b12aefbc3907fd9:0x5bf4f6b150e10775!2m2!1d151.1945419!2d-33.8387782!3e2"));
        runList.add(new Run("Beer Belly Bolt", 9.4, R.drawable.grifter, "One Way Brewery Tour","https://www.google.com/maps/dir/Rocks+Brewing+Co,+Building+2,+160+Bourke+Rd,+Alexandria+NSW+2015/Batch+Brewing+Company,+Sydenham+Road,+Marrickville+NSW/Stockade+Brew+Co,+Cadogan+Street,+Marrickville+NSW/Sauce+Brewing+Co,+Mitchell+Street,+Marrickville+NSW/Wildflower+Brewing+%26+Blending,+Brompton+Street,+Marrickville+NSW/The+Grifter+Brewing+Co.,+Enmore+Road,+Marrickville+NSW/Hopsters+Cooperative+Brewery,+Enmore+Road,+Enmore+NSW/Young+Henrys,+76+Wilford+St,+Newtown+NSW+2042/Wayward+Brewing+Co.,+Gehrig+Lane,+Camperdown+NSW/@-33.9035718,151.1595216,14z/data=!3m1!4b1!4m56!4m55!1m5!1m1!1s0x6b12b1adec7c61a1:0x9b3fee872ca567d3!2m2!1d151.1918605!2d-33.916473!1m5!1m1!1s0x6b12b05d97615c6f:0x2b07bb38c8414eb4!2m2!1d151.16474!2d-33.911921!1m5!1m1!1s0x6b12f1e90513de03:0x753cb4dc4f8c9d0e!2m2!1d151.1660599!2d-33.9104904!1m5!1m1!1s0x6b12b0681b32ad97:0x587b48a4c154a723!2m2!1d151.1631248!2d-33.907559!1m5!1m1!1s0x6b12b0424756adb5:0xb65e9782293525e0!2m2!1d151.1653997!2d-33.9049595!1m5!1m1!1s0x6b12b043db81d587:0x55a2b9a620a94a2c!2m2!1d151.1676207!2d-33.904677!1m5!1m1!1s0x6b12b01fc98dace7:0x57a13a6907922070!2m2!1d151.1716968!2d-33.8992511!1m5!1m1!1s0x6b12b039cdab5369:0xe8ce8753c84e0f5a!2m2!1d151.174359!2d-33.898107!1m5!1m1!1s0x6b12b025fdd82f95:0x3f8868317d2795d3!2m2!1d151.1748604!2d-33.8857455!3e2"));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, "Out and back","https://www.google.com.au/maps/dir/-33.8581101,151.21536/-33.8600804,151.2227072/-33.8631271,151.2217689/-33.8596638,151.2226761/-33.8581078,151.2152171/@-33.8598843,151.2189876,17.62z/data=!4m2!4m1!3e2"));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, "Out and back","https://www.google.com.au/maps/dir/-33.8581101,151.21536/-33.8600804,151.2227072/-33.8631271,151.2217689/-33.8596638,151.2226761/-33.8581078,151.2152171/@-33.8598843,151.2189876,17.62z/data=!4m2!4m1!3e2"));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, "Out and back","https://www.google.com.au/maps/dir/-33.8581101,151.21536/-33.8600804,151.2227072/-33.8631271,151.2217689/-33.8596638,151.2226761/-33.8581078,151.2152171/@-33.8598843,151.2189876,17.62z/data=!4m2!4m1!3e2"));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, "Out and back","https://www.google.com.au/maps/dir/-33.8581101,151.21536/-33.8600804,151.2227072/-33.8631271,151.2217689/-33.8596638,151.2226761/-33.8581078,151.2152171/@-33.8598843,151.2189876,17.62z/data=!4m2!4m1!3e2"));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, "Out and back","https://www.google.com.au/maps/dir/-33.8581101,151.21536/-33.8600804,151.2227072/-33.8631271,151.2217689/-33.8596638,151.2226761/-33.8581078,151.2152171/@-33.8598843,151.2189876,17.62z/data=!4m2!4m1!3e2"));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, "Out and back","https://www.google.com.au/maps/dir/-33.8581101,151.21536/-33.8600804,151.2227072/-33.8631271,151.2217689/-33.8596638,151.2226761/-33.8581078,151.2152171/@-33.8598843,151.2189876,17.62z/data=!4m2!4m1!3e2"));

    }
}
