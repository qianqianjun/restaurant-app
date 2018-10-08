package com.example.qianqianjun.restaurant.fragment;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.qianqianjun.restaurant.R;
import com.example.qianqianjun.restaurant.listview.*;

import java.util.ArrayList;
import java.util.List;

public class TryNewFragment extends Fragment {

    private GridView gridView_breakfast;
    private GridView gridView_lunch;
    private GridView gridView_supper;
    private RelativeLayout itmel;
    private List<CityItem> cityList;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_trynew,container,false);
        return view;
    }
    private void setData() {
        cityList = new ArrayList<CityItem>();
        CityItem item = new CityItem();
        item.setCityName("深圳");
        item.setCityCode("0755");
        cityList.add(item);
        item = new CityItem();
        item.setCityName("上海");
        item.setCityCode("021");
        cityList.add(item);
        item = new CityItem();
        item.setCityName("广州");
        item.setCityCode("020");
        cityList.add(item);
        item = new CityItem();
        item.setCityName("北京");
        item.setCityCode("010");
        cityList.add(item);
        item = new CityItem();
        item.setCityName("武汉");
        item.setCityCode("027");
        cityList.add(item);
        item = new CityItem();
        item.setCityName("孝感");
        item.setCityCode("0712");
        cityList.add(item);
        cityList.addAll(cityList);

    }
    //执行fragment创建之后的动作
    public void onViewCreated(View v, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(v,savedInstanceState);
        //初始化数据：
        setData();
        //初始化屏幕参数和数据：
        int size = cityList.size();
        Integer elemWidth=120;
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        float density = dm.density;
        int gridViewWidth = (int) (size * (elemWidth) * density);
        int itemWidth = (int) (elemWidth * density);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                gridViewWidth, LinearLayout.LayoutParams.MATCH_PARENT);
        //设置早餐的参数：
        gridView_breakfast = (GridView) view.findViewById(R.id.breakfast_grid);
        gridView_breakfast.setLayoutParams(params); // 设置GirdView布局参数,横向布局的关键
        gridView_breakfast.setColumnWidth(itemWidth); // 设置列表项宽
        gridView_breakfast.setHorizontalSpacing(5); // 设置列表项水平间距
        gridView_breakfast.setStretchMode(GridView.NO_STRETCH);
        gridView_breakfast.setNumColumns(size); // 设置列数量=列表集合数
        gridView_breakfast.setAdapter(new GridViewAdapter(getActivity(), cityList));
        //设置午餐的参数
        gridView_lunch = (GridView) view.findViewById(R.id.lunch_grid);
        gridView_lunch.setLayoutParams(params); // 设置GirdView布局参数,横向布局的关键
        gridView_lunch.setColumnWidth(itemWidth); // 设置列表项宽
        gridView_lunch.setHorizontalSpacing(5); // 设置列表项水平间距
        gridView_lunch.setStretchMode(GridView.NO_STRETCH);
        gridView_lunch.setNumColumns(size); // 设置列数量=列表集合数
        gridView_lunch.setAdapter(new GridViewAdapter(getActivity(), cityList));
        //设置晚餐的参数
        gridView_supper = (GridView) view.findViewById(R.id.supper_grid);
        gridView_supper.setLayoutParams(params); // 设置GirdView布局参数,横向布局的关键
        gridView_supper.setColumnWidth(itemWidth); // 设置列表项宽
        gridView_supper.setHorizontalSpacing(5); // 设置列表项水平间距
        gridView_supper.setStretchMode(GridView.NO_STRETCH);
        gridView_supper.setNumColumns(size); // 设置列数量=列表集合数
        gridView_supper.setAdapter(new GridViewAdapter(getActivity(), cityList));
    }
}
