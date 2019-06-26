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
    Register register=new Register();
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
    }

    private void init() {
        etUserName=findViewById(R.id.et_username);
        etPassWord=findViewById(R.id.et_old_password);
        etNewPassword=findViewById(R.id.et_new_password);
        etConfirmPassword=findViewById(R.id.et_confirm_password);

        exit = findViewById(R.id.exit);

        registerService = new RegisterServiceImpl(this);

        Intent intent=getIntent();
        flag = intent.getStringExtra("flag");

        Bundle bundle = intent.getExtras();
        if(bundle!=null){
            register.setName(bundle.getString("register"));
        }

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=etUserName.getText().toString();
                String password=etPassWord.getText().toString();
                String newPassword=etNewPassword.getText().toString();
                String confirmPassword=etConfirmPassword.getText().toString();
                    if (confirmPassword.equals(newPassword)) {

                        register.setPassword(password);

                        boolean result=registerService.update(register,newPassword);
                        if(result){
                            Toast.makeText(RevisePasswordActivity.this,"密码修改成功",Toast.LENGTH_LONG).show();
                        }
                }else {
                        Toast.makeText(RevisePasswordActivity.this,"两次密码不一致",Toast.LENGTH_LONG).show();
                    }
            }
        });
    }
}
