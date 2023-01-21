package com.eldorado.hhzze.service;

import com.eldorado.hhzze.domain.model.AddressEntity;
import com.eldorado.hhzze.domain.repository.AddressRepository;
import com.eldorado.hhzze.dto.AddressBaseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressEntity saveAddress(AddressBaseDto addressBaseDto){

        var addresEntity = AddressEntity.builder()
                .id(UUID.randomUUID())
                .state(addressBaseDto.getState())
                .city(addressBaseDto.getCity())
                .neighborhood(addressBaseDto.getNeighborhood())
                .number(addressBaseDto.getNumber())
                .street(addressBaseDto.getStreet())
                .complement(addressBaseDto.getComplement()).build();

        var addressEntitySave = addressRepository.save(addresEntity);

        log.info("ADDRESS SAVED WITH SUCESSEFUL {}", addressEntitySave);

        return addressEntitySave;
    }
}
