package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.ui.home.Data;
import com.example.myapplication.ui.home.HomeFragment;

public class AddActivity extends Activity {
    EditText addNameEdit, addPhoneEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        addNameEdit=(EditText)findViewById(R.id.add_name_edit);
        addPhoneEdit=(EditText)findViewById(R.id.add_phone_edit);

        addPhoneEdit.addTextChangedListener(new PhoneNumberFormattingTextWatcher());

        Button addBtn=(Button) findViewById(R.id.click_btn);
        addBtn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                String name=addNameEdit.getText().toString();
                String phone=addPhoneEdit.getText().toString();

                /*HomeFragment data=new HomeFragment();
                data.SampleData.add(new Data(name,phone));
*/
                Intent intent2 = new Intent(AddActivity.this, MainActivity.class);
                startActivity(intent2);

            }

        });
    }
}
