package com.example.volleystudio.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.volleystudio.MyApp;

/**
 * Time:2019/4/16
 * Author:秦超蒙
 * Description:
 */
public class VolleyHttp {

    private static VolleyHttp volleyHttp=new VolleyHttp();

    //恶汉式
    public static VolleyHttp getInstance(){
        return volleyHttp;
    }

    //网络判断
    public boolean isConnected(Context context){
        if (context!=null){
            ConnectivityManager service =(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = service.getActiveNetworkInfo();
            if (info!=null){
              return   info.isConnected();
            }
        }
        return false;
    }

    //get请求
    public void VolleyGet(String url, final VolleyCallBack callBack){
           StringRequest stringRequest= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
callBack.onSuccess(response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
callBack.onFail(error);
                }
            });
        //设置请求的Tag标签，可以在全局请求队列中通过Tag标签进行请求的查找
        stringRequest.setTag("getvolley");
        //将请求加入全局队列中
        MyApp.getVolley().add(stringRequest);
    }



    //定义接口
   public interface VolleyCallBack{
        void onSuccess(String data);
        void onFail(VolleyError error);
    }
}
