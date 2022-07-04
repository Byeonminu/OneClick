package com.example.myapplication.ui.notifications;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class RList {

    public ArrayList<String> Data;

    public RList(ArrayList<String> data) {
        Data = data;
    }

    public void Add(String a) {
        Data.add(a);
    }

    public int Size() {
        return Data.size();
    }

    public String Get(int position) {
        return Data.get(position);
    }
}
