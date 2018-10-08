package com.example.qianqianjun.restaurant;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.qianqianjun.restaurant.fragment.FindFragment;
import com.example.qianqianjun.restaurant.fragment.LikeFragment;
import com.example.qianqianjun.restaurant.fragment.RankingFragment;
import com.example.qianqianjun.restaurant.fragment.TryNewFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //底部导航按钮
//    private Button likes;//猜你喜欢
//    private Button find;//探索发现；
//    private Button ranking;//排行榜
//    private Button trynew;//我来尝鲜
    //底部导航上面的内容fragment
    private Button loginBtn;
    private LikeFragment likeFragment;
    private RankingFragment rankingFragment;
    private FindFragment findFragment;
    private TryNewFragment tryNewFragment;
    private Integer current;
    private Fragment currentfragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //实例化一个fragment，添加到top_content,作为启动时候显示的默认fragment;
        likeFragment=new LikeFragment();
        getFragmentManager().beginTransaction().add(R.id.top_content,likeFragment,"like").commitAllowingStateLoss();
        currentfragment=getFragmentManager().findFragmentByTag("like");
        current=1;
        Toast.makeText(MainActivity.this, "网络错误，加载本地数据", Toast.LENGTH_SHORT).show();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        setButtons();
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @SuppressWarnings("StatementWithEmptyBody")

    @Override
    //定义右边的菜单栏目点击之后的响应操作
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_user) {
            Intent intent = new Intent(MainActivity.this, PersonalActivity.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.nav_setting) {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_replay) {
            Intent intent = new Intent(MainActivity.this, FeedbackActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_connect) {
            Intent intent = new Intent(MainActivity.this, ConnectusActivity.class);
            startActivity(intent);
            return true;
        }
        return true;
    }
    //设置底部导航栏的监听事件
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_like: {
                    if(current!=1) {
                        current=1;
                        if (likeFragment==null)
                        {
                            likeFragment=new LikeFragment();
                        }
                        Fragment fragmentlike=getFragmentManager().findFragmentByTag("like");
                        if(fragmentlike!=null)
                        {
                            getFragmentManager().beginTransaction().hide(currentfragment).add(R.id.top_content,fragmentlike).commitAllowingStateLoss();
                            currentfragment=fragmentlike;
                        }
                        else {
                            getFragmentManager().beginTransaction().replace(R.id.top_content, likeFragment, "like").commitAllowingStateLoss();
                        }
                    }
                    return true;
                }
                case R.id.navigation_trynew: {
                    if(current!=2) {
                        Toast.makeText(MainActivity.this, "网络错误", Toast.LENGTH_SHORT).show();
                        current=2;
                        if (tryNewFragment==null)
                        {
                            tryNewFragment=new TryNewFragment();
                        }
                        Fragment fragmenttrynew=getFragmentManager().findFragmentByTag("trynew");
                        if(fragmenttrynew!=null)
                        {
                            getFragmentManager().beginTransaction().hide(currentfragment).add(R.id.top_content,fragmenttrynew).commitAllowingStateLoss();
                            currentfragment=fragmenttrynew;
                        }
                        else
                        {
                            getFragmentManager().beginTransaction().replace(R.id.top_content,tryNewFragment,"trynew").commitAllowingStateLoss();
                        }
                    }
                    return true;
                }
                case R.id.navigation_rank: {
                    if(current!=3) {
                        Toast.makeText(MainActivity.this, "网络错误", Toast.LENGTH_SHORT).show();
                        current=3;
                        if (rankingFragment==null)
                        {
                            rankingFragment=new RankingFragment();
                        }
                        Fragment fragmentrank=getFragmentManager().findFragmentByTag("rank");
                        if(fragmentrank!=null)
                        {
                            getFragmentManager().beginTransaction().hide(currentfragment).add(R.id.top_content,fragmentrank).commitAllowingStateLoss();
                            currentfragment=fragmentrank;
                        }
                        else {
                            getFragmentManager().beginTransaction().replace(R.id.top_content, rankingFragment, "rank").commitAllowingStateLoss();
                        }
                    }
                    return true;
                }
                case R.id.navigation_find: {
                    if(current!=4) {
                        Toast.makeText(MainActivity.this, "网络错误", Toast.LENGTH_SHORT).show();
                        current = 4;
                        if (findFragment==null)
                        {
                            findFragment=new FindFragment();
                        }
                        Fragment fragmentfind=getFragmentManager().findFragmentByTag("find");
                        if(fragmentfind!=null)
                        {
                            getFragmentManager().beginTransaction().hide(currentfragment).add(R.id.top_content,fragmentfind).commitAllowingStateLoss();
                            currentfragment=fragmentfind;
                        }
                        else {
                            getFragmentManager().beginTransaction().replace(R.id.top_content, findFragment, "find").commitAllowingStateLoss();
                        }
                    }
                    return true;
                }
            }
            return false;
        }
    };

    //为所有的button设置点击监听
    public void setButtons()
    {
        loginBtn=findViewById(R.id.mainlogin);
        if(loginBtn==null)
            System.out.println("这是一个空指针！");
        else {
            loginBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
//    public void setButtons() {
//        trynew=findViewById(R.id.trynew);
//        likes = findViewById(R.id.likes);
//        find = findViewById(R.id.finds);
//        ranking = findViewById(R.id.rank);
//        trynew.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (tryNewFragment==null)
//                {
//                    tryNewFragment=new TryNewFragment();
//                }
//                Fragment fragmenttrynew=getFragmentManager().findFragmentByTag("trynew");
//                if(fragmenttrynew!=null)
//                {
//                    getFragmentManager().beginTransaction().hide(currentfragment).add(R.id.top_content,fragmenttrynew).commitAllowingStateLoss();
//                    currentfragment=fragmenttrynew;
//                }
//                else
//                {
//                    getFragmentManager().beginTransaction().replace(R.id.top_content,tryNewFragment,"trynew").commitAllowingStateLoss();
//                }
//
//            }
//        });
//        likes.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (likeFragment==null)
//                {
//                    likeFragment=new LikeFragment();
//                }
//                Fragment fragmentlike=getFragmentManager().findFragmentByTag("like");
//                if(fragmentlike!=null)
//                {
//                    getFragmentManager().beginTransaction().hide(currentfragment).add(R.id.top_content,fragmentlike).commitAllowingStateLoss();
//                    currentfragment=fragmentlike;
//                }
//                else {
//                    getFragmentManager().beginTransaction().replace(R.id.top_content, likeFragment, "like").commitAllowingStateLoss();
//                }
//            }
//        });
//        find.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (findFragment==null)
//                {
//                    findFragment=new FindFragment();
//                }
//                Fragment fragmentfind=getFragmentManager().findFragmentByTag("find");
//                if(fragmentfind!=null)
//                {
//                    getFragmentManager().beginTransaction().hide(currentfragment).add(R.id.top_content,fragmentfind).commitAllowingStateLoss();
//                    currentfragment=fragmentfind;
//                }
//                else {
//                    getFragmentManager().beginTransaction().replace(R.id.top_content, findFragment, "find").commitAllowingStateLoss();
//                }
//            }
//        });
//        ranking.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (rankingFragment==null)
//                {
//                    rankingFragment=new RankingFragment();
//                }
//                Fragment fragmentrank=getFragmentManager().findFragmentByTag("rank");
//                if(fragmentrank!=null)
//                {
//                    getFragmentManager().beginTransaction().hide(currentfragment).add(R.id.top_content,fragmentrank).commitAllowingStateLoss();
//                    currentfragment=fragmentrank;
//                }
//                else {
//                    getFragmentManager().beginTransaction().replace(R.id.top_content, rankingFragment, "rank").commitAllowingStateLoss();
//                }
//            }
//        });
//    }
}
