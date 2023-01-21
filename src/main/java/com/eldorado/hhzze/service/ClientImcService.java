package com.eldorado.hhzze.service;

import com.eldorado.hhzze.domain.model.ClientImcEntity;
import com.eldorado.hhzze.domain.model.ImcEntity;
import com.eldorado.hhzze.domain.repository.ClientImcRepository;
import com.eldorado.hhzze.domain.repository.ImcRepository;
import com.eldorado.hhzze.dto.ClientImcBaseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;

import org.modelmapper.ModelMapper;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientImcService {

    private final ClientImcRepository clientImcRepository;
    private final ImcRepository imcRepository;
    private final ModelMapper modelMapper;

    public ClientImcBaseDto saveImc(ClientImcBaseDto clientImcBaseDto){
        var clientImcEntity = modelMapper.map(clientImcBaseDto, ClientImcEntity.class);
        var clientImcEntitySave = clientImcRepository.save(clientImcEntity);

        log.info("IMC SAVED WITH SUCESSEFUL {}", clientImcEntity);
        clientImcBaseDto.setId(clientImcEntitySave.getId());

        return clientImcBaseDto;
    }

    private ImcEntity calculateImc(ClientImcBaseDto clientImcDto, Double bodyMass) {
        var imcs = imcRepository.findAll();
        Collections.sort(imcs);

        return imcs.stream().filter(imcs1 -> imcs1.getBodyMassIndex() > bodyMass)
                .findFirst().orElse(ImcEntity.builder()
                        .classification("NOT DEFINED").build());


    }

    private Double calculateBodyMass(ClientImcBaseDto clientImcDto) {
        return clientImcDto.getWeight() / Math.pow(clientImcDto.getHeight(), 2d);
    }
}
