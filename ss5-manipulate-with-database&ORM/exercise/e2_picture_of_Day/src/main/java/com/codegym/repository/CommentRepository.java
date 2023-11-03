package com.codegym.repository;


import com.codegym.model.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class CommentRepository {
//    @Autowired
//    private static SessionFactory sessionFactory;

    public void updateLike(int id) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConfig.sessionFactory.openSession();
            transaction = session.beginTransaction();
            Comment comment = findOne(id);
            session.refresh(comment);
            int liked = comment.getLiked() + 1;

            Query query = session.createSQLQuery("update comment set liked = :liked where id=:id")
                    .setParameter("liked", liked)
                    .setParameter("id", id);
            query.executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    public Comment findOne(int id) {
        String queryStr = "SELECT c FROM Comment AS c WHERE c.id = :id";
        TypedQuery<Comment> query = HibernateConfig.entityManager.createQuery(queryStr, Comment.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public void save(Comment comment) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConfig.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.persist(comment);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}