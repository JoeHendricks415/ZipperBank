package io.zipcoder.service;

import io.zipcoder.bank.model.Account;
import io.zipcoder.bank.repository.AccountRepository;
import io.zipcoder.bank.service.AccountService;
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
public class AccountServiceTest extends BaseServiceTest<Account> {

    @Mock
    private static AccountRepository accountRepository;

    @InjectMocks
    private static AccountService accountService = new AccountService(accountRepository);

    @Before
    public void init() {
        entity = new Account();
        initDependentVariables();
    }

    @Test
    public void testCreateAccount() {
        when(accountRepository.save(entity))
                .thenReturn(entity);
        returnedEntity = accountService.createAccount(entity);
        Assert.assertEquals(entityNotReturnedMessage, entity, returnedEntity);
    }

    @Test
    public void testFindAllAccounts() {
        when(accountRepository.findAll())
                .thenReturn(entityCollection);
        returnedEntityCollection = accountService.findAllAccounts();
        Assert.assertEquals(entityNotReturnedMessage, entityCollection, returnedEntityCollection);
    }

    @Test
    public void testFindAccountById() {
        when(accountRepository.findOne(entityId))
                .thenReturn(entity);
        returnedEntity = accountService.findAccountById(entityId);
        Assert.assertEquals(entityNotReturnedMessage, entity, returnedEntity);
    }

    @Test
    public void testUpdateAccountById() {
        when(accountRepository.save(entity))
                .thenReturn(entity);
        returnedEntity = accountService.updateAccountById(entityId, entity);
        Assert.assertEquals(entityNotReturnedMessage, entity, returnedEntity);
    }

    @Test
    public void testDeleteAccountById() {
        accountService.deleteAccountById(entityId);
        verify(accountRepository, times(1))
                .delete(eq(entityId));
    }

}
