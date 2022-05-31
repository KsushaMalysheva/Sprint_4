package com.example;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.Conversions.trim;


public class ParamAccountTest {

    @ParameterizedTest(name = "#{index} - Run test with username = {0}")
    @MethodSource("validUsernameProvider")
    void usernameRegexValidTest(String username) {
        assertTrue(Account.checkNameToEmboss(username));
    }

    @ParameterizedTest(name = "#{index} - Run test with username = {0}")
    @MethodSource("invalidUsernameProvider")
    void usernameRegexInvalidTest(String username) {
        assertFalse(Account.checkNameToEmboss(username));
    }

    static Stream validUsernameProvider() {
        return Stream.of(
                "Иван Смирнов",
                "Тимоти Шаломе",
                "Тим Лу",
                "Ксения Петрова",
                "Ку Ким",
                "Александр Иванов",
                "Аркадий Паравозов",
                "Александра Ли",
                "Семен Семенов",
                "Игорь Рассказов",
                "Саша Петров",
                "Вася Васин");
    }

    static Stream invalidUsernameProvider() {
        return Stream.of(
                "абв",                      // invalid length 3, length must between 3-19
                "01234567890123456789a",    // invalid length 21,invalid symbols, length must between 3-19
                "_Иван Иванов ",              // invalid start and last character
                ".Иван Иванов.",              // invalid start and last character
                "-Иван Иванов-",              // invalid start and last character
                " Иван Иванов ",               // invalid start and last character
                "Тимоти Шаломе#$%@123",         // invalid symbols
                "Тимоти..Шаломе",              // invalid symbols
                "ТимотиШевроле",              // missing space
                "Торалоарар Трпшшшррашгрукагурапловирш",    // invalid length, length must between 3-19
                " ИванПетров",              // invalid start and missing space
                " ",                        // empty
                "");                        // empty
    }

}



