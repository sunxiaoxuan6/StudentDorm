package com.example.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.adapter.OutAdapter;
import com.example.model.Out;
import com.example.service.OutService;
import com.example.service.OutServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class ExamineActivity extends AppCompatActivity {
    private static final int MODIFY_REQUEST=101;
    private static final int ADD_REQUEST=100;

    private ListView outList;
    private OutAdapter outAdapter;
    private OutService outService;
    private List<Out> outs;
    private Out selectedOut;
    private  int selectedPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examine);
        initData();
        outList=findViewById(R.id.list_out);
        outAdapter=new OutAdapter(outs);
        outList.setAdapter(outAdapter);

        outList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedPos=position;
                selectedOut=(Out) parent.getItemAtPosition(position);

                Intent intent=new Intent(ExamineActivity.this,OutActivity.class);
                intent.putExtra("flag","修改");


                Bundle bundle=new Bundle();
                bundle.putSerializable("out",selectedOut);
                intent.putExtras(bundle);

                startActivityForResult(intent,MODIFY_REQUEST);
            }
        });
        outList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                // 弹出警告对话框，确认是否删除
                selectedOut = (Out) parent.getItemAtPosition(position);

                new AlertDialog.Builder(ExamineActivity.this).setTitle("删除")
                        .setMessage("确认删除？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 从SQLite数据库的表中删除
                                outService.delete(selectedOut.getOutName());
                                // 移除rooms中的数据，并刷新adapter
                                outs.remove(position);
                                outAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();
                return;
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        if (data != null) {
            Bundle bundle = data.getExtras();
            if (bundle == null) {
                return;
            }
            // 更新rooms列表
            selectedOut = (Out) bundle.get("out");
            if (requestCode == MODIFY_REQUEST) {
                outs.set(selectedPos, selectedOut);
            } else if (requestCode == ADD_REQUEST) {
                outs.add(selectedOut);
            }
            // 刷新ListView
            outAdapter.notifyDataSetChanged();
        }
    }

    private void initData() {
        outService = new OutServiceImpl(this);
        outs = outService.getAllOuts();
        if (outs == null){
            outs = new ArrayList<>();
        }
    }
}
