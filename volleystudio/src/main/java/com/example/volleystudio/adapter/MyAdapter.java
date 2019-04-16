package com.example.volleystudio.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.volleystudio.R;
import com.example.volleystudio.bean.HomeBean;


import java.util.List;
import java.util.zip.Inflater;



public class MyAdapter extends BaseAdapter {

    Context context;
    private List<HomeBean.ResultBean> homeBeanResult;
    private ViewHodels viewHodels;
    private View inflate;

    public MyAdapter(Context context, List<HomeBean.ResultBean> homeBean) {
        this.context=context;
        this.homeBeanResult=homeBean;


    }

    @Override
    public int getCount() {
        return homeBeanResult.size();
    }

    @Override
    public Object getItem(int position) {
        return homeBeanResult.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            ViewHodels viewHodels = null;
            if(convertView==null){
                viewHodels= new ViewHodels();
                convertView  = LayoutInflater.from(context).inflate(R.layout.show_list, null);
                viewHodels.textView=convertView.findViewById(R.id.view_name);
                viewHodels.imageView=convertView.findViewById(R.id.view_image);
                viewHodels.textView1=convertView.findViewById(R.id.view_price);
               convertView.setTag(viewHodels);
            }else {
                viewHodels= (ViewHodels) convertView.getTag();
            }
        viewHodels.textView1.setText(homeBeanResult.get(position).getAddress());
        viewHodels.textView.setText(homeBeanResult.get(position).getName());
        RequestOptions options=RequestOptions.circleCropTransform();
        Glide.with(context).load(homeBeanResult.get(position).getLogo()).apply(options).into(viewHodels.imageView);
        return convertView;
    }

    class  ViewHodels{
        TextView  textView,textView1;
        ImageView imageView;


    }



}
