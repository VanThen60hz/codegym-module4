package com.codegym.dethithu.repository;

import com.codegym.dethithu.model.Area;
import com.codegym.dethithu.model.FieldType;
import com.codegym.dethithu.model.Stadium;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStadiumRepository extends JpaRepository<Stadium, Integer> {

    Stadium findByName(String name);

    Page<Stadium> findByNameContainingAndAreaAndFieldType(String name, Area area, FieldType fieldType, Pageable pageable);

    Page<Stadium> findByNameContaining(String name, Pageable pageable);

    Page<Stadium> findByNameContainingAndArea(String name, Area area, Pageable pageable);

    Page<Stadium> findByNameContainingAndFieldType(String name, FieldType fieldType, Pageable pageable);

}
