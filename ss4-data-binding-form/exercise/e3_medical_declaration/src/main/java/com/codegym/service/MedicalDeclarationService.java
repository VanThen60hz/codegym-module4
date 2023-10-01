package com.codegym.service;

import com.codegym.model.MedicalDeclaration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MedicalDeclarationService {
    private final List<MedicalDeclaration> medicalDeclarations = new ArrayList<>();

    public List<MedicalDeclaration> findAll() {
        return medicalDeclarations;
    }

    public void save(MedicalDeclaration medicalDeclaration) {
        medicalDeclarations.add(medicalDeclaration);
    }

    public Optional<MedicalDeclaration> findById(int id) {
        return medicalDeclarations.stream().filter(e -> e.getId() == id).findFirst();
    }
}
