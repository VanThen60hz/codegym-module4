package com.codegym.service;

import com.codegym.model.Song;
import com.codegym.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {

    @Autowired
    private ISongRepository songRepository;

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Song add(Song song) {
        return songRepository.add(song);
    }

    @Override
    public Song findById(int id) {
        return songRepository.findById(id);
    }
}
