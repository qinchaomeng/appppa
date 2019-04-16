package com.example.volleystudio.showcontract;

import android.content.Context;

/**
 * Time:2019/4/16
 * Author:秦超蒙
 * Description:
 */
public interface ContractInteface {
    //Iview
    public interface ILoginView {
        // 获取数据方法
        void getPresenter(String name);
    }

    //Imodel
    public interface ILoginModel {
        //业务数据处理， 数据库，网络数据
        /**
         * 1.定义接口
         *
         */
        void  login(Context context,ILoginModel.CallBack callBack);

        interface CallBack{
            //成功返回
            void  onSuccess(String names);
            //失败返回
            void  onFail();
        }
    }
    //Ipresenter
    public interface ILoginPresenter {
        /*
         * presenter 提供view与model 交互的纽带
         * */
        //
        void  getModel();
        //绑定
        void  attch(Context context,ILoginView view);
        //解绑
        void  detch();

    }

}
