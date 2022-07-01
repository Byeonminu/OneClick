package com.example.myapplication.ui.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.ui.home.Data;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {
    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    int[] arrNumberImage;
    String[] arrNumberWord;

    public ImageAdapter(Context mContext,  int[] arrNumberImage, String[] arrNumberWord) {
        this.mContext = mContext;
        this.mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.arrNumberImage = arrNumberImage;
        this.arrNumberWord = arrNumberWord;
    }

    @Override
    public int getCount() {
        return arrNumberWord.length;
    }

    @Override
    public Object getItem(int position) {
        return arrNumberWord[position];
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

        return convertView;
    }
}
