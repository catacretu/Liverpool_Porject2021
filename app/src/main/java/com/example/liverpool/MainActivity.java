package com.example.liverpool;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==2000 && resultCode== Activity.RESULT_OK)
        {

            if(data!=null) {
                String result=data.getStringExtra("result");
                Toast.makeText(this, "The selected menu is:"+result, Toast.LENGTH_LONG).show();

            }
        }
        else
        if(requestCode==3000&& resultCode==Activity.RESULT_OK)
        {
            if(data!=null) {
                String result=data.getStringExtra("result");
                Toast.makeText(this, "The selected menu is:"+result, Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.history).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HistoryScreen.class);
                intent.putExtra("key","History");
                startActivityForResult(intent,2000);
            }
        });
        findViewById(R.id.lineup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LineupScreen.class);
                intent.putExtra("key", "Lineup");
                startActivityForResult(intent, 3000);

            }
        });
                findViewById(R.id.video).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.youtube.com/watch?v=Y-XHMlaJL-s&fbclid=IwAR3bzvR_r3S4BXAuWYQt_d5z_f-v_UVJ3L-nz7zGHSHw0bvoRYxuZmIK23U"));
                        startActivityForResult(intent, 4000);
                    }
                });

    }
   }

