package com.example.liverpool;

import com.google.gson.annotations.SerializedName;

public class Player {
    @SerializedName("name")
    private String name;
    @SerializedName("position")
    private String position;
    int image;

    public Player(String name, String position,int image) {
        this.name = name;
        this.position = position;
        this.image=image;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
