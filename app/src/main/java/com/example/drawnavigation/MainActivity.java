package com.example.drawnavigation;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import com.example.drawnavigation.extra.BaseActivity;
import com.example.drawnavigation.fragment.PartnershipFragment;
import com.example.drawnavigation.fragment.PartnershipsFragment;
import com.example.drawnavigation.fragment.ScholarshipFragment;
import com.example.drawnavigation.fragment.SeminarFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawer;
    public TextView today, title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        final View view =  findViewById(R.id.drawer_layout);
        init();

    }

    private void init() {
        setToolbar();
        setNavigationDrawer();
        //init first FragmentManager
        FragmentManager manager = getFragmentManager();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container,  new SeminarFragment());
        ft.addToBackStack(null);
        ft.commit();
    }

    private void setToolbar() {
        toolbar =  findViewById(R.id.tool_bar);
//      title.setText(getString(R.string.dashBoard));
        setSupportActionBar(toolbar);
    }

    private void setNavigationDrawer() {

        drawer =  findViewById(R.id.drawer_layout);

        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        assert drawer != null;
        toggle.setDrawerIndicatorEnabled(false);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        assert navigationView != null;
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.menu, this.getTheme());
        toggle.setHomeAsUpIndicator(drawable);
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerVisible(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        Intent intent;
        switch (item.getItemId()) {
            case R.id.nav_seminar:


                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container,  new SeminarFragment());
                ft.commit();
                drawer.closeDrawers();
//                intent = new Intent(MainActivity.this, SeminarActivity.class);
               // intent.putExtra(Keys.KEY_EMPLOYEE_ID, employeeID);
//                startActivity(intent);
                break;
            case R.id.nav_scholarship:

                FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
                ft1.replace(R.id.container,  new ScholarshipFragment());
                ft1.commit();
                drawer.closeDrawers();
                break;


            case R.id.nav_partnership:

                FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
                ft2.replace(R.id.container,  new PartnershipsFragment());
                ft2.commit();
                drawer.closeDrawers();
                break;
            case R.id.nav_partnershipwebview:

                FragmentTransaction ft3 = getSupportFragmentManager().beginTransaction();
                ft3.replace(R.id.container,  new PartnershipFragment());
                ft3.commit();
                drawer.closeDrawers();
                break;
        }
//       drawer = findViewById(R.id.drawer_layout);
//        drawer.closeDrawer();
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        //  viewPager.setCurrentItem(0);
//        sessionManager.checkLogin();

    }


}






//public class MainActivity extends AppCompatActivity {
//
//    private AppBarConfiguration mAppBarConfiguration;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        //setSupportActionBar(toolbar);
////        FloatingActionButton fab = findViewById(R.id.fab);
////        fab.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
////                        .setAction("Action", null).show();
////            }
////        });
//        DrawerLayout drawer = findViewById(R.id.drawer_layout);
//        NavigationView navigationView = findViewById(R.id.nav_view);
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        mAppBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.nav_gallery, R.id.nav_slideshow,
//                R.id.nav_tools)
////                R.id.nav_share, R.id.nav_send)
//                .setDrawerLayout(drawer)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);
//
//}
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
//                || super.onSupportNavigateUp();
//    }
//}
