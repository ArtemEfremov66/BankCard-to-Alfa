package org.example.cards;

public class CreditCardPiggyBank extends CreditCard {
    private final DebitCard debitCard;
    private final double creditLimit;

    public CreditCardPiggyBank(double creditLimit, DebitCard debitCard) {
        super(creditLimit, debitCard);
        this.debitCard = debitCard;
        this.creditLimit = creditLimit;
    }

    private double piggyBank = 0;

    @Override
    public boolean add(double amount) {
        double toPiggyBank = amount* 0.005;
        super.add(amount-toPiggyBank);
        piggyBank += toPiggyBank;
        return true;
    }

    public void transferPiggyBank(double amount) {
        if (piggyBank >= amount) {
            debitCard.balance += amount;
            piggyBank -= amount;
            System.out.println("Сумма из копилки переведена на карту");
        } else {
            System.out.println("Некорректная сумма");
        }
    }
    public double getPiggyBank() {
        return piggyBank;
    }

    @Override
    public void getInfo() {
        System.out.println("Кредитная карта с копилкой, баланс: " + getBalance() + "\n" + "Кредитный лимит: " +
                creditLimit + "\n" + "На дебетовой карте: " + debitCard.getBalance() + "\n" +
                "В копилке на данный момент: " + piggyBank + "\nУсловия пополнения копилки: 0,5% с пополнений");
    }
}
