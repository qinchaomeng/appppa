package com.example.volleystudio.showcontract;

import android.content.Context;

/**
 * Time:2019/4/16
 * Author:秦超蒙
 * Description:
 */
public class MyPresenter implements ContractInteface.ILoginPresenter {
    private ContractInteface.ILoginView iLoginView;
    private MyModel myModel;

    @Override
    public void getModel() {

    }

    @Override
    public void attch(Context context,ContractInteface.ILoginView view) {
this.iLoginView=view;
myModel=new MyModel();
myModel.login(context,new ContractInteface.ILoginModel.CallBack() {
    @Override
    public void onSuccess(String names) {
        iLoginView.getPresenter(names);
    }

    @Override
    public void onFail() {

    }
});
    }

    @Override
    public void detch() {
        if (iLoginView!=null){
            iLoginView=null;
        }
        if (myModel!=null){
            myModel=null;
        }
        //防止内存溢出
        System.gc();
    }

}
