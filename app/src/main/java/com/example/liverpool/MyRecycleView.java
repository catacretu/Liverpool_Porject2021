package com.example.liverpool;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRecycleView extends AppCompatActivity {
    private static final String BASE_URL = "https://raw.githubusercontent.com/";
    private static Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);
        String label=getIntent().getStringExtra("key");
        Intent data=new Intent();
        data.putExtra("result",label.toString());
        setResult(Activity.RESULT_OK,data);
        final ArrayList<Player> playersMake=new ArrayList<>();
        PlayerApi api=getRetrofit().create(PlayerApi.class);
        Call<ArrayList<Player>> listplayers=api.getPersons("Data1");
        listplayers.enqueue(new Callback<ArrayList<Player>>() {

            @Override
            public void onResponse(Call<ArrayList<Player>> call, Response<ArrayList<Player>> response) {
                if (response.isSuccessful()) {
                   // Log.d("Response", response.body().toString());
                    ArrayList<Player> aux=response.body();
                    for(int i=0;i<aux.size();i++) {

                        switch (i) {
                            case 0:
                                playersMake.add(new Player(aux.get(i).getName(), aux.get(i).getPosition(),R.drawable.mo_salah));
                                break;
                            case 1:
                                playersMake.add(new Player(aux.get(i).getName(), aux.get(i).getPosition(),R.drawable.sadio_mane));
                                break;
                            case 2:
                                playersMake.add(new Player(aux.get(i).getName(), aux.get(i).getPosition(),R.drawable.firmino));
                                break;
                            case 3:
                                playersMake.add(new Player(aux.get(i).getName(), aux.get(i).getPosition(),R.drawable.alisson));
                                break;
                            case 4:
                                playersMake.add(new Player(aux.get(i).getName(), aux.get(i).getPosition(),R.drawable.van_dijk));
                                break;

                        }
                    }
                    RecyclerView rv=findViewById(R.id.rv);
                    rv.setAdapter(new MyAdapter(MyRecycleView.this,playersMake));
                    rv.setLayoutManager(new LinearLayoutManager((MyRecycleView.this)));
                } else {

                    Log.d("Response", "Response code " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Player>> call, Throwable t) {
                Log.w("Response", "Error in call", t);
            }
        });

    }
    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
