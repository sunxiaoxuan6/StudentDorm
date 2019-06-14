package com.example.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class DormActivity extends AppCompatActivity  {
    private Button returns;
    private RadioButton stay;
    private RadioButton revise;
    private RadioButton manage;
    private RadioButton inquiry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dorm);
        init();

    }
    private void init() {
        //返回登录界面
        returns = findViewById(R.id.return1);
        returns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DormActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        stay=findViewById(R.id.stay1);
        revise=findViewById(R.id.revise1);
        manage=findViewById(R.id.manage1);
        inquiry=findViewById(R.id.inquiry1);
        //住宿信息
        stay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DormActivity.this, RoomActivity.class);
                startActivity(intent);
            }
        });
        //修改个人信息
        revise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DormActivity.this, SupervisorActivity.class);
                startActivity(intent);
            }
        });
        //宿舍管理
        manage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DormActivity.this, StayActivity.class);
                startActivity(intent);
            }
        });
        //个人信息查询
        inquiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DormActivity.this, SupervisorActivity.class);
                startActivity(intent);
            }
        });
    }
}