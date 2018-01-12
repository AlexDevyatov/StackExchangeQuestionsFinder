package com.alexdevyatov.example.PianoTask.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Алексей on 12.01.2018.
 */
public class User {

    @SerializedName("display_name")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
