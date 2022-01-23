package com.kimry.baedal.controller;

import com.kimry.baedal.CustomException;
import com.kimry.baedal.aspect.Authentication;
import com.kimry.baedal.domain.User;
import com.kimry.baedal.enums.ErrorCode;
import com.kimry.baedal.enums.UserType;
import com.kimry.baedal.provider.JwtProvider;
import com.kimry.baedal.vo.AddressVO;
import com.kimry.baedal.provider.CurrentDateProvider;
import com.kimry.baedal.domain.TaxiRequest;
import com.kimry.baedal.enums.TaxiRequestStatus;
import com.kimry.baedal.service.TaxiRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/taxi-requests")
public class TaxiRequestController {

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    TaxiRequestService taxiRequestService;

    @Autowired
    CurrentDateProvider currentDateProvider;

    @Authentication
    @GetMapping()
    public List<TaxiRequest> getTaxiRequest() {

        User user = jwtProvider.getUser();

        if(user.getUserType() == UserType.DRIVER){
            return taxiRequestService.getTaxiRequest();
        }

        return taxiRequestService.getTaxiRequest(user.getId());
    }

    @Authentication
    @PostMapping()
    public TaxiRequest makeTaxiRequest(@RequestBody AddressVO addressVO) {

        User user = jwtProvider.getUser();

        String address = addressVO.getAddress();

        if(address.length()>100|| address.length()<=0){
            throw new CustomException(ErrorCode.ADDRESS_INVALID);
        }
        if(user.getUserType()==UserType.DRIVER){
            throw new CustomException(ErrorCode.DRIVER_CANNOT_REQUEST);
        }

        TaxiRequest taxiRequest = new TaxiRequest(addressVO.getAddress(),user.getId(),TaxiRequestStatus.STAND_BY, currentDateProvider.getDate());
        taxiRequest = taxiRequestService.makeTaxiRequest(taxiRequest);

        return taxiRequest;
    }

    @Authentication
    @PostMapping(value="/{id}/accept")
    public TaxiRequest acceptTaxiRequest(@PathVariable("id") int id){

        User user = jwtProvider.getUser();

        if(user.getUserType()==UserType.PASSENGER){
            throw new CustomException(ErrorCode.PASSENGER_CANNOT_ACCEPT);
        }

        return taxiRequestService.acceptTaxiRequest(id,user.getId());
    }
}
