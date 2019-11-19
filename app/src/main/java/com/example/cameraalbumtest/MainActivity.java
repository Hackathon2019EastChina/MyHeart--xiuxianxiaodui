package com.example.cameraalbumtest;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private String mBaseUrl="http://localhost:8080/okhttp/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void doGet(View view){
        //1.获取OkHttpClient对象
        OkHttpClient okHttpClient=new OkHttpClient();
        //2.构造Request
        Request.Builder builder=new Request.Builder();
        final Request request=builder.get().url(mBaseUrl+"login?username=jessie&password=1234").build();
        //3.将Request封装为Call
        Call call=okHttpClient.newCall(request);
        //4.执行call
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                L.e("onFailure: "+e.getMessage());
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                L.e("onResponse: ");
                final String res = response.body().string();
                L.e(res);
            }
        });
    }
}
