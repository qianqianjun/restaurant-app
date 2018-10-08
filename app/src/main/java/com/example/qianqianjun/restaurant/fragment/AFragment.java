package com.example.qianqianjun.restaurant.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.qianqianjun.restaurant.R;

public class AFragment extends Fragment {
    private TextView tv1;
    //执行fragment创建时的动作
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_a,container,false);
        return view;
    }
    //执行fragment创建之后的动作
    public void onViewCreated(View v, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(v,savedInstanceState);
        tv1= v.findViewById(R.id.tv_title);

    }
}
