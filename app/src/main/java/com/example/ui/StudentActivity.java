package com.example.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class StudentActivity extends AppCompatActivity {
    private Button returns;
    private RadioButton manager;
    private RadioButton enter;
    private RadioButton apply;
    private RadioButton revise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        init();
    }

    private void init() {

        returns=findViewById(R.id.returns);
        returns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StudentActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        enter=findViewById(R.id.enter);
        apply=findViewById(R.id.apply);
        revise=findViewById(R.id.revise);
        manager=findViewById(R.id.manager);
        manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StudentActivity.this,MessageActivity.class);
                startActivity(intent);
            }
        });
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StudentActivity.this,MessageActivity.class);
                startActivity(intent);
            }
        });
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StudentActivity.this,OutActivity.class);
                startActivity(intent);
            }
        });
        revise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(StudentActivity.this,MessageActivity.class);
                startActivity(intent);
            }
        });
    }

}
