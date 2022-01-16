package com.kimry.baedal.domain;

import com.kimry.baedal.enums.RequestStatus;
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
public class TaxiRequests {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String address;

    @Nullable
    private Integer driverId;

    private int passengerId;

    private RequestStatus status;

    @Nullable
    private String acceptedAt;

    private String createdAt;

    private String updatedAt;
}
