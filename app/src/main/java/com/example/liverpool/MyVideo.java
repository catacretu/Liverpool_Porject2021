package com.example.liverpool;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MyVideo extends AppCompatActivity{
    /*@Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);*/
    MyVideo() {
        //preluam numele butonului
        String label = getIntent().getStringExtra("key");
        Intent data = new Intent();
        data.putExtra("result", label.toString());
        setResult(Activity.RESULT_OK, data);
        //accesam adresa de youtube
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.youtube.com/watch?v=Y-XHMlaJL-s&fbclid=IwAR3bzvR_r3S4BXAuWYQt_d5z_f-v_UVJ3L-nz7zGHSHw0bvoRYxuZmIK23U"));
        intent.putExtra("key", "Video");
        startActivityForResult(intent, 3000);
    }
}
