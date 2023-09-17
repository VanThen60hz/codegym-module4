package com.codegym.service;

import com.codegym.model.Student;
import com.codegym.repository.IStudentRepository;
import com.codegym.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public class StudentService implements IStudentService {
    // DI interface
    @Autowired
    private IStudentRepository studentRepository ;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
