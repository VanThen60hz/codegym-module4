package com.codegym.repository;

import com.codegym.model.Song;
import com.codegym.util.ConnectionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class SongRepository implements ISongRepository {
    @Override
    public List<Song> findAll() {
        Session session = ConnectionUtil.sessionFactory.openSession();
        // câu HQL
        TypedQuery<Song> query = session.createQuery("from Song", Song.class);
        // câu query thuần SQL
//        TypedQuery<Song> query = session.createNativeQuery("select * from Song",Song.class);
        return query.getResultList();
    }

    @Override
    public Song add(Song song) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.save(song);
            transaction.commit();
            return song;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Song findById(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Song> query = session.createQuery("from Song where id=:id", Song.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }


}
