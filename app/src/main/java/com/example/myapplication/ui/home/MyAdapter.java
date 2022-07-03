package com.example.myapplication.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<Data> sample;

    public MyAdapter(Context mContext, ArrayList<Data> sample) {
        this.mContext = mContext;
        this.mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.sample = sample;
    }

    @Override
    public int getCount() {
        return sample.size();
    }

    @Override
    public Data getItem(int position) {
        return sample.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = mLayoutInflater.inflate(R.layout.list_view, parent, false);

        TextView nameView = (TextView) convertView.findViewById(R.id.name);
        TextView phoneView = (TextView) convertView.findViewById(R.id.phone);

        nameView.setText(sample.get(position).getName());
        phoneView.setText(sample.get(position).getPhone());

        return convertView;
    }
}
