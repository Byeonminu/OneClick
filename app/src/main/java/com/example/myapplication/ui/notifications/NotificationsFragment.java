package com.example.myapplication.ui.notifications;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.AddActivity;
import com.example.myapplication.AlarmReceiver;
import com.example.myapplication.MainActivity;
import com.example.myapplication.databinding.FragmentNotificationsBinding;

import java.util.Calendar;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;


    @RequiresApi(api = Build.VERSION_CODES.M)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.save.setOnClickListener(new AdapterView.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                int hour = binding.timePicker.getHour();
                int minute = binding.timePicker.getMinute();
                calendar.set(Calendar.HOUR_OF_DAY, hour);
                calendar.set(Calendar.MINUTE, minute);

                if (calendar.before(Calendar.getInstance())) {
                    calendar.add(Calendar.DATE, 1);
                }

                AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);

                if (alarmManager != null) {
                    Intent intent = new Intent(getActivity(), AlarmReceiver.class);
                    PendingIntent alarmIntent = PendingIntent.getBroadcast(getActivity(), 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                            AlarmManager.INTERVAL_DAY, alarmIntent);

                    Toast.makeText(getActivity(), "알람이 저장되었습니다.", Toast.LENGTH_LONG).show();

                };
            }

        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}