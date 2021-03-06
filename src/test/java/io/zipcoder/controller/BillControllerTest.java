package io.zipcoder.controller;

import io.zipcoder.bank.controller.BillController;
import io.zipcoder.bank.model.Bill;
import io.zipcoder.bank.service.BillService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import util.BaseControllerTest;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class BillControllerTest extends BaseControllerTest<Bill> {

    @MockBean
    private BillService billService;

    @InjectMocks
    private BillController billController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(billController).build();
        baseEndpointUrl = "/api/bills";
        entity = new Bill();
        initDependentVariables();
    }

    @Test
    public void testCreateBill() throws Exception {
        when(billService.createBill(entity))
                .thenReturn(entity);
        mvcPerformPostWithNoPathVariables(baseEndpointUrl, entityAsJsonString);
        System.out.println(entityAsJsonString);
    }

    @Test
    public void testFindAllBills() throws Exception {
        when(billService.findAllBills())
                .thenReturn(entityCollection);
        returnedEntity = mvcPerformGetWithNoPathVariables(baseEndpointUrl);
        Assert.assertEquals(entityNotReturnedMessage, entityCollectionAsJsonString, returnedEntity);
        System.out.println(returnedEntity);
    }

    @Test
    public void testFindBillById() throws Exception {
        when(billService.findBillByBillId(childEntityId))
                .thenReturn(entity);
        returnedEntity = mvcPerformGetWithOnePathVariable(idEndpointUrl, childEntityId);
        Assert.assertEquals(entityNotReturnedMessage, entityAsJsonString, returnedEntity);
    }

    @Test
    public void testUpdateBillById() throws Exception {
        when(billService.updateBillByBillId(childEntityId, entity))
                .thenReturn(entity);
        mvcPerformUpdateWithOnePathVariable(idEndpointUrl, childEntityId, entityAsJsonString);
    }

    @Test
    public void testDeleteAccountById() throws Exception {
        when(billService.findBillByBillId(childEntityId))
                .thenReturn(entity);
        returnedEntity = mvcPerformDeleteWithOnePathVariable(idEndpointUrl, childEntityId);
    }

}
