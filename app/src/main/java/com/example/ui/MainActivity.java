package com.example.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    private Button btn_entry;
    private Button btn_revise;
    private Button btn_register;
    private EditText et_username;
    private EditText et_password;
    private RadioButton rb_student;
    private RadioButton rb_houseparent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_entry = findViewById(R.id.btn_entry);

        init();
    }

    private void init() {

        btn_entry = findViewById(R.id.btn_entry);
        btn_revise = findViewById(R.id.btn_revise);
        btn_register = findViewById(R.id.btn_register);
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        rb_student = findViewById(R.id.rb_student);
        rb_houseparent = findViewById(R.id.rb_houseparent);

        //修改密码
        btn_revise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RevisePasswordActivity.class);
                startActivity(intent);
            }
        });
        btn_entry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rb_houseparent.isChecked()) {
                    //宿管界面
                    Intent intent = new Intent(MainActivity.this, DormActivity.class);
                    startActivity(intent);
                } else if (rb_student.isChecked()) {
                    //学生界面
                    Intent intent = new Intent(MainActivity.this, StudentActivity.class);
                    startActivity(intent);
                }
            }
    });
    }
}