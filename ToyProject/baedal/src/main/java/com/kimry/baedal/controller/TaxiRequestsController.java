package com.kimry.baedal.controller;

import com.kimry.baedal.util.CurrentDateProvider;
import com.kimry.baedal.domain.TaxiRequests;
import com.kimry.baedal.enums.RequestStatus;
import com.kimry.baedal.service.RequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/taxi-requests")
public class TaxiRequestsController {

    @Autowired
    RequestsService requestsService;

    @Autowired
    CurrentDateProvider currentDateProvider;

    @GetMapping()
    public List<TaxiRequests> getRequests() {

        return requestsService.getTaxiRequests(1);

    }

    @PostMapping()
    public TaxiRequests addRequests(String address) {

        TaxiRequests taxiRequests = TaxiRequests.builder().
                address(address).
                passengerId(1).
                status(RequestStatus.standBy).
                createdAt(currentDateProvider.getDate()).
                updatedAt(currentDateProvider.getDate()).
                build();

        taxiRequests = requestsService.addTaxiRequests(taxiRequests);
        return taxiRequests;
    }

    @PostMapping(value="/{id}/accept")
    public TaxiRequests acceptRequest(@PathVariable("id") int id){

        return requestsService.updateTaxiRequests(id);

    }
}
