package com.example.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class StudentActivity extends AppCompatActivity{
    private Button returns;
    private RadioButton manager;
    private RadioButton enter;
    private RadioButton revise;
    private RadioButton apply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);


        manager = findViewById(R.id.manager);
        enter = findViewById(R.id.enter);
        revise = findViewById(R.id.revise);
        apply = findViewById(R.id.apply);
        returns = findViewById(R.id.returns);

        returns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        //基本信息查询
        manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentActivity.this, MessageActivity.class);
                startActivity(intent);
            }
        });
        //录入信息
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentActivity.this, MessageActivity.class);
                startActivity(intent);
            }
        });
        //退宿申请
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentActivity.this, OutActivity.class);
                startActivity(intent);
            }
        });
        //修改信息
        revise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentActivity.this, MessageActivity.class);
                startActivity(intent);
            }
        });
    }
}
