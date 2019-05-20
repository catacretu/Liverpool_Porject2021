package com.example.liverpool;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView name,position;
    ImageView img;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        name=(TextView) itemView.findViewById(R.id.name);
        position=(TextView) itemView.findViewById(R.id.position);
        img=(ImageView) itemView.findViewById(R.id.image);
    }

}
