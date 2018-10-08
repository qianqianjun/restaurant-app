package com.example.qianqianjun.restaurant;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
public class PersonalActivity extends AppCompatActivity {

    private TextView tev1;
    private TextView tev2;
    private TextView tev3;
    private TextView tev4;
    private TextView tev5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        StringBuffer str;
        tev1=findViewById(R.id.person1);
        tev2=findViewById(R.id.person2);
        tev3=findViewById(R.id.person3);
        tev4=findViewById(R.id.person4);
        tev5=findViewById(R.id.person5);
        tev1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        tev2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        tev3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalActivity.this, InitlikeActivity.class);
                startActivity(intent);
            }
        });
        tev4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        tev5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PersonalActivity.this,MessageActivity.class);
                startActivity(intent);
            }
        });
    }
}
