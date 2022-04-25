


package com.example;

import com.example.Account;
import com.example.Praktikum;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(Parameterized.class)

    public class NewParamTest {

        private final String username;
        private final boolean expected;

        public NewParamTest(String username, boolean expected) {
            this.username = username;
            this.expected = expected;
        }

        @Parameterized.Parameters(name = "#{index} - Run test with username = {0}")
        public static Object[] getTestData1() {
            return new Object[][] {
                    {"Тимоти Шаломе", true}, //валидное значение: есть один пробел между словами, количество символов в диапазоне 3-19, Имя и Фамилия начинаются с букв верхнего регистра
                    {"Си Р", true},          //валидное значение: есть один пробел между словами, количество символов в диапазоне 3-19, Имя и Фамилия начинаются с букв верхнего регистра
                    {"Ти Ша", true},          //валидное значение: есть один пробел между словами, количество символов в диапазоне 3-19, Имя и Фамилия начинаются с букв верхнего регистра
                    {"Тимотиапр Шаламефы", true}, //валидное значение: есть один пробел между словами, количество символов в диапазоне 3-19, Имя и Фамилия начинаются с букв верхнего регистра
                    {"Тимотиапр Шаламефы", true},  //валидное значение: есть один пробел между словами, количество символов в диапазоне 3-19, Имя и Фамилия начинаются с букв верхнего регистра
                    {"ТимотиШаламе", false},       //невалидное значение: отсутствует пробел между словами, количество символов в диапазоне 3-19, Имя и Фамилия начинаются с букв верхнего регистра
                    {" Тимоти Шаламе ", false},     //невалидное значение: пробел вначале строки и конце
                    {"", false},                    //невалидное значение: передается пустая строка
                    {"    ", false},               //невалидное значение: передается пустая строка (в строке только символы пробела)
                    {"а пр",false},              //невалидное значение:не соответствует передаваемому паттерну Имя и Фамилия начинаются с букв верхнего регистра
                    {" А Пр",false},               //невалидное значение: пробел в начале строки
                    {"А Пр ",false},               //невалидное значение: пробел в конце строки
                    {"Торалоарар Трпшшшррашгрукагурапловирш",false}, //невалидное значение: длина строки более 19 симолов
                    {"Торалоарар Трпшшшрра",false}, //невалидное значение: длина строки более 19 символов (20 символов)
                    {"А",false},               //невалидное значение: длина строки менее 3 символов (20 символов)

            };
        }

        @Test
        public void checkValidName()  {
            Account account = new Account("Тимоти Шаламе");
            assertEquals(account.checkNameToEmboss(username),expected);
            assertNotNull(username);

        }


    }
