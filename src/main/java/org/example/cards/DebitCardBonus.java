package org.example.cards;

public class DebitCardBonus extends DebitCard {
    private double cashback = 0;

    @Override
    public boolean pay(double amount) {
        if (super.pay(amount)) {
            cashback += amount * 0.01;
            System.out.println("Вам начислили кешбэк! " + amount * 0.01);
        }
        return true;
    }

    public void cashbackTransfer () {
        balance += cashback;
        cashback = 0;
        System.out.println("Кешбэк переведён. Баланс: " + balance);
    }
    public double getCashback() {
        return cashback;
    }

    @Override
    public void getInfo() {
        System.out.println("Бонусная дебетовая карта, баланс: " + getBalance() + "\n" +
                "Сумма кешбэка: " + cashback + "\nУсловия кешбэка: 1% со всех покупок");
    }
}
