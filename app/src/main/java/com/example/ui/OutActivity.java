package com.example.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.model.Out;
import com.example.service.OutService;
import com.example.service.OutServiceImpl;

public class OutActivity extends AppCompatActivity {
    private Button return2;
    private Button submit;
    private EditText etOutName,etTime,etBackTime;
    private RadioGroup Out;
    private RadioButton Problem,Graduate;
    private Out out;
    private OutService outService;
    private String flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out);
        outService = new OutServiceImpl(this);
        init();
        initView();
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        flag = intent.getStringExtra("flag");

        Bundle bundle = intent.getExtras();
        if(bundle != null) {
            out = (Out) bundle.getSerializable("out");
            if(out != null) {
                etOutName.setText(out.getOutName());
                etOutName.setEnabled(false);
                etTime.setText(String.valueOf(out.getTime()));
                etBackTime.setText(String.valueOf(out.getBackTime()));
            }
        }
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.submit:
                updateOut();
                break;
            case R.id.return2:
                finish();
        }
    }

    private void updateOut() {
        if (out == null){
            out = new Out();
        }
        out.setOutName(etOutName.getText().toString());
        out.setReason(Problem.getText().toString());
        out.setReason(Graduate.getText().toString());
        out.setTime(etTime.getText().toString());
        out.setBackTime(etBackTime.getText().toString());

        if ("修改".equals(flag)){
            outService.modifyRealNumber(out);
        }else if ("添加".equals(flag)){
            outService.insert(out);
        }

        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("out",out);
        intent.putExtras(bundle);
        setResult(Activity.RESULT_OK,intent);
        finish();
    }

    private void initView() {
        etOutName = findViewById(R.id.et_out_name);
        etTime = findViewById(R.id.et_time);
        etBackTime = findViewById(R.id.et_back_time);
        return2 = findViewById(R.id.return2);
        submit = findViewById(R.id.submit);
        Out = findViewById(R.id.out);
        Problem = findViewById(R.id.problem);
        Graduate = findViewById(R.id.graduate);


    }

    private void init() {
        return2=findViewById(R.id.return2);
        return2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OutActivity.this,StudentActivity.class);
                startActivity(intent);
            }
        });
        submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OutActivity.this, StudentActivity.class);
                startActivity(intent);
            }
        });
    }
}