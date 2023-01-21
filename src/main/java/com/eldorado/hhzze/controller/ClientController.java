package com.eldorado.hhzze.controller;

import com.eldorado.hhzze.dto.ClientBaseDto;
import com.eldorado.hhzze.dto.ImcBaseDto;
import com.eldorado.hhzze.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/client")
@Slf4j
@RequiredArgsConstructor
public class ClientController {

    @Autowired
    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientBaseDto> saveImc(@RequestBody ClientBaseDto clientDto) {
        log.info("Received Client IMC {} ", clientDto);
        return ResponseEntity.ok(clientService.saveClient(clientDto));
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<ClientBaseDto> getImc(@PathVariable UUID clientId) {
        return ResponseEntity.ok(clientService.getClientImc(clientId));
    }
}
