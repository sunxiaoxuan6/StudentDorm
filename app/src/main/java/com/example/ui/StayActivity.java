package com.example.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StayActivity extends AppCompatActivity {
    private Button entering,allocation,exchange,examine,inquiry2,back,add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stay);
        init();
    }

    private void init() {
        entering=findViewById(R.id.entering);
        allocation=findViewById(R.id.allocation);
        exchange=findViewById(R.id.exchange);
        examine=findViewById(R.id.examine);
        inquiry2=findViewById(R.id.inquiry2);
        back=findViewById(R.id.back);
        add=findViewById(R.id.add);
//录入信息
        entering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StayActivity.this,EnteringActivity.class);
                startActivity(intent);
            }
        });
        //分配宿舍
        allocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StayActivity.this,AllocationsActivity.class);
                startActivity(intent);
            }
        });
        //调换宿舍
        exchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StayActivity.this,ExchangeActivity.class);
                startActivity(intent);
            }
        });
        //毕业退宿审核
        examine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StayActivity.this,ExamineActivity.class);
                startActivity(intent);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StayActivity.this,ADDRoomActivity.class);
                startActivity(intent);
            }
        });
        //查询
        inquiry2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StayActivity.this,QueryActivity.class);
                startActivity(intent);
            }
        });
        //返回上衣界面
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StayActivity.this,DormActivity.class);
                startActivity(intent);
            }
        });
    }
}
