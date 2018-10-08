package com.example.qianqianjun.restaurant.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.qianqianjun.restaurant.R;

public class FindFragment extends Fragment {

    private WebView webview;
    //执行fragment创建时的动作
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_find,container,false);
        //设置fragment的content是webview;
        webview=view.findViewById(R.id.web_find);
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webview.loadUrl("https://www.buctmengyabei.club/finddish");
        return view;
    }
    //执行fragment创建之后的动作
    public void onViewCreated(View v, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(v,savedInstanceState);
    }
}
