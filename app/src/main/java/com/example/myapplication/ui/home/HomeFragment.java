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

        this.InitializeMovieData();

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        myAdapter = new MyAdapter(getActivity(), SampleData);
        binding.listView.setAdapter(myAdapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void InitializeMovieData()
    {
        SampleData = new ArrayList<Data>();

        SampleData.add(new Data("홍길동","010-1234-1234"));
        SampleData.add(new Data("유재석","010-5342-2421"));
        SampleData.add(new Data("김태형","010-2943-3915"));
        SampleData.add(new Data("전정국","010-9513-3563"));
        SampleData.add(new Data("민윤기","010-6243-5915"));
        SampleData.add(new Data("김남준","010-2143-6813"));
        SampleData.add(new Data("지민","010-2942-6235"));
        SampleData.add(new Data("진","010-3532-7343"));

    }
}
