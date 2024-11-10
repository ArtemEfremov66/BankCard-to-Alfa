package org.example.cards.bonusCard;

import org.example.cards.DebitCard;

public class DebitCardBonus extends DebitCard {
    private double cashback = 0;
    private final double PERCENT = 0.01;

    @Override
    public boolean pay(double amount) {
        if (super.pay(amount)) {
            cashback += amount * PERCENT;
            System.out.println("Вам начислили кешбэк! " + amount * PERCENT);
        }
        return true;
    }

    public void cashbackTransfer() {
        balance += cashback;
        cashback = 0;
        System.out.println("Кешбэк переведён. Баланс: " + balance);
    }

    public double getCashback() {
        return cashback;
    }

    @Override
    public void getInfo() {
        System.out.printf("""
                Бонусная дебетовая карта, баланс: %.2f
                Сумма кешбэка: %.2f
                Условия кешбэка: %.2f%% со всех покупок
                """, getBalance(), cashback, PERCENT * 100);
    }
}
