package com.example.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.model.Student;
import com.example.model.Supervisor;
import com.example.util.MyDBHelper;

import java.util.ArrayList;
import java.util.List;

public class SupervisorDAOImpl implements SupervisorDAO {
    private MyDBHelper helper;
    private SQLiteDatabase db;

    public SupervisorDAOImpl(Context context){
        helper = new MyDBHelper(context);
    }
    @Override
    public List<Supervisor> selectAllSupervisors() {
        String sql = "select * from supervisor";
        List<Supervisor> supervisors = null;
        db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null && cursor.getCount() > 0) {
            supervisors = new ArrayList<>();
            while (cursor.moveToNext()) {
                Supervisor supervisor = new Supervisor();
                supervisor.setId(cursor.getInt(cursor.getColumnIndex("id")));

                supervisor.setName(cursor.getString(cursor.getColumnIndex("name")));
                supervisor.setJob_number(cursor.getInt(cursor.getColumnIndex("job_number")));
                supervisor.setSex(cursor.getString(cursor.getColumnIndex("sex")));
                supervisor.setBuild_number(cursor.getInt(cursor.getColumnIndex("build_number")));
                supervisor.setJob_hour(cursor.getInt(cursor.getColumnIndex("job_hour")));
                supervisor.setContact(cursor.getString(cursor.getColumnIndex("contact")));
                supervisors.add(supervisor);
            }
            cursor.close();
        }
        db.close();
        // 5. 返回结果
        return supervisors;
    }

    @Override
    public Supervisor select(String name) {
        String sql = "select * from supervisor where name=?";
        Supervisor supervisors = null;

        // 1. 获取SQLiteDatabase对象
        db = helper.getReadableDatabase();

        // 2. 执行SQL查询
        Cursor cursor = db.rawQuery(sql, new String[]{name});
        if (cursor != null && cursor.getCount() > 0){
            if (cursor.moveToNext()){
                supervisors = new Supervisor();
                supervisors.setId(cursor.getInt(cursor.getColumnIndex("id")));

                supervisors.setName(cursor.getString(cursor.getColumnIndex("name")));
                supervisors.setJob_number(cursor.getInt(cursor.getColumnIndex("job_number")));
                supervisors.setSex(cursor.getString(cursor.getColumnIndex("sex")));
                supervisors.setBuild_number(cursor.getInt(cursor.getColumnIndex("build_number")));
                supervisors.setJob_hour(cursor.getInt(cursor.getColumnIndex("job_hour")));
                supervisors.setContact(cursor.getString(cursor.getColumnIndex("contact")));
            }
            cursor.close();
        }
        db.close();
        // 5. 返回结果
        return supervisors;
    }

    @Override
    public List<Supervisor> selectByCost(int cost) {
        String sql = "select * from supervisor where educational > 4";
        List<Supervisor> supervisors = null;
        db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null && cursor.getCount() > 0){
            supervisors = new ArrayList<>();
            while (cursor.moveToNext()){
                Supervisor supervisor = new Supervisor();
                supervisor.setId(cursor.getInt(cursor.getColumnIndex("id")));

                supervisor.setName(cursor.getString(cursor.getColumnIndex("name")));
                supervisor.setJob_number(cursor.getInt(cursor.getColumnIndex("job_number")));
                supervisor.setSex(cursor.getString(cursor.getColumnIndex("sex")));
                supervisor.setBuild_number(cursor.getInt(cursor.getColumnIndex("build_number")));
                supervisor.setJob_hour(cursor.getInt(cursor.getColumnIndex("job_hour")));
                supervisor.setContact(cursor.getString(cursor.getColumnIndex("contact")));
                supervisors.add(supervisor);
            }
            cursor.close();
        }
        db.close();
        // 5. 返回结果
        return supervisors;
    }

    @Override
    public void insert(Supervisor supervisor) {
        db = helper.getWritableDatabase();
        String sql = "insert into student values(null,?,?,?,?,?,?)";
        db.execSQL(sql, new Object[]{
                supervisor.getName(),
                supervisor.getJob_number(),
                supervisor.getSex(),
                supervisor.getBuild_number(),
                supervisor.getJob_hour(),
                supervisor.getContact(),});
                db.close();
    }

    @Override
    public void update(Supervisor supervisor) {
        // 1. 获取dbs对象
        db = helper.getWritableDatabase();
        // 2. 执行sql
        String sql = "update supervisor set job_number=? where name=?";
        db.execSQL(sql, new Object[]{
                supervisor.getJob_number(),
                supervisor.getName()
        });
    }

    @Override
    public void delete(String name) {
        // 1. 获取db对象
        db = helper.getWritableDatabase();
        // 2. 执行sql
        String sql = "delete from supervisor where name=?";
        db.execSQL(sql, new Object[]{ name });
    }
}
