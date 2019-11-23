package com.example.cameraalbumtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MoodDiary extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    BottomNavigationView bottomNavigationView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_diary);

        bottomNavigationView=(BottomNavigationView)findViewById(R.id.bottomNavigation);
        textView=(TextView)findViewById(R.id.text_id);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item){
        int id=item.getItemId();
        switch(id){
            case R.id.diaries:
                textView.setText(item.getTitle());
                break;
            case R.id.articles:
                Intent intent2=new Intent(MoodDiary.this,WebViewActivity.class);
                startActivity(intent2);
                break;
            case R.id.chatting:
                Intent intent3=new Intent(MoodDiary.this,Chatting.class);
                startActivity(intent3);
                break;
            default:
        }
        return true;
    }
}
