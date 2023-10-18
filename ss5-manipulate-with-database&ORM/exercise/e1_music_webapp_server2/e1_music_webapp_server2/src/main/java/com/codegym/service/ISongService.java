package com.codegym.service;

import com.codegym.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    Song save(Song Song);
    Song findById(int id);
    boolean delete(Song song);
}
