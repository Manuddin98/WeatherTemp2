package com.example.weathertemp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.ReferenceQueue;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {
    EditText et;
    TextView tv,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tvshow,rise,set;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.purple_500)));
        et=findViewById(R.id.et);
        tv=findViewById(R.id.tv);
        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);
        tv4=findViewById(R.id.tv4);
        tv5=findViewById(R.id.tv5);
        tv6=findViewById(R.id.tv6);
        tv7=findViewById(R.id.tv7);
        tv8=findViewById(R.id.tv8);
        tvshow=findViewById(R.id.tvshow);
        rise=findViewById(R.id.sunrise);
        set=findViewById(R.id.sunset);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.About){
            Intent intent=new Intent(MainActivity.this,About_App.class);
            startActivity(intent);
        return true;}
        if(id==R.id.Help){
            Intent intent=new Intent(MainActivity.this,Help.class);
            startActivity(intent);
            return true;}

        if(id==R.id.Privacy){
            Intent intent=new Intent(MainActivity.this,Privacy_policy.class);
            startActivity(intent);
            return true;}

        if(id==R.id.Contact){
            Intent intent=new Intent(MainActivity.this,Contact.class);
            startActivity(intent);
            return true;}

        if(id==R.id.Future){
            Intent intent=new Intent(MainActivity.this,Future_policy.class);
            startActivity(intent);
            return true;}

        if(id==R.id.Condition){
            Intent intent=new Intent(MainActivity.this,Term_condition.class);
            startActivity(intent);
            return true;}

        return super.onOptionsItemSelected(item);


    }

    public void get(View v){
        String apikey="88d636e8bcc0fa713e0ce7de5aa659d0\n";
        String city=et.getText().toString();
        String url="https://api.openweathermap.org/data/2.5/weather?q="+city+"&units=metric&appid=88d636e8bcc0fa713e0ce7de5aa659d0";
        //api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
       // https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=88d636e8bcc0fa713e0ce7de5aa659d0
        RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject object=response.getJSONObject("main");
                    String temperature=object.getString("temp");
                   // Double temp=Double.parseDouble(temperature)-273.15;



                   JSONObject object1=response.getJSONObject("wind");
                   JSONObject object2=response.getJSONObject("sys");
                 //  String wind=object1.getString("sunrise");
                   String tempmin=object.getString("temp_min");
                    String tempmax=object.getString("temp_max");
                    String pressure=object.getString("pressure");
                    String humidity=object.getString("humidity");

                    String speed=object1.getString("speed");
                    Double speed2=Double.parseDouble(speed)*3.6;
                    Long sunrise=object2.getLong("sunrise");
                    Long sunset=object2.getLong("sunset");
                   // SimpleDateFormat simpleDateFormat=new SimpleDateFormat("hh:mm a",Locale.ENGLISH);
                  //  String sunrise2=simpleDateFormat.format(sunrise);

                    tv.setText(temperature+" °c");
                   // tv.setText("Temperature"+temp.toString().substring(0,5)+"c");
                   tv2.setText("Temp min\n "+tempmin+" °c");
                   tv3.setText("Temp max\n "+tempmax+" °c");
                   tv4.setText("Pressure \n"+pressure+" hpa");
                   tv5.setText("Humadity \n"+humidity+"%");
                    tv6.setText("Wind speed\n "+speed2.toString().substring(0,5)+" km/h");
                    tv7.setText (new SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(new Date(sunrise * 1000)));
                   tv8.setText (new SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(new Date(sunset * 1000)));
                   tvshow.setText("Temperature");
                   set.setText("Sunset");
                   rise.setText("Sunrise");






                    // tv7.setText("sunrise"+sunrise2);
                   //tv6.setText(speed);

                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), "Please Enter Valid City", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(request);




    }

}