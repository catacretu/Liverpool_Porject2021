package com.example.liverpool;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class HistoryScreen extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_screen);
        String label = getIntent().getStringExtra("key");
        Intent data = new Intent();
        data.putExtra("result", label.toString());
        setResult(Activity.RESULT_OK, data);
    }
}
