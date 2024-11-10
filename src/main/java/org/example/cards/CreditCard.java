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
            System.out.printf("Баланс кредитной карты пополнен на %.2f\n", amount);
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
            System.out.printf("Оплата на %.2f с кредитной карты произведена\n", amount);
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
        System.out.printf("""
                Кредитная карта с лимитом: %.2f
                Текущий баланс: %.2f
                На дебетовой карте: %.2f
                """, creditLimit, getBalance(), debitCard.getBalance());
    }


}
