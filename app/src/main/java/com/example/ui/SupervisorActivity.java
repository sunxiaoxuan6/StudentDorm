package com.example.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.adapter.StudentAdapter;
import com.example.adapter.SupervisorAdapter;
import com.example.model.Student;
import com.example.model.Supervisor;
import com.example.service.StudentService;
import com.example.service.StudentServiceImpl;
import com.example.service.SupervisorService;
import com.example.service.SupervisorServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class SupervisorActivity extends AppCompatActivity {
    private static final int ADD_REQUEST = 100;
    private static final int MODIFY_REQUEST = 102;

    private ListView supervisorList;
    private SupervisorAdapter supervisorAdapter;

    private List<Supervisor> supervisors;
    private SupervisorService supervisorService;
    private int selectedPos;
    private Supervisor selectedSupervisor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervisor);
        initData();

        supervisorList = findViewById(R.id.list_supervisor);
        supervisorAdapter = new SupervisorAdapter(supervisors);
        supervisorList.setAdapter(supervisorAdapter);

        supervisorList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                selectedPos = position;
                selectedSupervisor = (Supervisor) parent.getItemAtPosition(position);

                Intent intent = new Intent(SupervisorActivity.this, ADDSupervisorActivity.class);
                intent.putExtra("flag", "修改");

                Bundle bundle = new Bundle();
                bundle.putSerializable("supervisor", selectedSupervisor);
                intent.putExtras(bundle);

                startActivityForResult(intent, MODIFY_REQUEST);
                return false;
            }
        });
        supervisorList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                selectedSupervisor = (Supervisor) parent.getItemAtPosition(position);

                new AlertDialog.Builder(SupervisorActivity.this).setTitle("删除")
                        .setMessage("确认删除？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 从SQLite数据库的表中删除
                                supervisorService.delete(selectedSupervisor.getName());
                                // 移除students中的数据，并刷新adapter
                                supervisors.remove(position);
                                supervisorAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();
                return true;
            }
        });
    }

    private void initData() {
        supervisorService = new SupervisorServiceImpl(this);
        supervisors = supervisorService.getAllSupervisors();

        // 若数据库中没数据，则初始化数据列表，防止ListView报错
        if (supervisors == null) {
            supervisors = new ArrayList<>();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode!= Activity.RESULT_OK){
            return;
        }
        if(data!=null){
            Bundle bundle=data.getExtras();
            if(bundle==null){
                return;
            }

            selectedSupervisor= (Supervisor) bundle.get("supervisor");
            if(requestCode==MODIFY_REQUEST){
                supervisors.set(selectedPos,selectedSupervisor);
            }else if(requestCode==ADD_REQUEST){
                supervisors.add(selectedSupervisor);
            }
            //刷新ListView
            supervisorAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem item = menu.add(Menu.FIRST, 1, Menu.NONE, "添加");
        item.setIcon(android.R.drawable.ic_menu_add);
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case Menu.FIRST:
                // 跳转到ADDStudentActivity页面进行添加，flag用于存储是添加还是修改
                Intent intent = new Intent(SupervisorActivity.this, ADDSupervisorActivity.class);
                intent.putExtra("flag", "添加");
                startActivityForResult(intent, ADD_REQUEST);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
