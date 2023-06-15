package com.example.jpa.hellojpa;


import com.example.jpa.domain.OrderEntity;
import com.example.jpa.domain.OrderItemEntity;
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
            // 단방향 개발
            OrderEntity order = new OrderEntity();
            entityManager.persist(order);

            OrderItemEntity orderItem = new OrderItemEntity();
            orderItem.setOrder(order);

            entityManager.persist(orderItem);

            // 양방향 개발
//            order.addOrderItem(new OrderItemEntity());


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            entityManager.close();
        }

        emf.close();
    }
}
