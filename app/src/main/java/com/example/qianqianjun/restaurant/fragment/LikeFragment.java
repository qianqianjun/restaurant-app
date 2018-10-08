package com.example.qianqianjun.restaurant.fragment;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.example.qianqianjun.restaurant.R;
import com.example.qianqianjun.restaurant.listview.MyListViewAdaper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class LikeFragment extends Fragment {

    //private WebView webview;
    //执行fragment创建时的动作
    private ListView listView;
    private int ic_launcher_background;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_like,container,false);
        //设置fragment的content是webview;
        listView=view.findViewById(R.id.dishlist);
        List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
        Integer [] arr=new Integer[20];
        arr[0]=R.mipmap.ic_dish0;
        arr[1]=R.mipmap.ic_dish1;
        arr[2]=R.mipmap.ic_dish2;
        arr[3]=R.mipmap.ic_dish3;
        arr[4]=R.mipmap.ic_dish4;
        arr[5]=R.mipmap.ic_dish5;
        arr[6]=R.mipmap.ic_dish6;
        arr[7]=R.mipmap.ic_dish7;
        arr[8]=R.mipmap.ic_dish8;
        arr[9]=R.mipmap.ic_dish9;
        for (int i = 0; i < 10; i++) {
            Map<String, Object> map=new HashMap<String, Object>();
            ic_launcher_background = R.drawable.ic_launcher_background;
            map.put("image", arr[i]);
            map.put("dishname", "菜肴名称"+i);
            map.put("disaddress", "紫竹三食堂" + i+"号");
            map.put("dishprice","￥ "+i);
            list.add(map);
        }
        listView.setAdapter(new MyListViewAdaper(getActivity(), list));
        return view;
    }
    //执行fragment创建之后的动作
    public void onViewCreated(View v, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(v,savedInstanceState);
    }
}
