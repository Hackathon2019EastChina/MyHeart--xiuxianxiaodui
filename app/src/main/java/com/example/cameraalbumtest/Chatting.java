package com.example.cameraalbumtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Chatting extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    BottomNavigationView bottomNavigationView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

        bottomNavigationView=(BottomNavigationView)findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        textView=(TextView)findViewById(R.id.text_chatting);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item){
        int id=item.getItemId();
        switch(id){
            case R.id.diaries:
                Intent intent1=new Intent(Chatting.this,MoodDiary.class);
                startActivity(intent1);
                break;
            case R.id.articles:
                Intent intent2=new Intent(Chatting.this,WebViewActivity.class);
                startActivity(intent2);
                break;
            case R.id.chatting:
                textView.setText(item.getTitle());
                break;
            default:
        }
        return true;
    }
}
