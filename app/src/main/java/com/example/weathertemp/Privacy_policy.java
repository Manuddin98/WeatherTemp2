package com.example.weathertemp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Privacy_policy extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);
        getSupportActionBar().hide();
        tv=findViewById(R.id.Privacytv);
        tv.setText("\n\n\nIn this app anybody no need to enter privacy data \n\nso there is no fear of thief data\n\nthat why this app is 100 percentage secure");
    }
}