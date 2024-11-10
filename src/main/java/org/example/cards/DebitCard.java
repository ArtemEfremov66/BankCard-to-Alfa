package org.example.cards;

public class DebitCard extends BankCard {

    @Override
    public boolean add(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Баланс дебетовой карты пополнен на %.2f\n", amount);
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
            System.out.printf("Оплата на %.2f с дебетовой карты произведена\n", amount);
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
