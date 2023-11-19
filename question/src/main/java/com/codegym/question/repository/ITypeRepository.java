package com.codegym.question.repository;

import com.codegym.question.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITypeRepository extends JpaRepository<Type, Integer> {

    List<Type> findAll();
}
