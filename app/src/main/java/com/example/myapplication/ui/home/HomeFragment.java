package com.example.myapplication.ui.home;

import static android.content.Context.MODE_PRIVATE;

import android.Manifest;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.AddActivity;
import com.example.myapplication.FullScreenActivity;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentHomeBinding;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {


    private FragmentHomeBinding binding;
    private ListView listView;
    private ArrayList<Data> SampleData2;
    private MyAdapter myAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //this.InitializeMovieData();
        MainActivity act=(MainActivity) getActivity();
        SampleData2=act.getMyData();
        int myLen = act.getMyData().size();

        Log.v("home fragment size", String.valueOf(myLen));
        Log.v("home fragment my data", act.getMyData().get(myLen - 1).getName());


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        //root:
        View root = binding.getRoot();



        String get_name, get_phone;
        Bundle extra=this.getArguments();
        if (extra!=null){
            extra=getArguments();
            get_name=extra.getString("name");
            get_phone=extra.getString("phone");

            Toast.makeText(getActivity(),get_name+":"+get_phone, Toast.LENGTH_LONG).show();
        }

        myAdapter = new MyAdapter(getActivity(), SampleData2);
        //myAdapter.notifyDataSetChanged();
        Log.v("my adapter len", String.valueOf(myAdapter.getCount()));
        binding.listView.setAdapter(myAdapter);
        binding.listView.setBackgroundColor(Color.WHITE);
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Data data = myAdapter.getItem(position);
                Toast.makeText(getContext(), data.getName() + " " + data.getPhone(), Toast.LENGTH_LONG).show();

            }
        });

        binding.addBtn.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddActivity.class);
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

    public void InitializeMovieData()
    {
        /*SampleData = new ArrayList<Data>();

        SampleData.add(new Data("강해상","010-4616-7253"));
        SampleData.add(new Data("구씨","010-1772-5167"));
        SampleData.add(new Data("유재석","010-5342-2421"));
        SampleData.add(new Data("김태형","010-2943-3915"));
        SampleData.add(new Data("전정국","010-9513-3563"));
        SampleData.add(new Data("민윤기","010-6243-5915"));
        SampleData.add(new Data("김남준","010-2143-6813"));
        SampleData.add(new Data("지민","010-2942-6235"));
        SampleData.add(new Data("진","010-3532-7343"));
        SampleData.add(new Data("제이홉","010-6212-5531"));*/

        //JSONObject obj=new JSONObject();


    }
}
