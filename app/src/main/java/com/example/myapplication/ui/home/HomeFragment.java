package com.example.myapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {


    private FragmentHomeBinding binding;
    private ListView listView;
    private ArrayList<Data> SampleData;
    private MyAdapter myAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//
//        this.InitializeMovieData();
//
////        HomeViewModel homeViewModel =
////                new ViewModelProvider(this).get(HomeViewModel.class);
//
//        binding = FragmentHomeBinding.inflate(inflater, container, false);
//
//
////        listView = (ListView) getView().findViewById(R.id.listview);
//
//        myAdapter = new MyAdapter(getActivity(), SampleData);
//        binding.listView.setAdapter(myAdapter);
////        listView.setAdapter(myAdapter);
////        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
////            @Override
////            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
////
////            }
////        });
//        View root = binding.getRoot();
//
//        return root;

        this.InitializeMovieData();

//        HomeViewModel homeViewModel =
//                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        myAdapter = new MyAdapter(getActivity(), SampleData);
        binding.listView.setAdapter(myAdapter);

        return root;
    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void InitializeMovieData()
    {
        SampleData = new ArrayList<Data>();

        SampleData.add(new Data("미션임파서블","010-1234-1234"));
        SampleData.add(new Data("아저씨","010-5342-2421"));
        SampleData.add(new Data("어벤져스","010-2943-3915"));
    }
}
