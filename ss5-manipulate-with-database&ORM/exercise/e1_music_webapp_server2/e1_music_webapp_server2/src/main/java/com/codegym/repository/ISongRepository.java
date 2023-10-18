package com.codegym.repository;

import com.codegym.model.Song;

import java.util.List;

public interface ISongRepository {
    List<Song> findAll();
    Song save(Song song);
    Song findById(int id);

    boolean delete(Song song);
}
