package com.br.fiap.sunergizer.controllers;

import com.br.fiap.sunergizer.dto.ConsumoRequest;
import com.br.fiap.sunergizer.dto.ConsumoResponse;
import com.br.fiap.sunergizer.services.ConsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumos")
public class ConsumoController {

    @Autowired
    private ConsumoService consumoService;

    @GetMapping
    public ResponseEntity<List<ConsumoResponse>> obterTodos() {
        return ResponseEntity.ok(consumoService.obterTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsumoResponse> obterPorId(@PathVariable Long id) {
        return ResponseEntity.ok(consumoService.obterPorId(id));
    }

    @PostMapping
    public ResponseEntity<ConsumoResponse> adicionar(@RequestBody ConsumoRequest request) {
        ConsumoResponse response = consumoService.adicionar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsumoResponse> atualizarPorId(@PathVariable Long id, @RequestBody ConsumoRequest request) {
        ConsumoResponse response = consumoService.atualizarPorId(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        consumoService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}

