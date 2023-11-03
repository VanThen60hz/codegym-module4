package com.codegym.repository;

import com.codegym.model.Picture;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.Optional;

public class PictureRepository {
    public Optional<Picture> find(LocalDate localDate){
        EntityManager entityManager = HibernateConfig.sessionFactory.createEntityManager();

        String queryStr = "SELECT p FROM Picture AS p WHERE p.displayDate = :dateNow";
        TypedQuery<Picture> query = entityManager.createQuery(queryStr, Picture.class);
        query.setParameter("dateNow", localDate);
        return query.getResultList().stream().findFirst();
    }
}
