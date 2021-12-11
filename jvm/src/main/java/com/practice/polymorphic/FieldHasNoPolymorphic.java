package com.practice.polymorphic;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/11/22 4:09 下午
 */
public class FieldHasNoPolymorphic {

    static class Father {
        public int money = 1;

        public Father() {
            money = 2;
            showMeTheMoney();
        }

        public void showMeTheMoney() {
            System.out.println("I am Father, i have $" + money);
        }
    }

    static class Son extends Father {
        public int money = 3;

        public Son() {
            money = 4;
            showMeTheMoney();
        }

        @Override
        public void showMeTheMoney() {
            System.out.println("I am Son, i have $" + money);
        }
    }

    public static void main(String[] args) {
        Father gay = new Son();
        System.out.println("This gay has $" + gay.money);
        // I am Son, i have $0
        // I am Son, i have $4
        // This gay has $2

//        Son son = new Son();
//        System.out.println("This gay has $" + son.money);
        // I am Son, i have $0
        // I am Son, i have $4
        // This gay has $4
    }

}
