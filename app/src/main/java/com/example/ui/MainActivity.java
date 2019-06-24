package com.example.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.model.Register;
import com.example.service.RegisterService;
import com.example.service.RegisterServiceImpl;

public class MainActivity extends AppCompatActivity {
    private Button btn_entry;
    private Button btn_revise;
    private Button btn_register;

    private EditText et_username;
    private EditText et_password;
    private RadioButton rb_student;
    private RadioButton rb_houseparent;

    private Register register;
    private RegisterServiceImpl registerService;
    private String flag;

    private RegisterService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_entry = findViewById(R.id.btn_entry);

        registerService = new RegisterServiceImpl(this);

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
                Toast.makeText(MainActivity.this,"请修改密码",Toast.LENGTH_SHORT).show();
            }
        });
        //注册
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"请注册用户",Toast.LENGTH_SHORT).show();
            }
        });
        //登录
        btn_entry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=et_username.getText().toString();
                String password=et_password.getText().toString();

                if(username.isEmpty()||password.isEmpty()){
                    Toast.makeText(MainActivity.this,"用户名或密码不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }

                Register register = new Register();
                register.setName(username);
                register.setPassword(password);

                boolean tem=registerService.login(register);

                if(tem)
                {
                if (rb_houseparent.isChecked()) {
                    //宿管界面
                    Intent intent = new Intent(MainActivity.this, DormActivity.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this,"已登录宿管界面",Toast.LENGTH_SHORT).show();
                } else if (rb_student.isChecked()) {
                    //学生界面
                    Intent intent = new Intent(MainActivity.this, StudentActivity.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this,"已登录学生界面",Toast.LENGTH_SHORT).show();
                }
                }
                else {
                    Toast.makeText(MainActivity.this,"用户不存在",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
