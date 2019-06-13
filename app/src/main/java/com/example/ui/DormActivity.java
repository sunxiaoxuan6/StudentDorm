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
        returns=findViewById(R.id.returns);
        returns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DormActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        stay=findViewById(R.id.stay1);
        revise=findViewById(R.id.revise1);
        manage=findViewById(R.id.manage1);
        inquiry=findViewById(R.id.inquiry1);
        stay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DormActivity.this,StayActivity.class);
                startActivity(intent);
            }
        });
        revise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DormActivity.this,SupervisorActivity.class);
                startActivity(intent);
            }
        });
        manage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DormActivity.this,RoomActivity.class);
                startActivity(intent);
            }
        });
        inquiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DormActivity.this,SupervisorActivity.class);
                startActivity(intent);
            }
        });
    }
}
