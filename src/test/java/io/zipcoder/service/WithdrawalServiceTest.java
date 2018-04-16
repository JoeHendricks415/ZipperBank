package io.zipcoder.service;

import io.zipcoder.bank.model.Withdrawal;
import io.zipcoder.bank.repository.WithdrawalRepo;
import io.zipcoder.bank.service.WithdrawalService;
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
public class WithdrawalServiceTest extends BaseServiceTest<Withdrawal> {

    @Mock
    private static WithdrawalRepo withdrawalRepo;

    @InjectMocks
    private static WithdrawalService withdrawalService = new WithdrawalService(withdrawalRepo);

    @Before
    public void init() {
        entity = new Withdrawal();
        initDependentVariables();
    }

    @Test
    public void testCreateWithdrawal() {
        when(withdrawalRepo.save(entity))
                .thenReturn(entity);
        returnedEntity = withdrawalService.createWithdrawal(entity);
        Assert.assertEquals(entityNotReturnedMessage, entity, returnedEntity);
    }

//    @Test
//    public void testFindAllAccounts() {
//        when(accountRepository.findAll())
//                .thenReturn(entityCollection);
//        returnedEntityCollection = accountService.findAllAccounts();
//        Assert.assertEquals(entityNotReturnedMessage, entityCollection, returnedEntityCollection);
//    }

    @Test
    public void testFindWithdrawalById() {
        when(withdrawalRepo.findOne(entityId))
                .thenReturn(entity);
        returnedEntity = withdrawalService.findWithdrawalByWithdrawalId(entityId);
        Assert.assertEquals(entityNotReturnedMessage, entity, returnedEntity);
    }

    @Test
    public void testUpdateWithdrawalById() {
        when(withdrawalRepo.save(entity))
                .thenReturn(entity);
        returnedEntity = withdrawalService.updateWithdrawalByWithdrawalId(entityId, entity);
        Assert.assertEquals(entityNotReturnedMessage, entity, returnedEntity);
    }

    @Test
    public void testDeleteWithdrawalById() {
        withdrawalService.deleteWithdrawalByWithdrawalId(entityId);
        verify(withdrawalRepo, times(1))
                .delete(eq(entityId));
    }


}
