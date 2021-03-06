package com.example.insky.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {
    int user = 3;
    int saver = 5;
    public String SleepTime;
    public String CountTime;
    public String Relation;
    public String Number;
    public static long hourToMinute;
    TextView Saver_text;
    TextView SleepTime_text;
    TextView CountTime_text;
    TextView Saver_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Saver_text = (TextView)findViewById(R.id.inputSaver);
        Saver_number = (TextView)findViewById(R.id.saverNumber);
        SleepTime_text = (TextView)findViewById(R.id.sleepValue);
        CountTime_text = (TextView)findViewById(R.id.countValue);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK) {
            if (requestCode == user) {
                SleepTime = data.getStringExtra("SleepTime");
                SleepTime_text.setText(SleepTime);
                CountTime = data.getStringExtra("CountTime");
                CountTime_text.setText(String.valueOf(hourToMinute));


            }
            else if ( requestCode == saver) {
                Relation = data.getStringExtra("saver");
                Saver_text.setText(Relation);
                Number = data.getStringExtra("number");
                Saver_number.setText(Number);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.userinfo : {
                Intent intent = new Intent(this, UserinfoActivity.class);
                startActivityForResult(intent, user);
                Log.v("Button", "userInfo");
                break;
            }
            case R.id.saverinfo : {
                Intent intent = new Intent(this, SaverinfoActivity.class);
                startActivityForResult(intent, saver);
                Log.v("Button", "saverinfo");
                break;
            }
        }
    }
}
