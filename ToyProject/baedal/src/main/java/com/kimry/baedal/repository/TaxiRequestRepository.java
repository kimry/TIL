package com.kimry.baedal.repository;

import com.kimry.baedal.domain.TaxiRequest;
import com.kimry.baedal.enums.TaxiRequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface TaxiRequestRepository extends JpaRepository<TaxiRequest, Long> {

    TaxiRequest save(TaxiRequest taxiRequest);

    Optional<TaxiRequest> findById(int id);

    List<TaxiRequest> findAllByOrderByIdDesc();

    List<TaxiRequest> findByPassengerIdOrderByIdDesc(int passengerId);

    int countByPassengerIdAndStatus(int passengerId, TaxiRequestStatus taxiRequestStatus);
}
