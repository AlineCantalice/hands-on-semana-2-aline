package com.eldorado.hhzze.service;

import com.eldorado.hhzze.domain.model.ClientImcEntity;
import com.eldorado.hhzze.domain.repository.ClientImcRepository;
import com.eldorado.hhzze.dto.CustomImcList;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import com.eldorado.hhzze.domain.model.ClientEntity;
import com.eldorado.hhzze.domain.repository.ClientRepository;
import com.eldorado.hhzze.dto.AddressBaseDto;
import com.eldorado.hhzze.dto.ClientBaseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.groupingBy;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientImcRepository clientImcRepository;
    private final AddressService addressService;
    private final ModelMapper modelMapper;

    public ClientBaseDto saveClient(ClientBaseDto clientBaseDto) {

        var addressDto = new AddressBaseDto();
        addressDto.setCity(clientBaseDto.getAddress().getCity());
        addressDto.setComplement(clientBaseDto.getAddress().getComplement());
        addressDto.setNeighborhood(clientBaseDto.getAddress().getNeighborhood());
        addressDto.setState(clientBaseDto.getAddress().getState());
        addressDto.setNumber(clientBaseDto.getAddress().getNumber());
        addressDto.setStreet(clientBaseDto.getAddress().getStreet());

        var address = addressService.saveAddress(addressDto);

        var clientEntity = ClientEntity.builder()
                .id(UUID.randomUUID())
                .gender(clientBaseDto.getGender())
                .address(address)
                .name(clientBaseDto.getName())
                .phone(clientBaseDto.getPhone())
                .dateOfBorn(clientBaseDto.getDateOfBorn())
                .frequencyAmount(clientBaseDto.getFrequencyAmount())
                .documentNumber(clientBaseDto.getDocumentNumber()).build();

        var clientEntitySave = clientRepository.save(clientEntity);

        log.info("CLIENT SAVED WITH SUCESSEFUL {}", clientEntitySave);
        clientBaseDto.setId(clientEntitySave.getId());

        return clientBaseDto;
    }

    @SneakyThrows
    public ClientBaseDto getClientImc(UUID id) {
        var client = clientRepository.findById(id)
                .orElseThrow(() -> new Exception("NOT FOUND"));

        var clientImcs = clientImcRepository.findByClientId(id);

        var clientCustom = modelMapper.map(clientImcs, CustomImcList.class);

        var clientDto = modelMapper.map(client, ClientBaseDto.class);
        clientDto.setClientImcs(clientCustom);

        clientDto.setHasChange(verifyChangeImc(clientImcs));

        return clientDto;
    }

    private boolean verifyChangeImc(List<ClientImcEntity> clientImcs) {

        return clientImcs.
                stream()
                .collect(groupingBy(client ->
                        client.getImcEntity().
                                getClassification())).size() > 1;

    }
}
