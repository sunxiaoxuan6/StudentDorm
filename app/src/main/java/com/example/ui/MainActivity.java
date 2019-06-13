package com.example.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.model.Student;

public class MainActivity extends AppCompatActivity {
    int i=0;
    private Button btn_entry;
    private Button btn_revise;
    private EditText et_username;
    private EditText et_password;
    private RadioButton rb_student;
    private RadioButton rb_houseparent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init() {

            btn_entry = findViewById(R.id.btn_entry);
            btn_revise = findViewById(R.id.btn_revise);
            et_username = findViewById(R.id.et_username);
            et_password = findViewById(R.id.et_password);
            rb_student = findViewById(R.id.rb_student);
            rb_houseparent = findViewById(R.id.rb_houseparent);
            //修改密码
            btn_revise.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, ReviseActivity.class);
                    startActivity(intent);
                }
            });
            //宿管界面登录
            rb_houseparent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   i=0;
                }
            });
            //学生界面登录
            rb_student.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    i=1;
                }
            });
            btn_entry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(i==0){
                        Intent intent = new Intent(MainActivity.this, DormActivity.class);
                            startActivity(intent);
                    }else{
                        Intent intent = new Intent(MainActivity.this, StudentActivity.class);
                        startActivity(intent);
                    }
                }
            });
        }
    }