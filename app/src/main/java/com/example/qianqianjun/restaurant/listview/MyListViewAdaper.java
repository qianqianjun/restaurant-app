package com.example.qianqianjun.restaurant.listview;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.qianqianjun.restaurant.R;

import java.util.List;
import java.util.Map;

public class MyListViewAdaper extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<Map<String ,Object>> Data;
    public MyListViewAdaper(Context context,List<Map<String ,Object>> data)
    {
        this.mContext=context;
        mLayoutInflater=LayoutInflater.from(context);
        Data=data;
    }
    @Override
    public int getCount() {
        return Data.size();
    }

    @Override
    public Object getItem(int position) {
        return Data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    static class ViewHolder{
        public ImageView imageView;
        public TextView dishName;
        public TextView disPrice;
        public TextView disAddress;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null)
        {
            convertView=mLayoutInflater.inflate(R.layout.dishitem,null);
            holder=new ViewHolder();
            holder.imageView=convertView.findViewById(R.id.image_description);
            holder.disAddress=convertView.findViewById(R.id.dish_address);
            holder.dishName=convertView.findViewById(R.id.dish_name);
            holder.disPrice=convertView.findViewById(R.id.dish_price);
            convertView.setTag(holder);
        }
        else
        {
            holder=(ViewHolder) convertView.getTag();
        }
        //给控件赋值：
        holder.imageView.setBackgroundResource((Integer)Data.get(position).get("image"));
        holder.dishName.setText((String)Data.get(position).get("dishname"));
        holder.disPrice.setText((String) Data.get(position).get("dishprice"));
        holder.disAddress.setText((String) Data.get(position).get("disaddress"));
        return convertView;
    }
}
