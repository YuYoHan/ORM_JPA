package com.example.jpa.hellojpa;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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

            // 조회
            Member findMember = entityManager.find(Member.class, member.getId());
            Team findTeam = findMember.getTeam();

            System.out.println("findTam : " + findTeam.getName());



            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            entityManager.close();
        }

        emf.close();
    }
}
