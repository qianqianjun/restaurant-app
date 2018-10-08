package com.example.qianqianjun.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity {

    private Button image_btn;
    private Button submit;
    private String user;
    private EditText editUser;
    private String phone;
    private EditText editPhone;
    private EditText editDescription;
    private String description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        image_btn=findViewById(R.id.imagebutton);
        submit=findViewById(R.id.submitbtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                user=editUser.getText().toString();
//                phone=editPhone.getText().toString();
//                description=editDescription.getText().toString();
                Toast.makeText(FeedbackActivity.this,"您还没有登录！",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(FeedbackActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        image_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(FeedbackActivity.this,"该功能暂未开发",Toast.LENGTH_LONG).show();
            }
        });
    }
}
