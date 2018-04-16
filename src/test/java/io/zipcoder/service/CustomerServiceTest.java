package io.zipcoder.service;

import io.zipcoder.bank.model.Customer;
import io.zipcoder.bank.repository.CustomerRepository;
import io.zipcoder.bank.service.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import util.BaseServiceTest;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest extends BaseServiceTest<Customer> {

    @Mock
    private static CustomerRepository customerRepository;

    @InjectMocks
    private static CustomerService customerService = new CustomerService(customerRepository);

    @Before
    public void init() {
        entity = new Customer();
        initDependentVariables();
    }

    @Test
    public void testCreateCustomer() {
        when(customerRepository.save(entity))
                .thenReturn(entity);
        returnedEntity = customerService.createCustomer(entity);
        Assert.assertEquals(entityNotReturnedMessage, entity, returnedEntity);
    }

    @Test
    public void testFindAllCustomers() {
        when(customerRepository.findAll())
                .thenReturn(entityCollection);
        returnedEntityCollection = customerService.findAllCustomers();
        Assert.assertEquals(entityNotReturnedMessage, entityCollection, returnedEntityCollection);
    }

    @Test
    public void testFindCustomerById() {
        when(customerRepository.findOne(entityId))
                .thenReturn(entity);
        returnedEntity = customerService.findCustomerById(entityId);
        Assert.assertEquals(entityNotReturnedMessage, entity, returnedEntity);
    }

    @Test
    public void testUpdateCustomerById() {
        when(customerRepository.save(entity))
                .thenReturn(entity);
        returnedEntity = customerService.updateCustomerById(entityId, entity);
        Assert.assertEquals(entityNotReturnedMessage, entity, returnedEntity);
    }

    @Test
    public void testDeleteCustomerById() {
        customerService.deleteCustomerById(entityId);
        verify(customerRepository, times(1))
                .delete(eq(entityId));
    }

}
