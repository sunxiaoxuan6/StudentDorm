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

import com.example.model.Room;
import com.example.service.RoomService;
import com.example.service.RoomServiceImpl;

import java.util.Arrays;
import java.util.List;

public class ADDRoomActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnSave, btnCancel;
    private EditText etRoomName, etRealNumber;
    private EditText etExpectNumber, etCost;

    private Room room;
    private RoomService roomService;
    private String flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addroom);

        roomService = new RoomServiceImpl(this);

        initView();
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        flag = intent.getStringExtra("flag");

        Bundle bundle = intent.getExtras();
        if(bundle != null) {
            room = (Room) bundle.getSerializable("room");
            if(room != null) {
                etRoomName.setText(room.getRoomName());
                etRoomName.setEnabled(false);
                etRealNumber.setText(String.valueOf(room.getRealNumber()));
                etExpectNumber.setText(String.valueOf(room.getExpectNumber()));
                etCost.setText(String.valueOf(room.getCost()));
               }
        }
    }

    private void initView() {
        etRoomName = findViewById(R.id.et_room_name);
        etExpectNumber = findViewById(R.id.et_expect_number);
        etRealNumber = findViewById(R.id.et_real_number);
        etCost = findViewById(R.id.sp_room_cost);

        btnSave = findViewById(R.id.btn_save);
        btnCancel = findViewById(R.id.btn_cancel);
        btnSave.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save:
                updateRoom();
                break;
            case R.id.btn_cancel:
                finish();
        }
    }

    private void updateRoom() {
        if(room == null) {
            room = new Room();
        }
        room.setRoomName(etRoomName.getText().toString());
        room.setRealNumber(Integer.valueOf(etRealNumber.getText().toString()));
        room.setExpectNumber(Integer.parseInt(etExpectNumber.getText().toString()));
        room.setCost(Integer.parseInt(etCost.getText().toString()));

        if("修改".equals(flag)) {
            roomService.modifyRealNumber(room);
        } else if("添加".equals(flag)) {
            roomService.insert(room);
        }

        // 将修改的数据返回MainActivity
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("room", room);
        intent.putExtras(bundle);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
