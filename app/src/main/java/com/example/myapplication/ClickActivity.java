package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.myapplication.ui.home.Data;
import com.example.myapplication.ui.home.MyAdapter;

import java.util.ArrayList;

public class ClickActivity extends Activity {
    TextView showName, showPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.click_row);

        showName=(TextView)findViewById(R.id.show_name);
        showPhone=(TextView)findViewById(R.id.show_phone);

        Intent i=getIntent();
        int position=i.getExtras().getInt("position");
        ArrayList<Data> sampleData=getIntent().getParcelableArrayListExtra("sampleData");
        //ArrayList<Data> sampledata=(ArrayList<Data>)sampleData;
        MyAdapter myadapter=new MyAdapter(this,sampleData);
        String find_name= sampleData.get(position).getName();
        String find_phone=sampleData.get(position).getPhone();


        showName.setText(find_name);
        showPhone.setText(find_phone);

        Button callBtn=(Button) findViewById(R.id.call_btn);
        Button messageBtn=(Button) findViewById(R.id.message_btn);

        callBtn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
//              String name=addNameEdit.getText().toString();
//              String phone=addPhoneEdit.getText().toString();

                String tel="tel:"+find_phone;
                startActivity(new Intent("android.intent.action.DIAL", Uri.parse(tel)));

//              Intent intent2 = new Intent(AddActivity.this, MainActivity.class);
//              startActivity(intent2);
            }
        });

        messageBtn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
//                String name=addNameEdit.getText().toString();
//                String phone=addPhoneEdit.getText().toString();

                /*HomeFragment data=new HomeFragment();
                data.SampleData.add(new Data(name,phone));*/
                String tel="smsto:"+find_phone;
                //startActivity(new Intent("android.intent.action.DIAL", Uri.parse(tel)));
                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address", find_phone);
                //smsIntent.putExtra("sms_body","Body of Message");
                startActivity(smsIntent);



//              Intent intent2 = new Intent(AddActivity.this, MainActivity.class);
//              startActivity(intent2);

            }
        });
    }

}
