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

            Team team = new Team();
            team.setName("TeamA");
            entityManager.persist(team);

            Member member =new Member();
            member.setUserName("member1");
            member.setTeam(team);
            entityManager.persist(member);

            entityManager.flush();
            entityManager.clear();

            Member findMember = entityManager.find(Member.class, member.getId());
            List<Member> members = findMember.getTeam().getMembers();

            for (Member m: members
                 ) {
                log.info("m = " + m.getUserName());
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
