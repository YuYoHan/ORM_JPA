package com.example.jpa.hellojpa;

public class ValueMain {
    public static void main(String[] args) {

        int a = 10;
        int b = a;

        a = 20;

        System.out.println("a = " + a); // 20
        System.out.println("b = " + b); // 10 → 10인 이유 처음에 a 값을 복사하고 별개의 공간을 가지고 있기 때문에 20이 적용 안됨


    }
}
