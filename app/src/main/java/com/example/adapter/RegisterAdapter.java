package com.example.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.model.Register;
import com.example.model.Room;
import com.example.ui.R;

import java.util.List;

public class RegisterAdapter extends BaseAdapter {
    private List<Register> registers;

    public RegisterAdapter(List<Register> registers) {
        this.registers = registers;
    }

    @Override
    public int getCount() {
        return registers.size();
    }

    @Override
    public Object getItem(int position) {
        return registers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RegisterAdapter.ViewHolder holder;
        if(convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_room, parent, false);
            holder = new RegisterAdapter.ViewHolder();

            holder.tvName = convertView.findViewById(R.id.tv_name);
            holder.tvStudentId = convertView.findViewById(R.id.tv_student_id);
            holder.tvPassword = convertView.findViewById(R.id.tv_password);
            holder.tvSecondPassword = convertView.findViewById(R.id.tv_second_password);

            convertView.setTag(holder);
        } else {
            holder = (RegisterAdapter.ViewHolder) convertView.getTag();
        }

        Register register = registers.get(position);
        holder.tvName.setText(register.getName());
        holder.tvStudentId.setText(String.valueOf(register.getStudentId()));
        holder.tvPassword.setText(String.valueOf(register.getPassword()));
        holder.tvSecondPassword.setText(String.valueOf(register.getSecondPassword()));

        return convertView;
    }
    static class ViewHolder {
        TextView tvName;
        TextView tvStudentId;
        TextView tvPassword;
        TextView tvSecondPassword;
    }
}
