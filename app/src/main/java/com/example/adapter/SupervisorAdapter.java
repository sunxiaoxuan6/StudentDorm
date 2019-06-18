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
            holder.lvRoom = convertView.findViewById(R.id.m_room);
            holder.lvPeriod = convertView.findViewById(R.id.m_period);
            holder.lvRemark = convertView.findViewById(R.id.m_remark);


            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        Supervisor supervisor = Supervisors.get(position);
        holder.lvName.setText(supervisor.getName());
        holder.lvJob_number.setText(String.valueOf(supervisor.getJob_number()));
        holder.lvSex.setText(String.valueOf(supervisor.getSex()));
        holder.lvBuild_number.setText(String.valueOf(supervisor.getBuild_number()));
        holder.lvJob_hour.setText(String.valueOf(supervisor.getJob_hour()));
        holder.lvContact.setText(String.valueOf(supervisor.getContact()));
        holder.lvRoom.setText(String.valueOf(supervisor.getContact()));
        holder.lvPeriod.setText(String.valueOf(supervisor.getContact()));
        holder.lvRemark.setText(String.valueOf(supervisor.getContact()));

        return convertView;
    }

    static class ViewHolder {
        TextView lvName;
        TextView lvJob_number;
        TextView lvSex;
        TextView lvBuild_number;
        TextView lvJob_hour;
        TextView lvContact;
        TextView lvRoom;
        TextView lvPeriod;
        TextView lvRemark;
    }
}
