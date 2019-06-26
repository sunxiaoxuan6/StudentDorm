package com.example.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.model.Register;
import com.example.service.RegisterService;
import com.example.service.RegisterServiceImpl;

public class RegisterActivity extends AppCompatActivity {
    private EditText name,id,password,secondPassword;
    private Button registerSave;


    private Register register;
    private RegisterService registerService;
    private String flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();

        registerService = new RegisterServiceImpl(this);

        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        flag = intent.getStringExtra("flag");

        Bundle bundle = intent.getExtras();
        if(bundle != null) {
            register = (Register) bundle.getSerializable("register");
            if(register != null) {
                name.setText(register.getName());
                name.setEnabled(false);
                id.setText(String.valueOf(register.getStudentId()));
                password.setText(String.valueOf(register.getPassword()));
                secondPassword.setText(String.valueOf(register.getSecondPassword()));
            }
        }
    }

    private void init() {
        name=findViewById(R.id.name);
        id=findViewById(R.id.id);
        password=findViewById(R.id.password);
        secondPassword=findViewById(R.id.second_password);

        registerSave=findViewById(R.id.register_save);
        registerSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(register == null) {
                    register = new Register();
                }
                register.setName(name.getText().toString());
                register.setStudentId(id.getText().toString());
                register.setPassword(password.getText().toString());
                register.setSecondPassword(secondPassword.getText().toString());

                if(register.getPassword().equals(register.getSecondPassword())) {

                    registerService.insert(register);

                    Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(RegisterActivity.this,"两次密码不一致",Toast.LENGTH_SHORT).show();
                }

                Register register = new Register();
                register.setName(name.getText().toString());

                boolean repeat=registerService.login(register);

                if(!repeat){
                    Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(RegisterActivity.this,"该用户已存在,请重新注册",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
