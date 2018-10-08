package com.example.qianqianjun.restaurant.fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.qianqianjun.restaurant.R;

public class ContainerActivity extends AppCompatActivity {

    private AFragment afragment;
    private Button changebtn;
    private BFragment bfragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        changebtn = findViewById(R.id.btn_change);
        changebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bfragment==null)
                {
                    bfragment=new BFragment();
                }
                getFragmentManager().beginTransaction().replace(R.id.fl_container,bfragment).commitAllowingStateLoss();
            }
        });
        //实例化fragment
        afragment =new AFragment();
        //把Afragment添加到Activity的指定位置中
        getFragmentManager().beginTransaction().add(R.id.fl_container, afragment).commitAllowingStateLoss();
    }
}
