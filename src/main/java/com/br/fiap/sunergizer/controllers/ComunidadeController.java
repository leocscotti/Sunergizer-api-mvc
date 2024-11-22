package com.br.fiap.sunergizer.controllers;

import com.br.fiap.sunergizer.dto.ComunidadeRequest;
import com.br.fiap.sunergizer.dto.ComunidadeResponse;
import com.br.fiap.sunergizer.services.ComunidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comunidades")
public class ComunidadeController {

    @Autowired
    private ComunidadeService comunidadeService;

    @GetMapping
    public ResponseEntity<List<ComunidadeResponse>> obterTodas() {
        return ResponseEntity.ok(comunidadeService.obterTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComunidadeResponse> obterPorId(@PathVariable Long id) {
        return ResponseEntity.ok(comunidadeService.obterPorId(id));
    }

    @PostMapping
    public ResponseEntity<ComunidadeResponse> criar(@Validated @RequestBody ComunidadeRequest request) {
        ComunidadeResponse response = comunidadeService.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComunidadeResponse> atualizar(@PathVariable Long id,
                                                        @Validated @RequestBody ComunidadeRequest request) {
        return ResponseEntity.ok(comunidadeService.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        comunidadeService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

