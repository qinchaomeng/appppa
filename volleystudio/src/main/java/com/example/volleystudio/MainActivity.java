package com.example.volleystudio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.volleystudio.adapter.MyAdapter;
import com.example.volleystudio.bean.HomeBean;
import com.example.volleystudio.showcontract.ContractInteface;
import com.example.volleystudio.showcontract.MyPresenter;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ContractInteface.ILoginView {
ContractInteface.ILoginPresenter iLoginPresenter;

    private ListView list_view;
    List<HomeBean.ResultBean> listm;
    private Gson gson;
    private HomeBean homeBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化
         list_view = findViewById(R.id.list_view);
         iLoginPresenter=new MyPresenter();
         iLoginPresenter.attch(this,this);
    }

    @Override
    public void getPresenter(String name) {
         gson=new Gson();
         homeBean = gson.fromJson(name, HomeBean.class);
        List<HomeBean.ResultBean> result = homeBean.getResult();
        list_view.setAdapter(new MyAdapter(this,result));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        iLoginPresenter.detch();
    }
}
