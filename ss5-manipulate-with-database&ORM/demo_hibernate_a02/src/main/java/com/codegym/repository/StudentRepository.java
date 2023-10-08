package com.codegym.repository;

import com.codegym.model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {
    @Override
    public List<Student> findAll() {
        Session session = ConnectionUtil.sessionFactory.openSession();
        // câu HQL
        TypedQuery<Student> query = session.createQuery("from Student",Student.class);
        // câu query thuần SQL
//        TypedQuery<Student> query = session.createNativeQuery("select * from student",Student.class);
        return query.getResultList();
    }

    @Override
    public boolean add(Student student) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try{
            transaction.begin();
            session.save(student);
            transaction.commit();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public Student findById(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Student> query = session.createQuery("from Student where id=:id",Student.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }
}
