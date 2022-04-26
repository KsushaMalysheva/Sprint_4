package com.example;

import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {

    private static final String USERNAME_PATTERN = "^(?=.{3,19}$)[А-ЯЁ][а-яё]*\\s[А-ЯЁ][а-яё]*$";

    private static final Pattern pattern = Pattern.compile(USERNAME_PATTERN);
    private final String username;

    public Account(String username) {
        this.username = username;
    }

    public static boolean checkNameToEmboss(final String username) {
        if (username == null) {
            return false;
        } else {
            Matcher matcher = pattern.matcher(username);
            return matcher.matches();
        }
    }
}
