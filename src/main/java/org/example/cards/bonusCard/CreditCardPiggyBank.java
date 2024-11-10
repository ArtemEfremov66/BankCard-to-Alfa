package org.example.cards.bonusCard;

import org.example.cards.CreditCard;
import org.example.cards.DebitCard;

public class CreditCardPiggyBank extends CreditCard {
    private final DebitCard debitCard;
    private final double creditLimit;
    private final double PERCENT = 0.005;

    public CreditCardPiggyBank(double creditLimit, DebitCard debitCard) {
        super(creditLimit, debitCard);
        this.debitCard = debitCard;
        this.creditLimit = creditLimit;
    }

    private double piggyBank = 0;

    @Override
    public boolean add(double amount) {
        double toPiggyBank = amount * PERCENT;
        super.add(amount - toPiggyBank);
        piggyBank += toPiggyBank;
        return true;
    }

    public void transferPiggyBank(double amount) {
        if (piggyBank >= amount) {
            debitCard.balance += amount;
            piggyBank -= amount;
            System.out.printf("Сумма %.2f из копилки переведена на карту\n", amount);
        } else {
            System.out.println("Некорректная сумма");
        }
    }

    public double getPiggyBank() {
        return piggyBank;
    }

    @Override
    public void getInfo() {
        System.out.printf("""
                Кредитная карта с копилкой, баланс: %.2f
                Кредитный лимит: %.2f
                На дебетовой карте: %.2f
                В копилке на данный момент: %.2f
                Условия пополнения копилки: %.2f%% с пополнений
                """, getBalance(), creditLimit, debitCard.getBalance(), piggyBank, PERCENT * 100);
    }
}
