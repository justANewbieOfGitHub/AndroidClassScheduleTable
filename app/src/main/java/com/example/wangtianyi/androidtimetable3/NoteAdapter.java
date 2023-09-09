package com.example.wangtianyi.androidtimetable3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class NoteAdapter extends BaseAdapter {
    private Context context;
    private List<NoteMode> list;

    public NoteAdapter(Context context, List<NoteMode> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.note_item,null);
            holder.tv_time = (TextView) convertView.findViewById(R.id.tv_time);
            holder.tv_content = (TextView) convertView.findViewById(R.id.tv_content);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        NoteMode noteMode = list.get(position);
        holder.tv_time.setText(noteMode.getTextTime());
        holder.tv_content.setText(noteMode.getText());
        return convertView;
    }

    class ViewHolder{
        TextView tv_time, tv_content;
    }
}
