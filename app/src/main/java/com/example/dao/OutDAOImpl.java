package com.example.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.model.Out;
import com.example.model.Room;
import com.example.util.MyDBHelper;

import java.util.ArrayList;
import java.util.List;

public class OutDAOImpl implements OutDao{
    private MyDBHelper helper;
    private SQLiteDatabase db;

    public OutDAOImpl(Context context){
        //调用MyDBHelper类的构造方法时，
        //若发现demo.db不存在会调用onCreate创建
        //若发现demo.db存在，且version的版本与已有的不一致，则调用onUpgrade方法更新
        helper=new MyDBHelper(context);
    }

    public void insert(Out out){
        db = helper.getWritableDatabase();
        String sql = "insert into out values(null,?,?,?,?)";
        db.execSQL(sql, new Object[]{
                out.getOutName(),
                out.getReason(),
                out.getTime(),
                out.getBackTime()});
        db.close();
    }


    @Override
    public List<Out> selectAllOuts() {
        String sql = "select * from out";
        List<Out> outs = null;

        // 1. 获取SQLiteDatabase对象
        db = helper.getReadableDatabase();

        // 2. 执行SQL查询
        Cursor cursor = db.rawQuery(sql, null);

        // 3. 处理结果
        if (cursor != null && cursor.getCount() > 0) {
            outs = new ArrayList<>();
            while (cursor.moveToNext()) {
                Out out = new Out();
                out.setId(cursor.getInt(cursor.getColumnIndex("id")));
                out.setOutName(cursor.getString(cursor.getColumnIndex("out_name")));
                out.setReason(cursor.getString(cursor.getColumnIndex("reason")));
                out.setTime(cursor.getString(cursor.getColumnIndex("time")));
                out.setBackTime(cursor.getString(cursor.getColumnIndex("back_time")));
                outs.add(out);
            }
            // 4. 关闭cursor
            cursor.close();
        }
        db.close();
        // 5. 返回结果
        return outs;
    }

    @Override
    public Out select(String outName) {
        String sql = "select * from out where out_name=?";
        Out out = null;

        // 1. 获取SQLiteDatabase对象
        db = helper.getReadableDatabase();

        // 2. 执行SQL查询
        Cursor cursor = db.rawQuery(sql, new String[]{outName});

        // 3. 处理结果
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToNext()) {
                out = new Out();
                out.setId(cursor.getInt(cursor.getColumnIndex("id")));
                out.setOutName(cursor.getString(cursor.getColumnIndex("out_name")));
                out.setReason(cursor.getString(cursor.getColumnIndex("reason")));
                out.setTime(cursor.getString(cursor.getColumnIndex("time")));
                out.setBackTime(cursor.getString(cursor.getColumnIndex("back_time")));
            }
            // 4. 关闭cursor
            cursor.close();
        }
        db.close();
        // 5. 返回结果
        return out;
    }

    @Override
    public List<Out> selectByCost(int cost) {
        return null;
    }


    @Override
    public void update(Out out) {
        // 1. 获取db对象
        db = helper.getWritableDatabase();
        // 2. 执行sql
        String sql = "update out set out_name=? where reason=?";
        db.execSQL(sql, new Object[]{
                out.getOutName(),
                out.getReason()
        });

    }

    @Override
    public void delete(String outName) {
        // 1. 获取db对象
        db = helper.getWritableDatabase();
        // 2. 执行sql
        String sql = "delete from out where out_name=?";
        db.execSQL(sql, new Object[]{ outName });

    }
}