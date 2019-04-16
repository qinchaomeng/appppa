package com.example.volleystudio.showcontract;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.volleystudio.util.VolleyHttp;

/**
 * Time:2019/4/16
 * Author:秦超蒙
 * Description:
 */
public class MyModel implements ContractInteface.ILoginModel {
    public  static final String urls="http://172.17.8.100/movieApi/cinema/v1/findRecommendCinemas?page=1&count=10";
    private boolean connected;
Handler handler=new Handler();
    @Override
    public void login(final Context context,final CallBack callBack) {

        VolleyHttp volleyHttp=VolleyHttp.getInstance();
         connected = volleyHttp.isConnected(context);
         if (connected){
             volleyHttp.VolleyGet(urls, new VolleyHttp.VolleyCallBack()
             {
                 @Override
                 public void onSuccess(String data) {
                     callBack.onSuccess(data);
                 }

                 @Override
                 public void onFail(VolleyError error) {

                 }
             });
         }else {
             //子线程
             new Thread(new Runnable() {
                 @Override
                 public void run() {
handler.post(new Runnable() {
    @Override
    public void run() {
        Toast.makeText(context, "网络连接失败", Toast.LENGTH_SHORT).show();
    }
});
                 }
             }){

             }.start();
         }

    }
}
