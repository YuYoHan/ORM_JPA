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

            TypedQuery<Member> query = entityManager.createQuery("select m from Member m", Member.class);
            Query query2 = entityManager.createQuery("select m.userName, m.age from Member m", Member.class);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            entityManager.close();
        }
        emf.close();
    }
}
