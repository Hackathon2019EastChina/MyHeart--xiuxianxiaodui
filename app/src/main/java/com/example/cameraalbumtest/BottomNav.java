package com.example.cameraalbumtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.material.bottomnavigation.BottomNavigationView;

//implements BottomNavigationView.OnNavigationItemSelectedListener
public class BottomNav extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);

        bottomNavigationView=(BottomNavigationView)findViewById(R.id.bottomNavigation);
        //bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.content,new MoodDiaries()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                   Fragment selectedFragment=null;
                   switch (menuItem.getItemId()){
                       case R.id.diaries:
                           selectedFragment=new MoodDiaries();
                           break;
                       case R.id.articles:
                           selectedFragment=new WebViewActivity();
                           break;
                       case R.id.chatting:
                           selectedFragment=new Chatting();
                   }
                    getSupportFragmentManager().beginTransaction().replace(R.id.content,selectedFragment).commit();
                    return true;
                }
            };

}
