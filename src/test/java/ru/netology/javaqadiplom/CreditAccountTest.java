package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.rmi.server.ExportException;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
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
                5_000,
                10
        );

        account.add(-15_000);

        Assertions.assertEquals(0, account.getBalance());
    }



    @Test
    public void shouldYearChangeNegativeTest() {
        CreditAccount account = new CreditAccount(
                -200,
                5_000,
                15
        );

        Assertions.assertEquals(-30, account.yearChange());
    }

    @Test
    public void shouldYearChangeZeroTest() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldYearChangePositiveTest() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void payTest() {
        CreditAccount account = new CreditAccount(
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
                5_000,
                10
        );
        Assertions.assertFalse(account.pay(-8_000));

    }

    @Test
    public void creditLimitMaxTest() {
        CreditAccount account = new CreditAccount(0, 5_000, 10);
        account.pay(6000);
        Assertions.assertEquals(5000, account.getCreditLimit());
    }

    @Test
    public void creditLimitTest() {
        CreditAccount account = new CreditAccount(0, 5_000, 10);
        account.pay(5000);
        Assertions.assertEquals(5000, account.getCreditLimit());
    }

    @Test
    public void testBalanceBelowCreditLimit() {
        CreditAccount account = new CreditAccount(-6_000,5_000,10);
        account.pay(100);
        Assertions.assertFalse(account.pay(100));
    }

    @Test
    public void testNegativeRateBelowZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(0, 5_000, -10);
        });
    }

    @Test
    public void testNegativeRateEqualsZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(0, 5_000, 0);
        });
    }
}
