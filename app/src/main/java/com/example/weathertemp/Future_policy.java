package com.example.weathertemp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Future_policy extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future_policy);
        getSupportActionBar().hide();
        tv=findViewById(R.id.Futuretv);
        tv.setText("\n\n\nThis is very brilliant app \n\nThis app easy to use\n\nSome Advance version of this app is coming soon\n\nThese version of this app will be more attractive");
    }
}