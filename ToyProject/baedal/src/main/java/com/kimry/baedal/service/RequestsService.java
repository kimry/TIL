package com.kimry.baedal.service;

import com.kimry.baedal.util.CurrentDateProvider;
import com.kimry.baedal.domain.TaxiRequests;
import com.kimry.baedal.enums.RequestStatus;
import com.kimry.baedal.repository.TaxiRequestsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestsService {

    @Autowired
    CurrentDateProvider currentDateProvider;

    @Autowired
    TaxiRequestsRepository taxiRequestsRepository;

    public List<TaxiRequests> getTaxiRequests() {
        return taxiRequestsRepository.findAll();
    }

    public List<TaxiRequests> getTaxiRequests(int passengerId) {

        return taxiRequestsRepository.findByPassengerId(passengerId);

    }

    public TaxiRequests addTaxiRequests(TaxiRequests taxiRequests){

        return taxiRequestsRepository.save(taxiRequests);

    }

    public TaxiRequests updateTaxiRequests(int id){

        TaxiRequests taxiRequests = taxiRequestsRepository.findById(id);
        taxiRequests.setStatus(RequestStatus.accepted);
        taxiRequests.setAcceptedAt(currentDateProvider.getDate());
        taxiRequests.setUpdatedAt(currentDateProvider.getDate());
        return taxiRequestsRepository.save(taxiRequests);

    }
}
