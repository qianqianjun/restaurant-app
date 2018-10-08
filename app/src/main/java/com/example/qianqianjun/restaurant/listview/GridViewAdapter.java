package com.example.qianqianjun.restaurant.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.qianqianjun.restaurant.R;

import java.util.List;

public class GridViewAdapter extends BaseAdapter {
    Context context;
    List<CityItem> list;
    public GridViewAdapter(Context _context, List<CityItem> _list) {
        this.list = _list;
        this.context = _context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.list_item_hor, null);
        TextView tvCity = (TextView) convertView.findViewById(R.id.tvCity);
        TextView tvCode = (TextView) convertView.findViewById(R.id.tvCode);
        CityItem city = list.get(position);
        tvCity.setText(city.getCityName());
        tvCode.setText(city.getCityCode());
        return convertView;
    }
}