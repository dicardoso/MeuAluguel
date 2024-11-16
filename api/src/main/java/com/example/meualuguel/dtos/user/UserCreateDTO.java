package com.example.meualuguel.dtos.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class UserCreateDTO {
    private String name;
    private String email;
    private String phone;
    private String address;
    @JsonProperty("profile_id")
    private Long profile_id;
}