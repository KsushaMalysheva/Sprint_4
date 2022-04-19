package com.example;

import com.example.Account;
import com.example.Praktikum;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;




    @RunWith(Parameterized.class)

    public class ParamTestAccount {

            private final String name;
            private final boolean expected;

        public ParamTestAccount(String name, boolean expected) {
            this.name = name;
            this.expected = expected;
        }

        @Parameterized.Parameters
            public static Object[] getTestData1() {
                return new Object[][] {
                        {" Тимоти Шаламе", false},
                        {" Тимоти Шаламе ", false},
                        {"ТимотиШаламе", false},
                        {"Тимоти Шаламе", true},
                };
            }

        @Test
      //  @DisplayName("1")
        public void checkTrimBefreAndAfterName()  {
            Account account = new Account("Тимоти Шаламе");
            assertEquals(account.checkNameToEmboss(),expected);
        }

        @Parameterized.Parameters
        public Object[] getTestData2() {
            return new Object[][] {
                    {name.length()<3, false},
                    {name.length()>19, false},
                    {name.length()<=19, true},
                    {name.length()>=3, true},
            };
        }

        @Test
     //   @DisplayName("2")
        public void checkLenghtName()  {
            Account account = new Account("Тимоти Шаламе");
            assertEquals(account.checkNameToEmboss(),expected);
        }
    }