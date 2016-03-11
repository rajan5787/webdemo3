package com.example.rajanpipaliya.webdemo3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by rajan pipaliya on 7/9/2015.
 */
public class custom_adapter extends BaseAdapter {
    Context mContext;
    ArrayList<data> mArrayList;
    LayoutInflater mInflater;
    ImageView path;
    public custom_adapter(Context mContext, ArrayList<data> mArrayList) {
        this.mContext = mContext;
        this.mArrayList = mArrayList;
        this.mInflater=(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        custom_list_holder holder=null;
        if(holder==null){
            convertView=mInflater.inflate(R.layout.custom_list_view,null);
            holder=new custom_list_holder((TextView)convertView.findViewById(R.id.id1),(TextView)convertView.findViewById(R.id.country),(TextView)convertView.findViewById(R.id.rigion),(ImageView)convertView.findViewById(R.id.imageview));
            convertView.setTag(holder);
        }
        else{
            holder=(custom_list_holder)convertView.getTag();
        }
        holder.getId().setText("COUNTRU ID      :"+mArrayList.get(position).getId()+"");
        holder.getCountry().setText("COUNTRY NAME   :"+mArrayList.get(position).getCountry());
        holder.getRigion().setText("COUNTRY RIGION :"+mArrayList.get(position).getRigion());
        String path1=mArrayList.get(position).getImage();
        path1=path1.replace("~","http://www.jinalshah.brainoorja.com");
        Picasso.with(mContext).load(path1).into(holder.getImageView());
        return convertView;
    }
}
