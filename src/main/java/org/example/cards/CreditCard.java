package org.example.cards;

public class CreditCard extends BankCard {
    private final DebitCard debitCard;
    private final double creditLimit;

    public CreditCard(double creditLimit, DebitCard debitCard) {
        super();
        this.debitCard = debitCard;
        this.creditLimit = -creditLimit;
    }

    @Override
    public boolean add(double amount) {
        if (amount > 0) {
            debitCard.balance += amount;
            System.out.println("Баланс кредитной карты пополнен");
            return true;
        } else {
            System.out.println("Некорректная сумма");
            return false;
        }
    }

    @Override
    public boolean pay(double amount) {
        if ((creditLimit <= debitCard.balance - amount) && (amount > 0)) {
            debitCard.balance -= amount;
            System.out.println("Оплата с кредитной карты произведена");
            return true;
        } else {
            System.out.println("Некорректная сумма");
            return false;
        }
    }

    @Override
    public double getBalance() {
        if (debitCard.balance >= 0) {
            return -creditLimit;
        }
        return -creditLimit + debitCard.balance;
    }

    @Override
    public void getInfo() {
        System.out.println("Кредитная карта с лимитом: " + creditLimit + "\nТекущий баланс: "+ getBalance()
        + "На дебетовой карте: " + debitCard.getBalance());
    }


}
