package com.chrisl.runningtour;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     //menu handlers automatically imported by Android studio
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                setTitle(R.string.app_name);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container, new HomeFragment())
                        .commit();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, new HomeFragment())
                .commit();
    }

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        } else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            Toast.makeText(this, getString(R.string.settings_feature_string),Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.button_short_runs)
        {
            setTitle(R.string.short_runs_string);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_container, new ShortRunsFragment())
                    .commit();
        }
        else if (id == R.id.button_medium_runs)
        {
            setTitle(R.string.medium_runs_string);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_container, new MediumRunsFragment())
                    .commit();
        } else if (id == R.id.button_long_runs)
        {
            setTitle(R.string.long_runs_string);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_container, new LongRunsFragment())
                    .commit();
        } else if (id == R.id.button_novelty_runs)
        {
            setTitle(R.string.novelty_runs_string);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_container, new NoveltyRunsFragment())
                    .commit();
        } else if (id == R.id.nav_share)
            Toast.makeText(this, getString(R.string.share_app_string),Toast.LENGTH_SHORT).show();
        {
//Possible future addition (send button)
        //} else if (id == R.id.nav_send)
        //{

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
