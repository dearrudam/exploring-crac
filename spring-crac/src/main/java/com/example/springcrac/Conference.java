package com.example.springcrac;

import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Conference {

    @Autowired
    EntityManager em;

    @Transactional(readOnly = true)
    List<Attendee> findAll() {


        EntityGraph<Attendee> entityGraph = em.createEntityGraph(Attendee.class);
        entityGraph.addAttributeNodes("technologies");

        TypedQuery<Attendee> query = em.createQuery("select a from Attendee a", Attendee.class);

        query.setHint("jakarta.persistence.loadgraph", entityGraph);

        return query.getResultList();
    }

}
