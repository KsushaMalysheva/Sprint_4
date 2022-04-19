package com.example;

public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {

        if (name.length() >=3) {
            return true;
        }
        else if (name.length()<=19) {
            return true;
        }
        else if (name.equals("Тимоти Шаламе")) {
            return true;
        } else {
            return false;
        }
    }

}
