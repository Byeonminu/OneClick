package com.example.myapplication.ui.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.ui.home.Data;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {
    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    public int[] arrNumberImage = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four,
            R.drawable.five,R.drawable.six, R.drawable.seven, R.drawable.eight, R.drawable.nine, R.drawable.ten};
    public String[] arrNumberWord = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

    public ImageAdapter(Context mContext) {
        this.mContext = mContext;
        this.mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrNumberWord.length;
    }

    @Override
    public Object getItem(int position) {
        return arrNumberImage[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = mLayoutInflater.inflate(R.layout.grid_view, null);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.picture);
        imageView.setImageResource(arrNumberImage[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        return convertView;
    }
}
