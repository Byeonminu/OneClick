package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.ui.dashboard.ImageAdapter;

import java.util.ArrayList;


public class FullScreenActivity extends AppCompatActivity {

    ImageView imageView;
    ArrayList<Uri> mArrayUri = new ArrayList<Uri>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);

        imageView = (ImageView) findViewById(R.id.full_image);

//        getSupportActionBar().hide();
        //getSupportActionBar().setTitle("Full Screen Image");

        Intent i = getIntent();

        int position = i.getExtras().getInt("id");

        ImageAdapter imageAdapter = new ImageAdapter(this, mArrayUri);
        imageView.setImageURI(mArrayUri.get(position));

    }
}