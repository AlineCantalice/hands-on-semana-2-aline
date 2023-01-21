package com.eldorado.hhzze.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("address")
public class AddressEntity {

    @Id
    private UUID id;
    private String street;
    private String neighborhood;
    private Integer number;
    private String city;
    private String state;
    private String complement;
}
