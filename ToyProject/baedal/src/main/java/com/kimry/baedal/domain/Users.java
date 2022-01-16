package com.kimry.baedal.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kimry.baedal.enums.UserType;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private UserType userType;

    private String createdAt;

    private String updatedAt;
}
