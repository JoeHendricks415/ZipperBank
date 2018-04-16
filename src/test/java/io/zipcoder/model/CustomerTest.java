package io.zipcoder.model;

import io.zipcoder.bank.model.Customer;
import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {

    @Test
    public void customerIdTest() {
        Customer customer = new Customer();
        customer.setId(1234);
        Integer expected = 1234;
        Assert.assertEquals(expected, customer.getId());
    }

    @Test
    public void customerFirstNameTest() {
        Customer customer = new Customer();
        customer.setFirst_name("Joe");
        String expected = "Joe";
        Assert.assertEquals(expected, customer.getFirst_name());
    }

    @Test
    public void customerLastNameTest() {
        Customer customer = new Customer();
        customer.setLast_name("Joe");
        String expected = "Joe";
        Assert.assertEquals(expected, customer.getLast_name());
    }

    @Test
    public void customerAddressTest() {
        Customer customer = new Customer();
        customer.setAddressId(1);
        Integer expected = 1;
        Assert.assertEquals(expected.getClass(), customer.getAddressId().getClass());
    }

}
