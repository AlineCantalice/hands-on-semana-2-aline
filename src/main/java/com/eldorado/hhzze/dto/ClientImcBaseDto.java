package com.eldorado.hhzze.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ClientImcBaseDto {
    @Id
    private UUID id;
    private UUID clientId;
    private double height;
    private double weight;
    private LocalDate dateOfMeasure;
}
