package com.example.myapplication.ui.home;

import static android.app.Activity.RESULT_OK;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
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
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.AddActivity;
import com.example.myapplication.ClickActivity;
import com.example.myapplication.FullScreenActivity;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentHomeBinding;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {


    private FragmentHomeBinding binding;
    private ListView listView;
    public ArrayList<Data> SampleData;
    private MyAdapter myAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

//        this.InitializeMovieData();
        SampleData = new ArrayList<Data>();


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        //root:
        View root = binding.getRoot();


        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Data data = myAdapter.getItem(position);
                //Toast.makeText(getContext(), data.getName() + " " + data.getPhone(), Toast.LENGTH_LONG).show();
                Intent intent4=new Intent(getActivity(), ClickActivity.class);
                intent4.putExtra("position",position);
                intent4.putParcelableArrayListExtra("sampleData",SampleData);
                startActivity(intent4);

//              String tel="tel:"+data.getPhone();
//              startActivity(new Intent("android.intent.action.DIAL", Uri.parse(tel)));
            }
        });
        binding.synBtn.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), AddActivity.class);
//                startActivity(intent);

//                Intent intent = new Intent(Intent.ACTION_PICK);
//                intent.setData(ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
//                //호출 후, 연락처앱에서 전달되는 결과물을 받기 위해 startActivityForResult로 실행한다.
//                getActivity().startActivityForResult(intent, 10);
//                SampleData = getSampleData();
                SampleData = new ArrayList<Data>();
                SampleData = getSampleData();
                Toast.makeText(getActivity(), "연락처 가져오기", Toast.LENGTH_SHORT).show();
                myAdapter = new MyAdapter(getActivity(), SampleData);
                binding.listView.setAdapter(myAdapter);
                binding.listView.setBackgroundColor(Color.WHITE);


            }

        });

        binding.addBtn.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_INSERT, Uri.parse("content://contacts/people"));
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
        SampleData = new ArrayList<Data>();

        SampleData.add(new Data("강해상","010-4616-7253"));
        SampleData.add(new Data("구씨","010-1772-5167"));
        SampleData.add(new Data("유재석","010-5342-2421"));
        SampleData.add(new Data("김태형","010-2943-3915"));
        SampleData.add(new Data("전정국","010-9513-3563"));
        SampleData.add(new Data("민윤기","010-6243-5915"));
        SampleData.add(new Data("김남준", "010-2143-6813"));
        SampleData.add(new Data("지민","010-2942-6235"));
        SampleData.add(new Data("진","010-3532-7343"));
        SampleData.add(new Data("제이홉","010-6212-5531"));

        //JSONObject obj=new JSONObject();

    }

    public ArrayList<Data> getSampleData() {
        ArrayList<Data> datas = new ArrayList<Data>();
        ContentResolver resolver = getActivity().getContentResolver();
        Uri phoneUri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String[] projection = { ContactsContract.CommonDataKinds.Phone.CONTACT_ID
                ,  ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                ,  ContactsContract.CommonDataKinds.Phone.NUMBER};
        String[] selectionArgs =null;
        String sortOrder = ContactsContract.Contacts.DISPLAY_NAME + " COLLATE LOCALIZED ASC";

        Cursor cursor = resolver.query(phoneUri, projection, null, selectionArgs, sortOrder);




        if(cursor.moveToFirst()){
            do{
                Data one = new Data(cursor.getString(1), cursor.getString(2));
                datas.add(one);

            }while(cursor.moveToNext());
        }

        cursor.close();

        return datas;
    }


}
