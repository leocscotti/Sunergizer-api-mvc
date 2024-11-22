package com.br.fiap.sunergizer.controllers;

import com.br.fiap.sunergizer.dto.FonteEnergiaRequest;
import com.br.fiap.sunergizer.dto.FonteEnergiaResponse;
import com.br.fiap.sunergizer.services.FonteEnergiaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fontes")
public class FonteEnergiaController {

    @Autowired
    private FonteEnergiaService fonteEnergiaService;

    @GetMapping
    public ResponseEntity<List<FonteEnergiaResponse>> obterTodas() {
        return ResponseEntity.ok(fonteEnergiaService.obterTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FonteEnergiaResponse> obterPorId(@PathVariable Long id) {
        return ResponseEntity.ok(fonteEnergiaService.obterPorId(id));
    }

    @PostMapping
    public ResponseEntity<FonteEnergiaResponse> adicionar(@RequestBody @Valid FonteEnergiaRequest request) {
        FonteEnergiaResponse response = fonteEnergiaService.adicionar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FonteEnergiaResponse> atualizarPorId(@PathVariable Long id, @RequestBody @Valid FonteEnergiaRequest request) {
        FonteEnergiaResponse response = fonteEnergiaService.atualizarPorId(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        fonteEnergiaService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}

