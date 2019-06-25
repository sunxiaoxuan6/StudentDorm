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
import android.widget.ListView;

import com.example.adapter.EnteringAdapter;
import com.example.model.Entering;
import com.example.service.EnteringService;
import com.example.service.EnteringServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class EnteringActivity extends AppCompatActivity {
    private static final int ADD_REQUEST = 100;
    private static final int MODIFY_REQUEST = 101;

    private ListView enteringList;
    private EnteringAdapter enteringAdapter;

    private List<Entering> enterings;
    private EnteringService enteringService;
    private int selectedPos;
    private Entering selectedEntering;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entering);

        initData();

        enteringList = findViewById(R.id.list_entering);
        enteringAdapter = new EnteringAdapter(enterings);
        enteringList.setAdapter(enteringAdapter);

        enteringList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedPos = position;
                selectedEntering = (Entering) parent.getItemAtPosition(position);

                Intent intent = new Intent(EnteringActivity.this, ADDEnteringActivity.class);
                intent.putExtra("flag", "修改");

                Bundle bundle = new Bundle();
                bundle.putSerializable("entering", selectedEntering);
                intent.putExtras(bundle);

                startActivityForResult(intent, MODIFY_REQUEST);
            }
        });
        enteringList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent,
                                           View view,
                                           final int position,
                                           long id) {
                //弹出警告对话框，确认是否删除
                selectedEntering = (Entering) parent.getItemAtPosition(position);

                new AlertDialog.Builder(EnteringActivity.this).setTitle("删除")
                        .setMessage("确认删除？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 从SQLite数据库的表中删除
                                enteringService.delete(selectedEntering.getName());
                                // 移除rooms中的数据，并刷新adapter
                                enterings.remove(position);
                                enteringAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();
                return true;
            }
        });
    }

    private void initData() {
        // 从SQLite数据库获取宿舍列表
        enteringService = new EnteringServiceImpl(this);
        enterings = enteringService.getAllEntering();

        // 若数据库中没数据，则初始化数据列表，防止ListView报错
        if (enterings == null) {
            enterings = new ArrayList<>();
        }
    }

    // 接收ADDRoomActivity的返回的添加或修改后的room对象，更新rooms，刷新列表
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
            //更新rooms列表
            selectedEntering= (Entering) bundle.get("entering");
            if(requestCode==MODIFY_REQUEST){
                enterings.set(selectedPos,selectedEntering);
            }else if(requestCode==ADD_REQUEST){
                enterings.add(selectedEntering);
            }
            //刷新ListView
            enteringAdapter.notifyDataSetChanged();
        }
    }
    // 创建添加功能的选项菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 动态加载菜单
        MenuItem item = menu.add(Menu.FIRST, 1, Menu.NONE, "添加");
        item.setIcon(android.R.drawable.ic_menu_add);
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return true;
    }

    // 处理选项菜单的添加功能
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case Menu.FIRST:
                // 跳转到RoomActivity页面进行添加，flag用于存储是添加还是修改
                Intent intent = new Intent(EnteringActivity.this, ADDEnteringActivity.class);
                intent.putExtra("flag", "添加");
                startActivityForResult(intent, ADD_REQUEST);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
