package com.example.weathertemp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Contact extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        getSupportActionBar().hide();
        tv=findViewById(R.id.Contacttv);
        tv.setText("\n\n\n\n    Name= Manuddin\n\n  Mobile no.=7217766456\n\n   Email id=manuddinkhan98@gmail.com\n\n   Profession=Android app developer");
    }
}