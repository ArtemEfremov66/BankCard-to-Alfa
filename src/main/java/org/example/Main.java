package org.example;

import org.example.cards.CreditCard;
import org.example.cards.bonusCard.CreditCardPiggyBank;
import org.example.cards.bonusCard.DebitCardBonus;

public class Main {
    public static void main(String[] args) {
        // Тест бонусной дебетовой карты и стандартной кредитной
        DebitCardBonus debitCard = new DebitCardBonus();
        CreditCard creditCard = new CreditCard(100_000, debitCard);
        debitCard.getInfo(); //Инфо о карте

        debitCard.add(10000); //Пополнение дебетовой карты
        System.out.println("Баланс дебетовой карты: " + debitCard.getBalance());

        System.out.println("Выполняем перевод на 3000");
        debitCard.pay(3000); //Оплата с дебетовой карты
        System.out.println("Баланс дебетовой карты: " + debitCard.getBalance());
        System.out.println("Баланс кредитной карты: " + creditCard.getBalance());

        System.out.println("Выполняем перевод с кредитной карты на 20000");
        creditCard.pay(20_000); //Оплата с кредитной карты
        System.out.println("Баланс кредитной карты: " + creditCard.getBalance());
        System.out.println("Баланс дебетовой карты: " + debitCard.getBalance());

        creditCard.add(50_000); //Пополнение кредитной карты
        System.out.println("Баланс дебетовой карты: " + debitCard.getBalance());
        System.out.println("Баланс кредитной карты: " + creditCard.getBalance());

        debitCard.cashbackTransfer(); //Перевод кешбка
        System.out.println("__________________________________________________________");

        // Создаём и тестируем кредитную карту с копилкой
        CreditCardPiggyBank creditCardPiggyBank = new CreditCardPiggyBank(150_000, debitCard);
        creditCardPiggyBank.getInfo();
        creditCardPiggyBank.add(30_000);
        System.out.println("Баланс кредитной карты: " + creditCardPiggyBank.getBalance());
        creditCardPiggyBank.transferPiggyBank(100); // Выводим 100 из копилки на карту
        System.out.println("Баланс дебетовой карты: " + debitCard.getBalance());
    }
}