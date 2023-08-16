package com.example.jpa.JPQL;


import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.List;

@Slf4j
public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = emf.createEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member = Member.builder()
                    .userName("member1")
                    .build();

            entityManager.persist(member);

            TypedQuery<Member> query =
                    entityManager.createQuery("select m from Member m where m.userName = :userName", Member.class);
            query.setParameter("userName", "member1");

            Member singleResult = query.getSingleResult();
            System.out.println(singleResult);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            entityManager.close();
        }
        emf.close();
    }
}
