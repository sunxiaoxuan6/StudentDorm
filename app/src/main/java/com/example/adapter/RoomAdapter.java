package com.example.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.model.Room;
import com.example.ui.R;

import java.util.List;

public class RoomAdapter extends BaseAdapter {
    private List<Room> rooms;

    public RoomAdapter(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public int getCount() {
        return rooms.size();
    }

    @Override
    public Object getItem(int position) {
        return rooms.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_room,parent,false);
            holder=new ViewHolder();

            holder.tvName=convertView.findViewById(R.id.room_name);
            holder.tvExpectNumber=convertView.findViewById(R.id.room_expect);
            holder.tvRealNumber=convertView.findViewById(R.id.room_real);
            holder.tvCost=convertView.findViewById(R.id.room_cost);

            convertView.setTag(holder);
        }else {
            holder=(ViewHolder) convertView.getTag();
        }

        Room room=rooms.get(position);
        holder.tvName.setText(room.getRoomName());
        holder.tvExpectNumber.setText(room.getExpectNumber());
        holder.tvRealNumber.setText(room.getRealNumber());
        holder.tvCost.setText(room.getCost());
        return convertView;
    }
    static class ViewHolder{
        TextView tvName;
        TextView tvExpectNumber;
        TextView tvRealNumber;
        TextView tvCost;
    }
}
