package com.eldorado.hhzze.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AddressBaseDto {
    private String street;
    private String neighborhood;
    private Integer number;
    private String city;
    private String state;
    private String complement;
}
