package com.example.qianqianjun.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class InitlikeActivity extends AppCompatActivity {
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initlike);
        submit=findViewById(R.id.submitbtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(InitlikeActivity.this,"",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(InitlikeActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
