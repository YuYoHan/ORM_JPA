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

            // N +1 문제를 해결하기 위해서는 join fetch를 사용한다.
            // 연관된 데이터를 가지고 오려면 join을 해야하고
            // fetch는 한번에 가지고 온다는 것이다.
            String query = "select t From Team t join fetch t.members";

            // 여기서 List에 담기는 값은 프록시가 아니라 엔티티의 값이다.
            List<Team> resultList = entityManager.createQuery(query, Team.class).getResultList();

            for (Team team : resultList) {
                log.info("team : " + team.getName() + "\n members : " +team.getMembers().toString());
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
