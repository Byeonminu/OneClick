package com.example.myapplication.ui.notifications;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bluehomestudio.luckywheel.LuckyWheel;
import com.bluehomestudio.luckywheel.OnLuckyWheelReachTheTarget;
import com.bluehomestudio.luckywheel.WheelItem;
import com.example.myapplication.FullScreenActivity;
import com.example.myapplication.R;
import com.example.myapplication.RouletteActivity;
import com.example.myapplication.databinding.FragmentNotificationsBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    List<WheelItem> wheelItems ;

    String point;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //점수판 데이터 생성
        this.generateWheelItems();

        //점수판 타겟 정해지면 이벤트 발생
        binding.luckWheel.setLuckyWheelReachTheTarget(new OnLuckyWheelReachTheTarget() {
            @Override
            public void onReachTarget() {

                //아이템 변수에 담기
                WheelItem wheelItem = wheelItems.get(Integer.parseInt(point)-1);

                //아이템 텍스트 변수에 담기
                String money = wheelItem.text;

                //메시지
                Toast.makeText(getContext(), money, Toast.LENGTH_SHORT).show();
            }
        });

        //시작버튼
        binding.spinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random random = new Random();
                point = String.valueOf(random.nextInt(6)+1); // 1 ~ 6
                binding.luckWheel.rotateWheelTo(Integer.parseInt(point));
            }
        });

        binding.addMenu.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RouletteActivity.class);
                startActivity(intent);

            }
        });

        return root;


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    /**
     * 데이터 담기
     */
    private void generateWheelItems() {

        wheelItems = new ArrayList<>();

        Drawable d = getResources().getDrawable(R.drawable.ic_money, null);

        Bitmap bitmap = drawableToBitmap(d);

        wheelItems.add(new WheelItem(Color.parseColor("#F44336"), bitmap, "100 $"));

        wheelItems.add(new WheelItem(Color.parseColor("#E91E63"), bitmap, "200 $"));

        wheelItems.add(new WheelItem(Color.parseColor("#9C27B0"), bitmap, "300 $"));

        wheelItems.add(new WheelItem(Color.parseColor("#3F51B5"), bitmap, "400 $"));

        wheelItems.add(new WheelItem(Color.parseColor("#1E88E5"), bitmap, "500 $"));

        wheelItems.add(new WheelItem(Color.parseColor("#009688"), bitmap, "600 $"));

        //점수판에 데이터 넣기
        binding.luckWheel.addWheelItems(wheelItems);
    }

    /**
     * drawable -> bitmap
     * @param drawable drawable
     * @return
     */
    public static Bitmap drawableToBitmap (Drawable drawable) {

        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable)drawable).getBitmap();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }

}