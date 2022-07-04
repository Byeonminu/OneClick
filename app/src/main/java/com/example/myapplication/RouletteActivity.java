package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;

import com.bluehomestudio.luckywheel.WheelItem;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.databinding.ActivityRouletteBinding;
import com.example.myapplication.ui.notifications.NotificationsFragment;

public class RouletteActivity extends AppCompatActivity {

    private ActivityRouletteBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRouletteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.addList.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                Editable new_item = (Editable) binding.newItem.getText();
                String new_item_s = new_item.toString();

                NotificationsFragment notificationsFragment = new NotificationsFragment();
                notificationsFragment.wheelItems.add(new WheelItem(Color.parseColor("#F44336"), null, new_item_s));
                Intent returnBtn = new Intent("Android.intent.action.MAIN");
                startActivity(returnBtn);
            }
        });;


    }
}