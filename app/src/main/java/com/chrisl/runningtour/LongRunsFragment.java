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
        runList.add(new Run("Brighton-Le-Sands tourer", 16.1, R.drawable.brighton_le_sands, "Out and back","https://www.google.com/maps/dir/St+George+Sailing+Club,+Riverside+Drive,+Sans+Souci+NSW/-33.9485161,151.166378/St+George+Sailing+Club,+Riverside+Drive,+Sans+Souci+NSW/@-33.9763008,151.1459433,14z/data=!4m20!4m19!1m10!1m1!1s0x6b12b825a55840d9:0x572f5f776cd5bece!2m2!1d151.130578!2d-34.005187!3m4!1m2!1d151.1643596!2d-33.9497536!3s0x6b12b0c809745041:0xd52055a3b0816e9f!1m0!1m5!1m1!1s0x6b12b825a55840d9:0x572f5f776cd5bece!2m2!1d151.130578!2d-34.005187!3e2"));
        runList.add(new Run("Cooks River Run", 19.6,R.drawable.cooks_river_run, "One way", "https://www.google.com/maps/dir/Tempe+Station,+Tempe+NSW+2044/Olympic+Park+Station/@-33.8699856,151.0905242,12.75z/data=!4m64!4m63!1m55!1m1!1s0x6b12b08e60526803:0x64f7c72199c35778!2m2!1d151.156407!2d-33.9244938!3m4!1m2!1d151.1435091!2d-33.9220607!3s0x6b12b08319f1a2cf:0x467659f77f273fd8!3m4!1m2!1d151.1390531!2d-33.9221636!3s0x6b12ba781f2e8bb1:0x2da563a225c2a42c!3m4!1m2!1d151.1376777!2d-33.915228!3s0x6b12ba7f1a6aaf35:0xda7e21e6a71440e0!3m4!1m2!1d151.125916!2d-33.9144941!3s0x6b12ba6486984d1b:0x9cf17ca6e7e10f83!3m4!1m2!1d151.1135558!2d-33.9074924!3s0x6b12ba5f6ff94a5f:0x9260b0a57403345c!3m4!1m2!1d151.0912137!2d-33.9011025!3s0x6b12bbaa8e8c8b25:0x13017d67e682d3a1!3m4!1m2!1d151.0865464!2d-33.8979665!3s0x6b12bb0743ba5c2d:0x542024e0d410e97!3m4!1m2!1d151.0678332!2d-33.8719208!3s0x6b12bb40516c9231:0xee04ed1e54c2a150!3m4!1m2!1d151.0838817!2d-33.8577537!3s0x6b12bb2d30ac067f:0xbacabc04591b007!3m4!1m2!1d151.0798759!2d-33.8460383!3s0x6b12a4cf91cb4459:0x13017d67e580a0f0!1m5!1m1!1s0x6b12a4b63832259f:0x550bedacd0dc0c67!2m2!1d151.0695205!2d-33.8465207!3e2"));
        runList.add(new Run("Sydney Harbour Explorer", 18.0,R.drawable.anzac_bridge, "Urban Loop", "https://www.google.com/maps/dir/Sydney+Opera+House,+Bennelong+Point,+Sydney+NSW+2000/-33.8725864,151.1778031/-33.8681876,151.1783732/-33.871905,151.2112157/-33.8671302,151.2178891/Sydney+Opera+House,+Bennelong+Point,+Sydney+NSW+2000/@-33.863738,151.1901463,15z/data=!3m1!5s0x6b12ae67d234a27f:0xd6d4e9380ca1e32f!4m48!4m47!1m30!1m1!1s0x6b12ae665e892fdd:0x3133f8d75a1ac251!2m2!1d151.2152967!2d-33.8567844!3m4!1m2!1d151.2106096!2d-33.8555918!3s0x6b12ae5d865adaf5:0x8150dc5a5aa7f5df!3m4!1m2!1d151.2008579!2d-33.8556581!3s0x6b12ae5b27f9e323:0xf3872c8a65b4b878!3m4!1m2!1d151.2012779!2d-33.8698342!3s0x6b12ae39aa5fc945:0x765f3e14871aa968!3m4!1m2!1d151.1941841!2d-33.8624115!3s0x6b12ae49913c576b:0xac167eb3009193fb!3m4!1m2!1d151.1871983!2d-33.8682965!3s0x6b12ae34bf0512ef:0x67d144bb51b2d898!1m0!1m5!3m4!1m2!1d151.2001145!2d-33.8732451!3s0x6b12ae3a41127c9b:0xe41b03e1a615f18d!1m0!1m0!1m5!1m1!1s0x6b12ae665e892fdd:0x3133f8d75a1ac251!2m2!1d151.2152967!2d-33.8567844!3e2"));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, "Out and back","https://www.google.com.au/maps/dir/-33.8581101,151.21536/-33.8600804,151.2227072/-33.8631271,151.2217689/-33.8596638,151.2226761/-33.8581078,151.2152171/@-33.8598843,151.2189876,17.62z/data=!4m2!4m1!3e2"));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, "Out and back","https://www.google.com.au/maps/dir/-33.8581101,151.21536/-33.8600804,151.2227072/-33.8631271,151.2217689/-33.8596638,151.2226761/-33.8581078,151.2152171/@-33.8598843,151.2189876,17.62z/data=!4m2!4m1!3e2"));
        runList.add(new Run("Placeholder", 1.0, R.drawable.background_image, "Out and back","https://www.google.com.au/maps/dir/-33.8581101,151.21536/-33.8600804,151.2227072/-33.8631271,151.2217689/-33.8596638,151.2226761/-33.8581078,151.2152171/@-33.8598843,151.2189876,17.62z/data=!4m2!4m1!3e2"));
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
