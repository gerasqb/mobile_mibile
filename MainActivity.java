package com.homemade.barista;

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

import com.homemade.barista.fragments.FragmentExit;
import com.homemade.barista.fragments.FragmentGallery;
import com.homemade.barista.fragments.FragmentGallery2;
import com.homemade.barista.fragments.FragmentHome;
import com.homemade.barista.fragments.FragmentRandcof;
import com.homemade.barista.fragments.FragmentRecipe;
import com.homemade.barista.fragments.FragmentTools;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentHome fhome;
    FragmentGallery fgallery;
    FragmentGallery2 fgallery2;
    FragmentRandcof frandcof;
    FragmentRecipe frecipe;
    FragmentTools ftools;
    FragmentExit fexit;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fhome = new FragmentHome();
        fgallery = new FragmentGallery();
        fgallery2 = new FragmentGallery2();
        frandcof = new FragmentRandcof();
        frecipe = new FragmentRecipe();
        ftools = new FragmentTools();
        fexit = new FragmentExit();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        android.support.v4.app.FragmentTransaction ftrans = getSupportFragmentManager().beginTransaction();

        if (id == R.id.nav_home) {
            ftrans.replace(R.id.container, new FragmentHome());
            // Intent intent = new Intent(this, qwerty.class );
            //    startActivity(intent);
        } else if (id == R.id.nav_gallery) {
            ftrans.replace(R.id.container, fgallery);

        } else if (id == R.id.nav_randcof) {
            ftrans.replace(R.id.container, frandcof);
        } else if (id == R.id.nav_recipe) {
            ftrans.replace(R.id.container, frecipe);
        }
//        } else if (id == R.id.nav_tools) {
//            ftrans.replace(R.id.container, ftools);
//        } else if (id == R.id.nav_exit) {
//            ftrans.replace(R.id.container, fexit);
//        }
        ftrans.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
