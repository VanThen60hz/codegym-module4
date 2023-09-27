package com.codegym.reposiotry;

import com.codegym.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {
    private  static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1,"Chánh",1));
        studentList.add(new Student(2,"Hùng",1));
        studentList.add(new Student(3,"Khang",1));
    }
    @Override
    public List<Student> findAll() {
        return studentList;
    }
}
