package com.example.barry.friendsr;

import java.io.Serializable;

public class Friend implements Serializable {
    private String name, bio;
    private int drawable;

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public int getDrawable() {
        return drawable;
    }

    public Friend(String name, String bio, int drawable) {
        this.name = name;
        this.bio = bio;
        this.drawable = drawable;
    }
}
