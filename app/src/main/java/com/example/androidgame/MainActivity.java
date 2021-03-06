package com.example.androidgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
//Ali Mert Doganay
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start(View view) {
        Log.i("ImageButton", "Play Button Clicked");
        Intent intent = new Intent(this, GameStart.class);
        startActivity(intent);
        finish();
    }
}