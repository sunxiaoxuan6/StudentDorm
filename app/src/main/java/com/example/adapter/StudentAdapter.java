package com.example.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.model.Student;
import com.example.ui.R;

import java.util.List;

public class StudentAdapter extends BaseAdapter {
    private List<Student> students;

    public StudentAdapter(List<Student> students) {
        this.students = students;
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Student getItem(int position) {
        return students.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
            holder = new ViewHolder();

            holder.tvName = convertView.findViewById(R.id.s_name);
            holder.tvId = convertView.findViewById(R.id.s_id);
            holder.tvSex = convertView.findViewById(R.id.s_sex);
            holder.tvDormId = convertView.findViewById(R.id.s_dorm_id);
            holder.tvFaculty = convertView.findViewById(R.id.s_faculty);
            holder.tvClass = convertView.findViewById(R.id.s_class);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Student student = students.get(position);
        holder.tvName.setText(student.getName());
        holder.tvId.setText(String.valueOf(student.getId()));
        holder.tvSex.setText(String.valueOf(student.getSex()));
        holder.tvDormId.setText(String.valueOf(student.getDorm_id()));
        holder.tvFaculty.setText(String.valueOf(student.getFaculty()));
        holder.tvClass.setText(String.valueOf(student.getClass1()));

        return convertView;
    }
    static class ViewHolder {
        TextView tvName;
        TextView tvId;
        TextView tvSex;
        TextView tvDormId;
        TextView tvFaculty;
        TextView tvClass;
    }
}
