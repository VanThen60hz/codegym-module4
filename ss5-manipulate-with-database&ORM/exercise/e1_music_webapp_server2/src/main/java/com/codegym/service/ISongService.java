package com.codegym.service;

import com.codegym.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    Song add(Song Song);
    Song findById(int id);
}
