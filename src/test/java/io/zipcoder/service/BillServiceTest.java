package io.zipcoder.service;

import io.zipcoder.bank.model.Bill;
import io.zipcoder.bank.repository.BillRepository;
import io.zipcoder.bank.service.AccountService;
import io.zipcoder.bank.service.BillService;
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
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BillServiceTest extends BaseServiceTest<Bill> {


    @Mock
    private static BillRepository billRepository;
    private static AccountService accountService;

    @InjectMocks
    private static BillService billService = new BillService(billRepository, accountService);

    @Before
    public void init() {
        entity = new Bill();
        initDependentVariables();
    }

    @Test
    public void testCreateBill() {
        when(billRepository.save(entity))
                .thenReturn(entity);
        returnedEntity = billService.createBill(entity);
        Assert.assertEquals(entityNotReturnedMessage, entity, returnedEntity);
    }

    @Test
    public void testFindBillByBillId() {
        when(billRepository.findOne(entityId))
                .thenReturn(entity);
        returnedEntity = billService.findBillByBillId(entityId);
        Assert.assertEquals(entityNotReturnedMessage, entity, returnedEntity);
    }

    @Test
    public void testUpdateBillByBillId() {
        when(billRepository.save(entity))
                .thenReturn(entity);
        returnedEntity = billService.updateBillByBillId(entityId, entity);
        Assert.assertEquals(entityNotReturnedMessage, entity, returnedEntity);
    }

    @Test
    public void testDeleteBillByBillId() {
        billService.deleteBillByBillId(entityId);
        verify(billRepository, times(1))
                .delete(eq(entityId));
    }

//    @Test
//    public void testFindBillsByAccount() {
//        when(billRepository.findByAccount_id(entityId))
//                .thenReturn(entityCollection);
//        returnedEntityCollection = billService.findAllBillsByAccount(entityId);
//        Assert.assertEquals(entityNotReturnedMessage, entityCollection, returnedEntityCollection);
//    }


}
