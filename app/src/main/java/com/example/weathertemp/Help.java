package com.example.weathertemp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.TextureView;
import android.widget.TextView;

import java.util.Objects;

public class Help extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.white)));
        tv=findViewById(R.id.Helptv);
        tv.setText("1. You just enter city name in the Enter city name\n2. Then you get some important weather information.\n3. Thankyou ");

    }
}