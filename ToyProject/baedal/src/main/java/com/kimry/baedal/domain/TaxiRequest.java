package com.kimry.baedal.domain;

import com.kimry.baedal.enums.TaxiRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaxiRequest {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String address;

    @Nullable
    private Integer driverId;

    private int passengerId;

    private TaxiRequestStatus status;

    @Nullable
    private String acceptedAt;

    private String createdAt;

    private String updatedAt;

    public TaxiRequest(String address, int passengerId, TaxiRequestStatus status, String currentDate) {
        this.address = address;
        this.passengerId = passengerId;
        this.status = status;
        this.createdAt = currentDate;
        this.updatedAt = currentDate;
    }

    public void accept(int driverId, String currentDate){
        this.driverId = driverId;
        this.status = TaxiRequestStatus.ACCEPTED;
        this.acceptedAt = currentDate;
        this.updatedAt = currentDate;
    }
}
