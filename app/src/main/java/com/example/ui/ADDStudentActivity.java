package com.example.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.model.Student;
import com.example.service.StudentService;
import com.example.service.StudentServiceImpl;

import java.util.Arrays;
import java.util.List;

public class ADDStudentActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnSave2, btnCancel2;
    private EditText etName, etId;
    private EditText etDormId, etFaculty;
    private EditText etClass,etEducational;
    private EditText etStartTime,etContact;
    private Spinner spStudentSex;


    private List<String> sexes;
    private Student student;
    private StudentService studentService;
    private String flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addstudent);

        studentService=new StudentServiceImpl(this);

        initView();
        initData();
    }

    private void initView() {
        etName = findViewById(R.id.et_name);
        spStudentSex = findViewById(R.id.sp_sex);
        etId = findViewById(R.id.et_id);
        etDormId = findViewById(R.id.et_dorm_id);
        etFaculty = findViewById(R.id.et_faculty);
        etClass = findViewById(R.id.et_class);
        etEducational = findViewById(R.id.et_educational);
        etStartTime = findViewById(R.id.et_start_time);
        etContact = findViewById(R.id.et_contact);

        btnSave2 = findViewById(R.id.btn_save2);
        btnCancel2 = findViewById(R.id.btn_cancel2);
        btnSave2.setOnClickListener(this);
        btnCancel2.setOnClickListener(this);

        sexes = Arrays.asList(getResources().getStringArray(R.array.sex));
        spStudentSex.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                sexes));
    }

    private void initData() {
        Intent intent = getIntent();
        flag = intent.getStringExtra("flag");

        Bundle bundle = intent.getExtras();
        if(bundle != null) {
            student = (Student) bundle.getSerializable("student");
            if(student != null) {
                etName.setText(student.getName());
                etName.setEnabled(false);
                etId.setText(String.valueOf(student.getStudent_id()));
                etDormId.setText(String.valueOf(student.getDorm_id()));
                etFaculty.setText(String.valueOf(student.getFaculty()));
                etClass.setText(String.valueOf(student.getClass1()));
                etEducational.setText(String.valueOf(student.getEducational()));
                etStartTime.setText(String.valueOf(student.getStart_time()));
                etContact.setText(String.valueOf(student.getContact()));
                spStudentSex.setSelection(sexes.indexOf(student.getSex()), true);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save2:
                updateStudent();
                break;
            case R.id.btn_cancel2:
                finish();
        }
    }

    private void updateStudent() {
        if(student == null) {
        student = new Student();
    }
    //获取将界面上修改的数据写入对象
        student.setName(etName.getText().toString());
        student.setStudent_id(Integer.valueOf(etId.getText().toString()));
        student.setDorm_id(Integer.parseInt(etDormId.getText().toString()));
        student.setFaculty(etFaculty.getText().toString());
        student.setSex((String) spStudentSex.getSelectedItem());
        student.setClass1(etClass.getText().toString());
        student.setEducational(Integer.valueOf(etEducational.getText().toString()));
        student.setStart_time(etStartTime.getText().toString());
        student.setContact(etContact.getText().toString());
        //根据flag进行修改或添加到数据库表
        if("修改".equals(flag)) {
            studentService.modifyRealNumber(student);
        } else if("添加".equals(flag)) {
            studentService.insert(student);
        }

        // 将修改的数据返回MessageActivity
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("student", student);
        intent.putExtras(bundle);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
