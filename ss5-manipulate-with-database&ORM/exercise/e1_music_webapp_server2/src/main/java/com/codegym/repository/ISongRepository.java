package com.codegym.repository;

import com.codegym.model.Song;

import java.util.List;

public interface ISongRepository {
    List<Song> findAll();
    Song add(Song song);
    Song findById(int id);
}
