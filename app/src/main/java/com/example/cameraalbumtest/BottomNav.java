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
        getSupportFragmentManager().beginTransaction().replace(R.id.content,new WebViewActivity()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                   Fragment selectedFragment=null;
                   switch (menuItem.getItemId()){
                       case R.id.diaries:
                           selectedFragment=new MoodDiaries();
                           getSupportFragmentManager().beginTransaction().replace(R.id.content,selectedFragment).commit();
                           break;
                       case R.id.articles:
                           selectedFragment=new WebViewActivity();
                           getSupportFragmentManager().beginTransaction().replace(R.id.content,selectedFragment).commit();
                           break;
                       case R.id.chatting:
                           Intent intent=new Intent(BottomNav.this,MainActivity.class);
                           startActivity(intent);
                   }
                    return true;
                }
            };

}
