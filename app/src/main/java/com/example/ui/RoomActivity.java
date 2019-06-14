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

import com.example.adapter.RoomAdapter;
import com.example.model.Room;
import com.example.service.RoomService;
import com.example.service.RoomServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class RoomActivity extends AppCompatActivity {
    private static final int ADD_REQUEST = 100;
    private static final int MODIFY_REQUEST = 101;
    private ListView roomList;
    private RoomAdapter roomAdapter;

    private List<Room> rooms;
    private RoomService roomService;
    private int selectedPos;
    private Room selectedRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        roomList = findViewById(R.id.list_room);
        roomAdapter = new RoomAdapter(rooms);
        roomList.setAdapter(roomAdapter);

        initData();

        roomList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedPos = position;
                selectedRoom = (Room) parent.getItemAtPosition(position);

                Intent intent = new Intent(RoomActivity.this, ADDRoomActivity.class);
                intent.putExtra("flag", "修改");

                Bundle bundle = new Bundle();
                bundle.putSerializable("room", selectedRoom);
                intent.putExtras(bundle);

                startActivityForResult(intent, MODIFY_REQUEST);
            }
        });
        roomList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent,
                                           View view,
                                           final int position,
                                           long id) {
                //弹出警告对话框，确认是否删除
                selectedRoom = (Room) parent.getItemAtPosition(position);

                new AlertDialog.Builder(RoomActivity.this).setTitle("删除")
                        .setMessage("确认删除？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 从SQLite数据库的表中删除
                                roomService.delete(selectedRoom.getRoomName());
                                // 移除rooms中的数据，并刷新adapter
                                rooms.remove(position);
                                roomAdapter.notifyDataSetChanged();
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
        roomService = new RoomServiceImpl(this);
        rooms = roomService.getAllRooms();

        // 若数据库中没数据，则初始化数据列表，防止ListView报错
        if (rooms == null) {
            rooms = new ArrayList<>();
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
            //更新rooms列表
            selectedRoom= (Room) bundle.get("room");
            if(requestCode==MODIFY_REQUEST){
                rooms.set(selectedPos,selectedRoom);
            }else if(requestCode==ADD_REQUEST){
                rooms.add(selectedRoom);
            }
            //刷新ListView
            roomAdapter.notifyDataSetChanged();
        }
    }
//创建添加功能的选项菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //动态加载菜单
        MenuItem item=menu.add(Menu.FIRST,1,Menu.NONE,"添加");
        item.setIcon(android.R.drawable.ic_menu_add);
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return true;
    }
//处理选项菜单的添加功能
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case Menu.FIRST:
                // 跳转到RoomActivity页面进行添加，flag用于存储是添加还是修改
                Intent intent = new Intent(RoomActivity.this, ADDRoomActivity.class);
                intent.putExtra("flag", "添加");
                startActivityForResult(intent, ADD_REQUEST);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
