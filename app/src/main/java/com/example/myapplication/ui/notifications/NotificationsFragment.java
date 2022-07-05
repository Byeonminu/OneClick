package com.example.myapplication.ui.notifications;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.myapplication.AlarmReceiver;
import com.example.myapplication.databinding.FragmentNotificationsBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    AlarmManager alarmManager;
    PendingIntent alarmIntent;


    @RequiresApi(api = Build.VERSION_CODES.M)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Intent intent = new Intent(getActivity(), AlarmReceiver.class);

        binding.save.setOnClickListener(new AdapterView.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                int hour = binding.timePicker.getHour();
                int minute = binding.timePicker.getMinute();
                calendar.set(Calendar.HOUR_OF_DAY, hour);
                calendar.set(Calendar.MINUTE, minute);
                Toast.makeText(getActivity(), "Alarm 예정 " + hour + "시 " + minute + "분", Toast.LENGTH_SHORT).show();

                if (calendar.before(Calendar.getInstance())) {
                    calendar.add(Calendar.DATE, 1);
                }

                alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);

                if (alarmManager != null) {

                    intent.putExtra("state", "alarm on");
//                    intent.putExtra("Ringtone",getResources().getResourceName(R.raw.));
                    alarmIntent = PendingIntent.getBroadcast(getActivity(), 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);

//                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
//                            AlarmManager.INTERVAL_DAY, alarmIntent);
                    alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);
                }
                ;
            }

        });

        binding.finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Alarm 종료", Toast.LENGTH_SHORT).show();
                // 알람매니저 취소
                alarmManager.cancel(alarmIntent);

                intent.putExtra("state", "alarm off");

                // 알람취소
                getActivity().sendBroadcast(intent);
            }
        });

//        binding.timePicker.setIs24HourView(true);
//
//
//        // 앞서 설정한 값으로 보여주기
//        // 없으면 디폴트 값은 현재시간
//        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("daily alarm", getActivity().MODE_PRIVATE);
//        long millis = sharedPreferences.getLong("nextNotifyTime", Calendar.getInstance().getTimeInMillis());
//
//        Calendar nextNotifyTime = new GregorianCalendar();
//        nextNotifyTime.setTimeInMillis(millis);
//
//        Date nextDate = nextNotifyTime.getTime();
//        String date_text = new SimpleDateFormat("yyyy년 MM월 dd일 EE요일 a hh시 mm분 ", Locale.getDefault()).format(nextDate);
//        Toast.makeText(getActivity(),"[처음 실행시] 다음 알람은 " + date_text + "으로 알람이 설정되었습니다!", Toast.LENGTH_SHORT).show();
//
//
//        // 이전 설정값으로 TimePicker 초기화
//        Date currentTime = nextNotifyTime.getTime();
//        SimpleDateFormat HourFormat = new SimpleDateFormat("kk", Locale.getDefault());
//        SimpleDateFormat MinuteFormat = new SimpleDateFormat("mm", Locale.getDefault());
//
//        int pre_hour = Integer.parseInt(HourFormat.format(currentTime));
//        int pre_minute = Integer.parseInt(MinuteFormat.format(currentTime));
//
//
//        if (Build.VERSION.SDK_INT >= 23 ){
//            binding.timePicker.setHour(pre_hour);
//            binding.timePicker.setMinute(pre_minute);
//        }
//        else{
//            binding.timePicker.setCurrentHour(pre_hour);
//            binding.timePicker.setCurrentMinute(pre_minute);
//        }
//
//
//
//        binding.save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View arg0) {
//
//                int hour, hour_24, minute;
//                String am_pm;
//                if (Build.VERSION.SDK_INT >= 23) {
//                    hour_24 = binding.timePicker.getHour();
//                    minute = binding.timePicker.getMinute();
//                } else {
//                    hour_24 = binding.timePicker.getCurrentHour();
//                    minute = binding.timePicker.getCurrentMinute();
//                }
//                if (hour_24 > 12) {
//                    am_pm = "PM";
//                    hour = hour_24 - 12;
//                } else {
//                    hour = hour_24;
//                    am_pm = "AM";
//                }
//
//                // 현재 지정된 시간으로 알람 시간 설정
//                Calendar calendar = Calendar.getInstance();
//                calendar.setTimeInMillis(System.currentTimeMillis());
//                calendar.set(Calendar.HOUR_OF_DAY, hour_24);
//                calendar.set(Calendar.MINUTE, minute);
//                calendar.set(Calendar.SECOND, 0);
//
//                // 이미 지난 시간을 지정했다면 다음날 같은 시간으로 설정
//                if (calendar.before(Calendar.getInstance())) {
//                    calendar.add(Calendar.DATE, 1);
//                }
//
//                Date currentDateTime = calendar.getTime();
//                String date_text = new SimpleDateFormat("yyyy년 MM월 dd일 EE요일 a hh시 mm분 ", Locale.getDefault()).format(currentDateTime);
//                Toast.makeText(getActivity(), date_text + "으로 알람이 설정되었습니다!", Toast.LENGTH_SHORT).show();
//
//                //  Preference에 설정한 값 저장
//                SharedPreferences.Editor editor = getActivity().getSharedPreferences("daily alarm", getActivity().MODE_PRIVATE).edit();
//                editor.putLong("nextNotifyTime", (long) calendar.getTimeInMillis());
//                editor.apply();
//
//
//                diaryNotification(calendar);
//            }
//        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

//    void diaryNotification(Calendar calendar) {
////        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
////        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
////        Boolean dailyNotify = sharedPref.getBoolean(SettingsActivity.KEY_PREF_DAILY_NOTIFICATION, true);
//        Boolean dailyNotify = true; // 무조건 알람을 사용
//
//        PackageManager pm = getActivity().getPackageManager();
//        ComponentName receiver = new ComponentName(getActivity(), com.tistory.webnautes.notificationexample.DeviceBootReceiver.class);
//        Intent alarmIntent = new Intent(getActivity(), com.tistory.webnautes.notificationexample.AlarmReceiver.class);
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity(), 0, alarmIntent, 0);
//        AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
//
//
//        // 사용자가 매일 알람을 허용했다면
//        if (dailyNotify) {
//
//            if (alarmManager != null) {
//
//                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
//                        AlarmManager.INTERVAL_DAY, pendingIntent);
//
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                    alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
//                }
//            }
//
//            // 부팅 후 실행되는 리시버 사용가능하게 설정
//            pm.setComponentEnabledSetting(receiver,
//                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
//                    PackageManager.DONT_KILL_APP);
//
//        }
//    }
//}
////        else { //Disable Daily Notifications
////            if (PendingIntent.getBroadcast(this, 0, alarmIntent, 0) != null && alarmManager != null) {
////                alarmManager.cancel(pendingIntent);
////                //Toast.makeText(this,"Notifications were disabled",Toast.LENGTH_SHORT).show();
////            }
////            pm.setComponentEnabledSetting(receiver,
////                    PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
////                    PackageManager.DONT_KILL_APP);
////        }
//
////
////}
////}
