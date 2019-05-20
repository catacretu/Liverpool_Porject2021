package com.example.liverpool;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context c;
    ArrayList<Player> players;

    public MyAdapter(Context c, ArrayList<Player> players) {
        this.c = c;
        this.players=players;
    }
    //view item
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(c).inflate(R.layout.card_view,viewGroup,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        //jucatorul curent
        Player p=players.get(i);
        //interconectam datele
        myViewHolder.name.setText(p.getName());
        myViewHolder.position.setText(p.getPosition());
        myViewHolder.img.setImageResource(p.getImage());
    }
    //nr total de jucatori
    @Override
    public int getItemCount() {
        return players.size();
    }
}
