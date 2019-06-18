package com.example.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.model.Supervisor;
import com.example.ui.R;

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
        SupervisorAdapter.ViewHolder holder;
        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_supervisor, parent, false);
            holder = new SupervisorAdapter.ViewHolder();

            holder.lvName = convertView.findViewById(R.id.m_name);
            holder.lvJob_number = convertView.findViewById(R.id.m_job_number);
            holder.lvSex = convertView.findViewById(R.id.m_sex);
            holder.lvBuild_number = convertView.findViewById(R.id.m_build_number);
            holder.lvJob_hour = convertView.findViewById(R.id.m_job_hour);
            holder.lvContact = convertView.findViewById(R.id.m_contact);

            convertView.setTag(holder);
        }
        return null;
    }

    static class ViewHolder {
        TextView lvName;
        TextView lvJob_number;
        TextView lvSex;
        TextView lvBuild_number;
        TextView lvJob_hour;
        TextView lvContact;
    }
}
