package org.example.cards;

public class DebitCard extends BankCard {

    @Override
    public boolean add(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Баланс дебетовой карты пополнен");
            return true;
        } else {
            System.out.println("Некорректная сумма");
            return false;
        }
    }

    @Override
    public boolean pay(double amount) {
        if ((balance - amount) >= 0 && amount > 0) {
            balance -= amount;
            System.out.println("Оплата с дебетовой карты произведена");
            return true;
        } else {
            System.out.println("Некорректная сумма");
            return false;
        }
    }

    @Override
    public double getBalance() {
        if (balance > 0) {
            return balance;
        }
        return 0;
    }

    @Override
    public void getInfo() {
        System.out.println("Дебетовая карта, баланс: " + getBalance());
    }
}
