package com.kimry.baedal.repository;

import com.kimry.baedal.domain.TaxiRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface TaxiRequestsRepository extends JpaRepository<TaxiRequests, Long> {

    TaxiRequests save(TaxiRequests taxiRequests);

    TaxiRequests findById(int id);

    List<TaxiRequests> findAll();

    List<TaxiRequests> findByPassengerId(int passengerId);

}
