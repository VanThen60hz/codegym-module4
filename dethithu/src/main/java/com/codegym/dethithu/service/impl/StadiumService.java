package com.codegym.dethithu.service.impl;

import com.codegym.dethithu.model.Area;
import com.codegym.dethithu.model.FieldType;
import com.codegym.dethithu.model.Stadium;
import com.codegym.dethithu.repository.IStadiumRepository;
import com.codegym.dethithu.service.IStadiumService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StadiumService implements IStadiumService {
    private final IStadiumRepository stadiumRepository;

    public StadiumService(IStadiumRepository stadiumRepository) {
        this.stadiumRepository = stadiumRepository;
    }


    @Override
    public Iterable<Stadium> findAll() {
        return stadiumRepository.findAll();
    }

    @Override
    public Optional<Stadium> findById(int id) {
        return stadiumRepository.findById(id);
    }

    @Override
    public void save(Stadium stadium) {
        stadiumRepository.save(stadium);
    }

    @Override
    public void remove(int id) {
        stadiumRepository.deleteById(id);
    }

    @Override
    public boolean isStadiumNameUnique(String name) {
        Stadium existingStadium = stadiumRepository.findByName(name);
        return existingStadium == null;
    }

//    @Override
//    public Stadium findByName(String name) {
//        return null;
//    }

    @Override
    public Page<Stadium> findByNameContainingAndAreaAndFieldType(String name, Area area, FieldType fieldType, Pageable pageable) {
        return stadiumRepository.findByNameContainingAndAreaAndFieldType(name, area, fieldType, pageable);
    }

    @Override
    public Page<Stadium> findByNameContaining(String name, Pageable pageable) {
        return stadiumRepository.findByNameContaining(name, pageable);
    }

    @Override
    public Page<Stadium> findByNameContainingAndArea(String name, Area area, Pageable pageable) {
        return stadiumRepository.findByNameContainingAndArea(name, area, pageable);
    }


    @Override
    public Page<Stadium> findByNameContainingAndFieldType(String name, FieldType fieldType, Pageable pageable) {
        return stadiumRepository.findByNameContainingAndFieldType(name, fieldType, pageable);
    }

    ;


}
