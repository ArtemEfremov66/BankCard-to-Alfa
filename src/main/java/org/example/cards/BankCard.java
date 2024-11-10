package org.example.cards;

public abstract class BankCard {
    public double balance = 0;

    public BankCard() {
    }

    public abstract boolean add(double amount);

    public abstract boolean pay(double amount);

    public abstract void getInfo();

    public abstract double getBalance();
}
