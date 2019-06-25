package com.example.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.model.Out;
import com.example.model.Register;
import com.example.ui.R;

import java.util.List;

public class OutAdapter extends BaseAdapter {
    private List<Out> outs;

    public OutAdapter(List<Out> outs) {
        this.outs = outs;
    }

    @Override
    public int getCount() {
        return outs.size();
    }

    @Override
    public Object getItem(int position) {
        return outs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        com.example.adapter.OutAdapter.ViewHolder holder;
        if(convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_examine, parent, false);
            holder = new com.example.adapter.OutAdapter.ViewHolder();

            holder.tvName = convertView.findViewById(R.id.tv_name);
            holder.tvReason = convertView.findViewById(R.id.tv_reason);
            holder.tvTime = convertView.findViewById(R.id.tv_time);
            holder.tvBackTime = convertView.findViewById(R.id.tv_backtime);

            convertView.setTag(holder);
        } else {
            holder = (com.example.adapter.OutAdapter.ViewHolder) convertView.getTag();
        }

        Out out = outs.get(position);
        holder.tvName.setText(out.getOutName());
        holder.tvReason.setText(String.valueOf(out.getReason()));
        holder.tvTime.setText(String.valueOf(out.getTime()));
        holder.tvBackTime.setText(String.valueOf(out.getBackTime()));

        return convertView;
    }
    static class ViewHolder {
        TextView tvName;
        TextView tvReason;
        TextView tvTime;
        TextView tvBackTime;
    }
}