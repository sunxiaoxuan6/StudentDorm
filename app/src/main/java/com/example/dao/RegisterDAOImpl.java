package com.example.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.model.Register;
import com.example.model.Room;
import com.example.util.MyDBHelper;

import java.util.ArrayList;
import java.util.List;

public class RegisterDAOImpl implements RegisterDao {
    private MyDBHelper helper;
    private SQLiteDatabase db;


    public RegisterDAOImpl(Context context){
        //调用MyDBHelper类的构造方法时，
        //若发现demo.db不存在会调用onCreate创建
        //若发现demo.db存在，且version的版本与已有的不一致，则调用onUpgrade方法更新
        helper=new MyDBHelper(context);
    }

    @Override
    public List<Register> selectAllRegister() {
        String sql = "select * from register";
        List<Register> registers = null;

        // 1. 获取SQLiteDatabase对象
        db = helper.getReadableDatabase();

        // 2. 执行SQL查询
        Cursor cursor = db.rawQuery(sql, null);

        // 3. 处理结果
        if (cursor != null && cursor.getCount() > 0) {
            registers = new ArrayList<>();
            while (cursor.moveToNext()) {
                Register register = new Register();
                register.setId(cursor.getInt(cursor.getColumnIndex("id")));
                register.setName(cursor.getString(cursor.getColumnIndex("name")));
                register.setStudentId(cursor.getString(cursor.getColumnIndex("student_id")));
                register.setPassword(cursor.getString(cursor.getColumnIndex("password")));
                register.setSecondPassword(cursor.getString(cursor.getColumnIndex("second_password")));

                registers.add(register);
            }
            // 4. 关闭cursor
            cursor.close();
        }
        db.close();
        // 5. 返回结果
        return registers;
    }

    @Override
    public Register select(String studentId) {
        String sql = "select * from register where name=?";
        Register register = null;

        // 1. 获取SQLiteDatabase对象
        db = helper.getReadableDatabase();

        // 2. 执行SQL查询
        Cursor cursor = db.rawQuery(sql, new String[]{studentId});

        // 3. 处理结果
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToNext()) {
                register = new Register();
                register.setId(cursor.getInt(cursor.getColumnIndex("id")));
                register.setName(cursor.getString(cursor.getColumnIndex("name")));
                register.setStudentId(cursor.getString(cursor.getColumnIndex("student_id")));
                register.setPassword(cursor.getString(cursor.getColumnIndex("password")));
                register.setSecondPassword(cursor.getString(cursor.getColumnIndex("second_password")));
            }
            // 4. 关闭cursor
            cursor.close();
        }
        db.close();
        // 5. 返回结果
        return register;
    }

    @Override
    public List<Register> selectByCost(int cost) {
        String sql = "select * from register where password == second_password";
        List<Register> registers = null;

        // 1. 获取SQLiteDatabase对象
        db = helper.getReadableDatabase();

        // 2. 执行SQL查询
        Cursor cursor = db.rawQuery(sql, null);

        // 3. 处理结果
        if (cursor != null && cursor.getCount() > 0) {
            registers = new ArrayList<>();
            while (cursor.moveToNext()) {
                Register register = new Register();
                register.setId(cursor.getInt(cursor.getColumnIndex("id")));
                register.setName(cursor.getString(cursor.getColumnIndex("name")));
                register.setStudentId(cursor.getString(cursor.getColumnIndex("student_id")));
                register.setPassword(cursor.getString(cursor.getColumnIndex("password")));
                register.setSecondPassword(cursor.getString(cursor.getColumnIndex("second_password")));

                registers.add(register);
            }
            // 4. 关闭cursor
            cursor.close();
        }
        db.close();
        // 5. 返回结果
        return registers;
    }

    @Override
    public void insert(Register register) {
        db = helper.getWritableDatabase();
        String sql = "insert into register values(null,?,?,?,?)";
        db.execSQL(sql, new Object[]{
                register.getName(),
                register.getStudentId(),
                register.getPassword(),
                register.getSecondPassword()});
        db.close();
    }

    @Override
    public void update(Register register) {
        // 1. 获取db对象
        db = helper.getWritableDatabase();
        // 2. 执行sql
        String sql = "update register set name=? where student_id=?";
        db.execSQL(sql, new Object[]{
                register.getName(),
                register.getStudentId()
        });
    }

    @Override
    public void delete(String Name) {
        // 1. 获取db对象
        db = helper.getWritableDatabase();        // 2. 执行sql
        String sql = "delete from register where name=?";
        db.execSQL(sql, new Object[]{ Name });
    }
}
