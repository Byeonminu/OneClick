package com.example.myapplication.ui.dashboard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {
    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    //private ImageView ivGallery;
    private ArrayList<Uri> mArrayUri;

    public int[] arrNumberImage = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four,
            R.drawable.five,R.drawable.six, R.drawable.seven, R.drawable.eight, R.drawable.nine, R.drawable.ten};
    public String[] arrNumberWord = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

    public ImageAdapter(Context mContext, ArrayList<Uri> mArrayUri) {
        this.mContext = mContext;
        this.mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mArrayUri=mArrayUri;
    }

    @Override
    public int getCount() {
        return mArrayUri.size();
    }

    @Override
    public Object getItem(int position) {
        return mArrayUri.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = mLayoutInflater.inflate(R.layout.grid_view, parent,false);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.picture);
        @SuppressLint("UseCompatLoadingForDrawables") GradientDrawable drawable=(GradientDrawable) mContext.getDrawable(R.drawable.background_rounding);


        //imageView.setImageResource(arrNumberImage[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setBackground(drawable);
        imageView.setClipToOutline(true);
        imageView.setImageURI(mArrayUri.get(position));

        return convertView;
    }
    public ArrayList<Uri> getArray(){
        return mArrayUri;
    }
}
