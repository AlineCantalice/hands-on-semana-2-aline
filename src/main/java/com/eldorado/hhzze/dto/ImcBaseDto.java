package com.eldorado.hhzze.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ImcBaseDto {
    private UUID id;
    private Double bodyMassIndex;
    private String classification;
    private String obesityLevel;
    private LocalDateTime createAt;
}
