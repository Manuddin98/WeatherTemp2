package com.example.weathertemp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Term_condition extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_condition);
        getSupportActionBar().hide();
        tv=findViewById(R.id.Termtv);
        tv.setText("\n\n\nIn this app nobody need to pay any charge \n\nthis aap is fully free\n\nSo its term and condition is very easy");
    }
}