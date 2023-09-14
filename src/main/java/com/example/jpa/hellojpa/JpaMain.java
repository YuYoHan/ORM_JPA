package com.example.jpa.hellojpa;


import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@Slf4j
public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = emf.createEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        try {
            Member member =  new Member();
            member.setUserName("관리자1");

            Member member1 = new Member();
            member1.setUserName("관리자2");
            entityManager.persist(member1);

            entityManager.flush();
            entityManager.clear();

            String query = "select m.team From Member m";

            List<Team> resultList = entityManager.createQuery(query, Team.class).getResultList();

            for (Team s : resultList) {
                System.out.println("s : " + s);
        }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            entityManager.close();
        }
        emf.close();
    }
}
