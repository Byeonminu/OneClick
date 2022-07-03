package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.ui.home.Data;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityMainBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ArrayList<Data> SampleData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SampleData = new ArrayList<Data>();

        SampleData.add(new Data("강해상","010-4616-7253"));
        SampleData.add(new Data("구씨","010-1772-5167"));
        SampleData.add(new Data("유재석","010-5342-2421"));
        /*SampleData.add(new Data("김태형","010-2943-3915"));
        SampleData.add(new Data("전정국","010-9513-3563"));
        SampleData.add(new Data("민윤기","010-6243-5915"));
        SampleData.add(new Data("김남준","010-2143-6813"));
        SampleData.add(new Data("지민","010-2942-6235"));
        SampleData.add(new Data("진","010-3532-7343"));
        SampleData.add(new Data("제이홉","010-6212-5531"));*/

        Intent i=getIntent();
        Bundle extras = i.getExtras();
        if (extras != null) {
            String name=i.getStringExtra("name");
            String phone=i.getStringExtra("phone");

            Log.v("main activity name", name);
            Log.v("main activity phone", phone);

            SampleData.add(new Data(name, phone));
        }

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);


    }

    public ArrayList<Data> getMyData(){
        return SampleData;
    }

}