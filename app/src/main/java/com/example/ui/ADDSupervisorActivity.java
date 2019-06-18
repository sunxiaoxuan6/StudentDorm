package com.example.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.model.Supervisor;
import com.example.service.SupervisorService;
import com.example.service.SupervisorServiceImpl;

import java.util.Arrays;
import java.util.List;

public class ADDSupervisorActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_save100, btn_cancel00;
    private EditText et_name, et_job_number;
    private EditText et_build_number, et_job_hour;
    private EditText et_contact;
    private Spinner spSupervisorSex;

    private List<String> sexes;
    private Supervisor supervisor;
    private SupervisorService supervisorService;
    private String flag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addsupervisor);
        supervisorService=new SupervisorServiceImpl(this);

        initView();
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        flag = intent.getStringExtra("flag");

        Bundle bundle = intent.getExtras();
        if(bundle != null) {
            supervisor = (Supervisor) bundle.getSerializable("supervisor");
            if(supervisor != null) {
                et_name.setText(supervisor.getName());
                et_name.setEnabled(false);
                spSupervisorSex.setSelection(sexes.indexOf(supervisor.getSex()), true);
                et_job_number.setText(String.valueOf(supervisor.getJob_number()));
                et_build_number.setText(String.valueOf(supervisor.getBuild_number()));
                et_job_hour.setText(String.valueOf(supervisor.getJob_hour()));
                et_contact.setText(String.valueOf(supervisor.getContact()));
            }
        }

    }

    private void initView() {
        et_name = findViewById(R.id.et_name);
        spSupervisorSex = findViewById(R.id.sp_supervisor_sex);
        et_job_number = findViewById(R.id.et_job_number);
        et_build_number = findViewById(R.id.et_build_number);
        et_job_hour = findViewById(R.id.et_job_hour);
        et_contact = findViewById(R.id.et_contact);
        btn_save100 = findViewById(R.id.btn_save100);
        btn_cancel00 = findViewById(R.id.btn_cancel00);
        btn_save100.setOnClickListener(this);
        btn_cancel00.setOnClickListener(this);

        sexes = Arrays.asList(getResources().getStringArray(R.array.sex));
        spSupervisorSex.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                sexes));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save100:
                updateSupervisor();
                break;
            case R.id.btn_cancel00:
                finish();
        }
    }

    private void updateSupervisor() {
        if(supervisor == null) {
            supervisor = new Supervisor();
        }
        //获取将界面上修改的数据写入对象
        supervisor.setName(et_name.getText().toString());
        supervisor.setSex((String) spSupervisorSex.getSelectedItem());
        supervisor.setJob_number(Integer.valueOf(et_job_number.getText().toString()));
        supervisor.setBuild_number(Integer.parseInt(et_build_number.getText().toString()));
        supervisor.setJob_hour(Integer.parseInt(et_job_hour.getText().toString()));
        supervisor.setContact(et_contact.getText().toString());
        //根据flag进行修改或添加到数据库表
        if("修改".equals(flag)) {
            supervisorService.modifyRealNumber(supervisor);
        } else if("添加".equals(flag)) {
            supervisorService.insert(supervisor);
        }

        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("supervisor", supervisor);
        intent.putExtras(bundle);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
