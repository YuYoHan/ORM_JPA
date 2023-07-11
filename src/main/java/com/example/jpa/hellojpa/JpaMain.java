package com.example.jpa.hellojpa;


import com.example.jpa.domain.OrderEntity;
import com.example.jpa.domain.OrderItemEntity;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = emf.createEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        try {
            Address address = new Address("city", "street", "10000");

            Member member = new Member();
            member.setUserName("member1");
            member.setHomeAddress(address);
            entityManager.persist(member);

            // 불변에서 값을 바꾸러면 다시 만들어줘야 한다.
            Address newAddress = new Address("NewCity", address.getStreet(), address.getZipcode());
            member.setHomeAddress(newAddress);


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            entityManager.close();
        }
        emf.close();
    }
}
