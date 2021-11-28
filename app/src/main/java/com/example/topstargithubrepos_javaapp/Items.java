package com.example.topstargithubrepos_javaapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import java.util.ArrayList;

class Owner {
    @SerializedName("avatar_url")
    @Expose
    private String avatarUrl;

    @SerializedName("login")
    @Expose
    private String username;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String newAvatarUrl) {
        this.avatarUrl = newAvatarUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String newUsername) {
        this.username = newUsername;
    }
}

class Repository {
    @SerializedName("name")
    @Expose
    private String repositoryName;

    @SerializedName("stargazers_count")
    @Expose
    private int stars;

    @SerializedName("owner")
    @Expose
    private Owner owner;

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String newRepositoryName) {
        this.repositoryName = newRepositoryName;
    }

    public int getNumOfStars() {
        return stars;
    }

    public void setNumOfStars(int stars) {
        this.stars = stars;
    }

    public String getOwnerURL() {
        return owner.getAvatarUrl();
    }

    public void setOwnerURL(String newAvatarURL) {
        this.owner.setAvatarUrl(newAvatarURL);
    }

    public String getOwnerUsername() {
        return owner.getUsername();
    }

    public void setOwnerUsername(String newUsername) {
        this.owner.setUsername(newUsername);
    }
}

public class Items {

    @SerializedName("items")
    @Expose
    private ArrayList<Repository> repositories;

    public ArrayList<Repository> getRepositories() {
        return repositories;
    }

    public void setRepositories(ArrayList<Repository> newRepositories) {
        this.repositories = newRepositories;
    }
}
