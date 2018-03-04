package com.example.gayathri.resume;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView nav = findViewById(R.id.nav_view);
        final AboutFragment frag1 = new AboutFragment();
        fragmentTransaction.add(R.id.frag1,frag1);
        fragmentTransaction.commit();
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                switch(item.getItemId()) {
                    case R.id.about:
                        mDrawerLayout.closeDrawer(GravityCompat.START);

                        /*Intent callIntent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:+919840249483"));
                        callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(callIntent);*/
                        fragmentTransaction.replace(R.id.frag1,frag1);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        return true;
                    case R.id.edu :
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        EducationFragment fragment = new EducationFragment();
                        fragmentTransaction.replace(R.id.frag1,fragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        return true;
                    case R.id.project :
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        ProjectFragment frag2 = new ProjectFragment();
                        fragmentTransaction.replace(R.id.frag1,frag2);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        return true;
                    case R.id.skills:
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        SkillFragment frag3 = new SkillFragment();
                        fragmentTransaction.replace(R.id.frag1,frag3);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        return true;
                    case R.id.roles :
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        RoleFragment frag4 = new RoleFragment();
                        fragmentTransaction.replace(R.id.frag1,frag4);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        return true;
                    case R.id.work :
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        WorkFragment frag5 = new WorkFragment();
                        fragmentTransaction.replace(R.id.frag1,frag5);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        return true;
                    case R.id.achievements :
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        AchievementFragment frag6 = new AchievementFragment();
                        fragmentTransaction.replace(R.id.frag1,frag6);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        return true;
                    case R.id.contact :
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        ContactFragment frag7 = new ContactFragment();
                        fragmentTransaction.replace(R.id.frag1,frag7);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        return true;
                }
                return true;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void project_open(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.github.com/Gayathri23599"));
        startActivity(Intent.createChooser(intent,"Complete action using"));
    }
    public void ph_open(View v){
        Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:+919445795612"));
        startActivity(intent);
    }
    public void fb_open(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.facebook.com/gayathri.23599"));
        startActivity(Intent.createChooser(intent,"Complete action using"));
    }
    public void mail_open(View v){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.setData(Uri.parse("iamanifs@gmail.com"));
        //intent.setClassName("com.google.android.gm","com.google.android.gm.ComposeActivityGmail");
        intent.setPackage("com.google.android.gm");
        intent.putExtra(Intent.EXTRA_EMAIL,new String[] { "iamanifs@gmail.com" });
        startActivity(Intent.createChooser(intent,"Complete action using"));
    }

}


