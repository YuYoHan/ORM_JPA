package com.example.jpa;

import com.example.jpa.domain.MemberEntity;
import com.example.jpa.domain.OrderEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@SpringBootApplication
public class JpaApplication {
    public static void main(String[] args) {

        SpringApplication.run(JpaApplication.class, args);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = emf.createEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        try {

            OrderEntity orderEntity = entityManager.find(OrderEntity.class, 1L);

            MemberEntity findMember = orderEntity.getMember();


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            entityManager.close();
        }

        emf.close();
    }
    }

