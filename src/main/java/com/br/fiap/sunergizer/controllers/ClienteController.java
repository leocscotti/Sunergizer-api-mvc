package com.br.fiap.sunergizer.controllers;

import com.br.fiap.sunergizer.dto.ClienteRequest;
import com.br.fiap.sunergizer.dto.ClienteResponse;
import com.br.fiap.sunergizer.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> obterTodos() {
        return ResponseEntity.ok(clienteService.obterTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> obterPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.obterPorId(id));
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> adicionar(@RequestBody @Valid ClienteRequest request) {
        ClienteResponse response = clienteService.adicionar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> atualizarPorId(@PathVariable Long id, @RequestBody @Valid ClienteRequest request) {
        ClienteResponse response = clienteService.atualizarPorId(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        clienteService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}

