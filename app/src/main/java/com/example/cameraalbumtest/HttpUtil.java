package com.example.cameraalbumtest;


import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpUtil {
    //登录
    static void loginWithOkHttp(String address,String account,String password,okhttp3.Callback callback){
        //1.获取OkHttpClient对象
        OkHttpClient client = new OkHttpClient();
        //2.构造Request
        RequestBody body = new FormBody.Builder()
                .add("loginAccount",account)
                .add("loginPassword",password)
                .build();
        Request request = new Request.Builder()
                .url(address)
                .post(body)
                .build();
        //3.将Request封装为Call,并执行Call实例的异步方法
        client.newCall(request).enqueue(callback);
    }
    //注册
    static void registerWithOkHttp(String address,String account,String password,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("registerAccount",account)
                .add("registerPassword",password)
                .build();
        Request request = new Request.Builder()
                .url(address)
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);
    }
}
