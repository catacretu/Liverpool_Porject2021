package com.example.liverpool;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedHashMap;

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
        final LinkedHashMap<Integer, Integer> list_of_name_players
                = new LinkedHashMap<Integer, Integer>();
        //add references to image player
        initialize_list_with_references(list_of_name_players);
        PlayerApi api=getRetrofit().create(PlayerApi.class);
        Call<ArrayList<Player>> listplayers=api.getPersons("Data1");
        listplayers.enqueue(new Callback<ArrayList<Player>>() {

            @Override
            public void onResponse(Call<ArrayList<Player>> call, Response<ArrayList<Player>> response) {
                if (response.isSuccessful()) {
                   // Log.d("Response", response.body().toString());
                    ArrayList<Player> aux=response.body();

                    for(int i=0;i<aux.size();i++) {
                        playersMake.add(new Player(aux.get(i).getName(), aux.get(i).getPosition(),list_of_name_players.get(i)));

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
    public LinkedHashMap<Integer, Integer> initialize_list_with_references(LinkedHashMap<Integer,Integer> list_of_name_players)
    {
        list_of_name_players.put(0,R.drawable.mo_salah);
        list_of_name_players.put(1,R.drawable.sadio_mane);
        list_of_name_players.put(2,R.drawable.firmino);
        list_of_name_players.put(3,R.drawable.wijnaldum);
        list_of_name_players.put(4,R.drawable.keita);
        list_of_name_players.put(5,R.drawable.henderson);
        list_of_name_players.put(6,R.drawable.arnold);
        list_of_name_players.put(7,R.drawable.van_dijk);
        list_of_name_players.put(8,R.drawable.matip);
        list_of_name_players.put(9,R.drawable.robertson);
        list_of_name_players.put(10,R.drawable.alisson);
        list_of_name_players.put(11,R.drawable.origi);
        list_of_name_players.put(12,R.drawable.shaqiri);
        list_of_name_players.put(13,R.drawable.lallana);
        list_of_name_players.put(14,R.drawable.milner);
        list_of_name_players.put(15,R.drawable.fabinho);
        list_of_name_players.put(16,R.drawable.gomez);
        list_of_name_players.put(17,R.drawable.lovren);
        list_of_name_players.put(18,R.drawable.mignolet);

        return list_of_name_players;
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
