package com.example.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.model.Entering;
import com.example.ui.R;

import java.util.List;

public class EnteringAdapter extends BaseAdapter {
    private List<Entering> enterings;

    public EnteringAdapter(List<Entering> enterings) {
        this.enterings = enterings;
    }

    @Override
    public int getCount() {
        return enterings.size();
    }

    @Override
    public Entering getItem(int position) {
        return enterings.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_entering, parent, false);
            holder = new ViewHolder();

            holder.tvSuSheHao = convertView.findViewById(R.id.sushehao);
            holder.tvRenshu = convertView.findViewById(R.id.renshu);
            holder.tvPeopleName = convertView.findViewById(R.id.peoplename);
            holder.tvOccupied = convertView.findViewById(R.id.occupied);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Entering entering = enterings.get(position);
        holder.tvSuSheHao.setText(entering.getName());
        holder.tvRenshu.setText(String.valueOf(entering.getNumber()));
        holder.tvPeopleName.setText(String.valueOf(entering.getStudentName()));
        holder.tvOccupied.setText(String.valueOf(entering.getOccupied()));

        return convertView;
    }
    static class ViewHolder {
        TextView tvSuSheHao;
        TextView tvRenshu;
        TextView tvPeopleName;
        TextView tvOccupied;

    }
}
