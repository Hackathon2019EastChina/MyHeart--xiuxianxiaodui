package com.example.cameraalbumtest;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText acc_etext;
    private EditText psd_etext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        acc_etext=findViewById(R.id.acc_etext);
        psd_etext=findViewById(R.id.psd_etext);
        Button login=findViewById(R.id.login_btn);
        Button register=findViewById(R.id.register_btn);

        register.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_btn:
                String loginAddress="http://10.203.161.36:8080/WebClient3/LoginServlet";
                String loginAccount = acc_etext.getText().toString();
                String loginPassword = psd_etext.getText().toString();
                loginWithOkHttp(loginAddress,loginAccount,loginPassword);
                break;
            case R.id.register_btn:
                String registerAddress="http://10.203.161.36:8080/WebClient3/RegisterServlet";
                String registerAccount = acc_etext.getText().toString();
                String registerPassword = psd_etext.getText().toString();
                registerWithOkHttp(registerAddress,registerAccount,registerPassword);
                break;
            default:
                break;
        }
    }

    //实现登录
    public void loginWithOkHttp(String address,String account,String password){
        HttpUtil.loginWithOkHttp(address,account,password, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //在这里对异常情况进行处理
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //得到服务器返回的具体内容
                final String responseData = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (responseData.equals("true")){
                            Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    //实现注册
    public void registerWithOkHttp(String address,String account,String password) {
        HttpUtil.registerWithOkHttp(address, account, password, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //在这里对异常情况进行处理
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseData = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (responseData.equals("true")) {
                            Toast.makeText(MainActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
