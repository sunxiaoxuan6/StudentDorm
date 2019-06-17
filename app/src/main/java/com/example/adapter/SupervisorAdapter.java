package com.example.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.model.Supervisor;

import java.util.List;

public class SupervisorAdapter extends BaseAdapter {
    private List<Supervisor> Supervisors;

    public SupervisorAdapter(List<Supervisor> Supervisors){
        this.Supervisors = Supervisors;
    }
    @Override
    public int getCount() {
        return Supervisors.size();
    }

    @Override
    public Object getItem(int position) {
        return Supervisors.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
