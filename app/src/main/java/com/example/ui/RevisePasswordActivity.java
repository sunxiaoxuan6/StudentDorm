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

public class RevisePasswordActivity extends AppCompatActivity {
    private Register register;
    private RegisterService registerService;

    private Button exit;

    private EditText etUserName;
    private EditText etPassWord;
    private EditText etNewPassword;
    private EditText etConfirmPassword;

    private String flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revise_password);

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
                etNewPassword.setText(String.valueOf(register.getPassword()));
                etConfirmPassword.setText(String.valueOf(register.getSecondPassword()));
            }
        }
    }

    private void init() {
        etUserName=findViewById(R.id.et_username);
        etPassWord=findViewById(R.id.et_old_password);
        etNewPassword=findViewById(R.id.et_new_password);
        etConfirmPassword=findViewById(R.id.et_confirm_password);

        exit = findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    register.setPassword(etNewPassword.getText().toString());
                    register.setSecondPassword(etConfirmPassword.getText().toString());
                    if (etUserName.equals(flag)) {
                    if (register.getPassword().equals(register.getSecondPassword())&&etPassWord!=etNewPassword) {
                        registerService.modifyRealNumber(register);
                        Intent intent = new Intent(RevisePasswordActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(RevisePasswordActivity.this, "两次密码不一致", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
