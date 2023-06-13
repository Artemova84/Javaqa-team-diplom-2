package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                3_000,
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldAddToNegativeBalance() {
        CreditAccount account = new CreditAccount(
                0,
                0,
                5_000,
                10
        );

        account.add(-15_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldMoneyAddBalance() {
        CreditAccount account = new CreditAccount(
                8_000,
                5_000,
                5_000,
                10
        );

        account.add(3_000);

        Assertions.assertEquals(8_000, account.getBalance());
    }

    @Test
    public void shouldYearChangeNegativeTest() {
        CreditAccount account = new CreditAccount(
                -230,
                -200,
                5_000,
                15
        );

        Assertions.assertEquals(-30, account.yearChange());
    }

    @Test
    public void shouldYearChangePositiveTest() {
        CreditAccount account = new CreditAccount(
                200,
                200,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void payTest() {
        CreditAccount account = new CreditAccount(
                5_000,
                8_000,
                5_000,
                10
        );

        account.pay(3_000);

        Assertions.assertEquals(5_000, account.getBalance());
    }

    @Test
    public void payLimitTest() {
        CreditAccount account = new CreditAccount(
                0,
                0,
                5_000,
                10
        );
        Assertions.assertFalse(account.pay(8_000));

    }
}
