package com.example.spotifytutorialtrialrun;

public class Song {
    private String name;
    private String imageUrl;

    //this one is needed bc firebase requires that we have one w no constructors
    public Song() {
    }
    public Song(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}