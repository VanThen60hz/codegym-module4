package com.codegym.model;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String singer;
    private String type;
    @Column(nullable = true, length = 64)
    private String songs;

    public Song() {
    }

    public Song(int id, String name, String singer, String type, String songs) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.type = type;
        this.songs = songs;
    }

    @Transient
    public String getSongPath() {
        if (songs == null) return null;

        return "song-songs" + id + "/" + songs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSongs() {
        return songs;
    }

    public void setSongs(String songs) {
        this.songs = songs;
    }
}
