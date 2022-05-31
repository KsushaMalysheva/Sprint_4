package com.example;

public class Praktikum {
    public static void main(String[] args) {

        final String username = "Тимоти Шаламе";

        Account account = new Account(username);

        account.checkNameToEmboss(username);

    }
}