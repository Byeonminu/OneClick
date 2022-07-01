package com.example.myapplication.ui.dashboard;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.FullScreenActivity;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentDashboardBinding;
import com.example.myapplication.databinding.FragmentHomeBinding;
import com.example.myapplication.ui.home.Data;
import com.example.myapplication.ui.home.MyAdapter;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
//    String[] numberWord = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
//    int[] people = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four,
//            R.drawable.five,R.drawable.six, R.drawable.seven, R.drawable.eight, R.drawable.nine, R.drawable.ten};
    private ImageAdapter imageAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        imageAdapter = new ImageAdapter(getActivity());
        binding.gridView.setAdapter(imageAdapter);
        binding.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), FullScreenActivity.class);
                intent.putExtra("id", position);
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
}