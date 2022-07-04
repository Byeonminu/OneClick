package com.example.myapplication.ui.home;

import android.os.Parcel;
import android.os.Parcelable;

public class Data implements Parcelable {

    private String name;
    private String phone;

    public Data(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    protected Data(Parcel in) {
        name = in.readString();
        phone = in.readString();
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(phone);
    }
}
