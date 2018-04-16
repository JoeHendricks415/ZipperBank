package io.zipcoder.bank.repository;

import io.zipcoder.bank.model.Bill;
import io.zipcoder.core.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BillRepository extends BaseRepository<Bill, Integer> {

//    Collection<Bill> findByAccount_id(int accountId);

}
