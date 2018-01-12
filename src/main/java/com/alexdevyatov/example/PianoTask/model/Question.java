package com.alexdevyatov.example.PianoTask.model;


import com.google.gson.annotations.SerializedName;

/**
 * Created by Алексей on 12.01.2018.
 */
public class Question {

    @SerializedName("owner")
    private User user;
    private String title;
    @SerializedName("creation_date")
    private Long date;
    @SerializedName("is_answered")
    private Boolean isAnswered;
    private String link;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Boolean getAnswered() {
        return isAnswered;
    }

    public void setAnswered(Boolean answered) {
        isAnswered = answered;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
