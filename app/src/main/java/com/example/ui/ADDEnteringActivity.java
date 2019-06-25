package com.example.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.model.Entering;
import com.example.service.EnteringService;
import com.example.service.EnteringServiceImpl;

public class ADDEnteringActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_save;
    private EditText etSuSheHao, etRenShu;
    private EditText etPeopleName, etOccupied;


    private Entering entering;
    private EnteringService enteringService;
    private String flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addentering);

        enteringService = new EnteringServiceImpl(this);

        initView();
        initData();
    }

    private void initData() {
        Intent intent=new Intent();
        flag = intent.getStringExtra("flag");

        Bundle bundle = intent.getExtras();
        if(bundle != null) {
            entering = (Entering) bundle.getSerializable("room");
            if(entering != null) {
                etSuSheHao.setText(entering.getName());
                etSuSheHao.setEnabled(false);
                etRenShu.setText(String.valueOf(entering.getNumber()));
                etPeopleName.setText(String.valueOf(entering.getStudentName()));
                etOccupied.setText(String.valueOf(entering.getOccupied()));
            }
        }
    }

    private void initView() {
        etSuSheHao = findViewById(R.id.et_sushehao);
        etRenShu = findViewById(R.id.et_renshu);
        etPeopleName = findViewById(R.id.et_peoplename);
        etOccupied = findViewById(R.id.et_occupied);

        btn_save = findViewById(R.id.btn_saves);
        btn_save.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(entering == null) {
            entering = new Entering();
        }
        entering.setName(etSuSheHao.getText().toString());
        entering.setNumber(Integer.valueOf(etRenShu.getText().toString()));
        entering.setStudentName(etPeopleName.getText().toString());
        entering.setOccupied(Integer.parseInt(etOccupied.getText().toString()));

        if("修改".equals(flag)) {
            enteringService.modifyRealNumber(entering);
        } else if("添加".equals(flag)) {
            enteringService.insert(entering);
        }

        // 将修改的数据返回MainActivity
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("entering", entering);
        intent.putExtras(bundle);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
