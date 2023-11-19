package com.codegym.question.service.impl;

import com.codegym.question.model.Type;
import com.codegym.question.repository.ITypeRepository;
import com.codegym.question.service.ITypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService implements ITypeService {

    private final ITypeRepository typeRepository;

    public TypeService(ITypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public Optional<Type> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(Type type) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Type> findAll() {
        return typeRepository.findAll();
    }
}
