package kwa.pumps.ndrapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class Report extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
        Button new_bt,reported_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        final Context context=getApplicationContext();
        new_bt=findViewById(R.id.bt_new);
        reported_bt=findViewById(R.id.bt_Reported);
        new_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(context,NewReport.class);
                startActivity(myIntent);
            }
        });
        reported_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(context,Reported.class);
                startActivity(myIntent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
       /* if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }*/

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Context context=getApplicationContext();

        if (id == R.id.nav_home) {
            // Handle the home action
            Intent myIntent = new Intent(context,MainActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_profile) {
            Intent myIntent = new Intent(context,Profile.class);
            startActivity(myIntent);

        } else if (id == R.id.nav_report) {
            Intent myIntent = new Intent(context,Report.class);
            startActivity(myIntent);


        } else if (id == R.id.nav_reportfile) {
            Intent myIntent = new Intent(context,ReportFiles.class);
            startActivity(myIntent);

        } else if (id == R.id.nav_settings) {
            Intent myIntent = new Intent(context,Settings.class);
            startActivity(myIntent);


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
