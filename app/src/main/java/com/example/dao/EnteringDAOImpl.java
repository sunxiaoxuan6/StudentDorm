package com.example.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.model.Entering;
import com.example.util.MyDBHelper;

import java.util.ArrayList;
import java.util.List;

public class EnteringDAOImpl implements EnteringDao{
    private MyDBHelper helper;
    private SQLiteDatabase db;


    public EnteringDAOImpl(Context context){
        //调用MyDBHelper类的构造方法时，
        //若发现demo.db不存在会调用onCreate创建
        //若发现demo.db存在，且version的版本与已有的不一致，则调用onUpgrade方法更新
        helper=new MyDBHelper(context);
    }

    @Override
    public List<Entering> selectAllRooms() {
        String sql = "select * from entering";
        List<Entering> enterings = null;

        // 1. 获取SQLiteDatabase对象
        db = helper.getReadableDatabase();

        // 2. 执行SQL查询
        Cursor cursor = db.rawQuery(sql, null);

        // 3. 处理结果
        if (cursor != null && cursor.getCount() > 0) {
            enterings = new ArrayList<>();
            while (cursor.moveToNext()) {
                Entering entering = new Entering();
                entering.setId(cursor.getInt(cursor.getColumnIndex("id")));
                entering.setName(cursor.getString(cursor.getColumnIndex("name")));
                entering.setNumber(cursor.getInt(cursor.getColumnIndex("number")));
                entering.setStudentName(cursor.getString(cursor.getColumnIndex("studentName")));
                entering.setOccupied(cursor.getInt(cursor.getColumnIndex("occupied")));

                enterings.add(entering);
            }
            // 4. 关闭cursor
            cursor.close();
        }
        db.close();
        // 5. 返回结果
        return enterings;
    }

    @Override
    public Entering select(String roomName) {
        String sql = "select * from entering where name=?";
        Entering entering = null;

        // 1. 获取SQLiteDatabase对象
        db = helper.getReadableDatabase();

        // 2. 执行SQL查询
        Cursor cursor = db.rawQuery(sql, new String[]{roomName});

        // 3. 处理结果
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToNext()) {
                entering = new Entering();
                entering.setId(cursor.getInt(cursor.getColumnIndex("id")));
                entering.setName(cursor.getString(cursor.getColumnIndex("name")));
                entering.setNumber(cursor.getInt(cursor.getColumnIndex("number")));
                entering.setStudentName(cursor.getString(cursor.getColumnIndex("studentName")));
                entering.setOccupied(cursor.getInt(cursor.getColumnIndex("occupied")));
            }
            // 4. 关闭cursor
            cursor.close();
        }
        db.close();
        // 5. 返回结果
        return entering;
    }

    @Override
    public List<Entering> selectByCost(int cost) {
        String sql = "select * from entering where number > occupied";
        List<Entering> enterings = null;

        // 1. 获取SQLiteDatabase对象
        db = helper.getReadableDatabase();

        // 2. 执行SQL查询
        Cursor cursor = db.rawQuery(sql, null);

        // 3. 处理结果
        if (cursor != null && cursor.getCount() > 0) {
            enterings = new ArrayList<>();
            while (cursor.moveToNext()) {
                Entering entering = new Entering();
                entering.setId(cursor.getInt(cursor.getColumnIndex("id")));
                entering.setName(cursor.getString(cursor.getColumnIndex("name")));
                entering.setNumber(cursor.getInt(cursor.getColumnIndex("number")));
                entering.setStudentName(cursor.getString(cursor.getColumnIndex("studentName")));
                entering.setOccupied(cursor.getInt(cursor.getColumnIndex("occupied")));

                enterings.add(entering);
            }
            // 4. 关闭cursor
            cursor.close();
        }
        db.close();
        // 5. 返回结果
        return enterings;
    }

    @Override
    public void insert(Entering entering) {
        db = helper.getWritableDatabase();
        String sql = "insert into entering values(null,?,?,?,?)";
        db.execSQL(sql, new Object[]{
                entering.getName(),
                entering.getNumber(),
                entering.getStudentName(),
                entering.getOccupied()});
        db.close();
    }

    @Override
    public void update(Entering entering) {
        // 1. 获取db对象
        db = helper.getWritableDatabase();
        // 2. 执行sql
        String sql = "update entering set number=? where name=?";
        db.execSQL(sql, new Object[]{
                entering.getName(),
                entering.getNumber()
        });
    }

    @Override
    public void delete(String name) {
        // 1. 获取db对象
        db = helper.getWritableDatabase();
        // 2. 执行sql
        String sql = "delete from entering where name=?";
        db.execSQL(sql, new Object[]{ name });
    }
}
