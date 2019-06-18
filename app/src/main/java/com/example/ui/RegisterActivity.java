package com.example.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                register.setStudentId(Integer.valueOf(id.getText().toString()));
                register.setPassword(Integer.parseInt(password.getText().toString()));
                register.setSecondPassword(Integer.parseInt(secondPassword.getText().toString()));
                if(password==secondPassword) {
                    if ("修改".equals(flag)) {
                        registerService.modifyRealNumber(register);
                    } else if ("添加".equals(flag)) {
                        registerService.insert(register);
                    }
                }

                // 将修改的数据返回MainActivity
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("register", register);
                intent.putExtras(bundle);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
