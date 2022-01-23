package com.kimry.baedal.service;

import com.kimry.baedal.CustomException;
import com.kimry.baedal.enums.ErrorCode;
import com.kimry.baedal.enums.TaxiRequestStatus;
import com.kimry.baedal.provider.CurrentDateProvider;
import com.kimry.baedal.domain.TaxiRequest;
import com.kimry.baedal.repository.TaxiRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaxiRequestService {

    @Autowired
    CurrentDateProvider currentDateProvider;

    @Autowired
    TaxiRequestRepository taxiRequestRepository;

    public List<TaxiRequest> getTaxiRequest() {
        return taxiRequestRepository.findAllByOrderByIdDesc();
    }

    public List<TaxiRequest> getTaxiRequest(int passengerId) {

        return taxiRequestRepository.findByPassengerIdOrderByIdDesc(passengerId);

    }

    public TaxiRequest makeTaxiRequest(TaxiRequest taxiRequest){

        if(taxiRequestRepository.countByPassengerIdAndStatus(taxiRequest.getPassengerId(),taxiRequest.getStatus())>=1)
        {
            throw new CustomException(ErrorCode.ALREADY_REQUEST);
        }

        return taxiRequestRepository.save(taxiRequest);
    }

    public TaxiRequest acceptTaxiRequest(int id, int driverId){

        Optional<TaxiRequest> taxiRequest = taxiRequestRepository.findById(id);
        if(taxiRequest.isPresent()) {
            if(taxiRequest.get().getStatus()== TaxiRequestStatus.ACCEPTED)
            {
                throw new CustomException(ErrorCode.ALREADY_ACCEPTED);
            }
            taxiRequest.get().accept(driverId, currentDateProvider.getDate());
            return taxiRequestRepository.save(taxiRequest.get());
        }
        throw new CustomException(ErrorCode.NOT_FOUND_REQUEST);
    }
}
