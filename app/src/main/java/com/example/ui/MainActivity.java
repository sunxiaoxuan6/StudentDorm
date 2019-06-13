package com.example.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
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

        btn_entry = findViewById(R.id.btn_entry);
        btn_revise = findViewById(R.id.btn_revise);
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        rb_student = findViewById(R.id.rb_student);
        rb_houseparent = findViewById(R.id.rb_houseparent);

        btn_entry.setOnClickListener(this);
        btn_revise.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_entry:
                entry();
                break;
            case R.id.btn_revise:
                revise();
                break;
        }
    }
    private void revise() {
        btn_revise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ReviseActivity.class);
                startActivity(intent);
            }
        });

    }
    private void entry() {
       int flagStudent=rb_student.isChecked()?0:1;
       int flagDorm=rb_houseparent.isChecked()?0:1;
       if(flagStudent==0){
           rb_student.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(MainActivity.this,StudentActivity.class);
                   startActivity(intent);
               }
           });
       } else {
           rb_houseparent.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(MainActivity.this,DormActivity.class);
                   startActivity(intent);
               }
           });
       }
    }
}