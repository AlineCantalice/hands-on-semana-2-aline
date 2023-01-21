package com.eldorado.hhzze.service;

import com.eldorado.hhzze.domain.repository.ImcRepository;
import com.eldorado.hhzze.domain.model.ImcEntity;
import com.eldorado.hhzze.dto.ImcBaseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImcService {

    private final ImcRepository imcRepository;

    public ImcBaseDto saveImc(ImcBaseDto imcBaseDto) {

        var imcEntity = ImcEntity.builder()
                .id(UUID.randomUUID())
                .offsetDateTime(LocalDateTime.now())
                .createdBy("ALINE CANTALICE")
                .bodyMassIndex(imcBaseDto.getBodyMassIndex()).
                classification(imcBaseDto.getClassification())
                .obesityLevel(imcBaseDto.getObesityLevel()).build();

        var imcEntitySave = imcRepository.save(imcEntity);

        log.info("IMC SAVED WITH SUCESSEFUL {}", imcEntitySave);
        imcBaseDto.setId(imcEntitySave.getId());

        return imcBaseDto;
    }

    public List<ImcBaseDto> getImcList() {
        List<ImcBaseDto> list = new ArrayList<>();



        return list;
    }

}
