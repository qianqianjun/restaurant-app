package com.example.qianqianjun.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private String user;
    private String password;
    private EditText edituser;
    private EditText editpassword;
    private Button button;
    private Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edituser=findViewById(R.id.user);
        editpassword=findViewById(R.id.password);
        button=findViewById(R.id.login);
        register=findViewById(R.id.register);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user=edituser.getText().toString();
                password=editpassword.getText().toString();
                if(user.equals("211".toString()))
                {
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    if(user.equals("".toString())||password.equals("".toString()))
                        Toast.makeText(LoginActivity.this,"请输入用户名和密码",Toast.LENGTH_SHORT).show();
                    else
                    {
                        Toast.makeText(LoginActivity.this, "账号或者密码错误", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this,"服务器过期，暂停注册功能！",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
