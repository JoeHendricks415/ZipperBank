package io.zipcoder.model;

import io.zipcoder.bank.enums.Type;
import io.zipcoder.bank.model.Account;
import io.zipcoder.bank.model.Customer;
import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

    @Test
    public void accountIdTest() {
        Account account = new Account();
        account.setId(1);
        Integer expected = 1;
        Assert.assertEquals(expected, account.getId());
    }

    @Test
    public void accountNicknameTest() {
        Account account = new Account();
        account.setNickname("Account One");
        String expected = "Account One";
        Assert.assertEquals(expected, account.getNickname());
    }

    @Test
    public void accountRewardsTest() {
        Account account = new Account();
        account.setRewards(22);
        Integer expected = 22;
        Assert.assertEquals(expected, account.getRewards());
    }

    @Test
    public void accountBalanceTest() {
        Account account = new Account();
        account.setBalance(1923.86);
        Double expected = 1923.86;
        Assert.assertEquals(expected, account.getBalance());
    }

    @Test
    public void accountTypeTest() {
        Account account = new Account();
        account.setType(Type.CHECKING);
        Type expected = Type.CHECKING;
        Assert.assertEquals(expected, account.getType());
    }

    @Test
    public void accountCustomerTest() {
        Account account = new Account();
        account.setCustomerId(1);
        Integer expected = 1;
        Assert.assertEquals(expected, account.getCustomerId());
    }

}
