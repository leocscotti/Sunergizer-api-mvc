package com.br.fiap.sunergizer.services;

import com.br.fiap.sunergizer.dto.ComunidadeRequest;
import com.br.fiap.sunergizer.dto.ComunidadeResponse;
import com.br.fiap.sunergizer.models.Comunidade;
import com.br.fiap.sunergizer.repository.ComunidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComunidadeService {

    @Autowired
    private ComunidadeRepository comunidadeRepository;

    public List<ComunidadeResponse> obterTodas() {
        return comunidadeRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public ComunidadeResponse obterPorId(Long id) {
        Comunidade comunidade = comunidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comunidade não encontrada com ID: " + id));
        return toResponse(comunidade);
    }

    public ComunidadeResponse criar(ComunidadeRequest request) {
        Comunidade comunidade = new Comunidade();
        comunidade.setNome(request.getNome());
        comunidade.setCidade(request.getCidade());
        comunidade.setUf(request.getUf());
        comunidade.setTotalPessoas(request.getTotalPessoas());

        Comunidade comunidadeSalva = comunidadeRepository.save(comunidade);
        return toResponse(comunidadeSalva);
    }

    public ComunidadeResponse atualizar(Long id, ComunidadeRequest request) {
        Comunidade comunidade = comunidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comunidade não encontrada com ID: " + id));

        comunidade.setNome(request.getNome());
        comunidade.setCidade(request.getCidade());
        comunidade.setUf(request.getUf());
        comunidade.setTotalPessoas(request.getTotalPessoas());

        Comunidade comunidadeAtualizada = comunidadeRepository.save(comunidade);
        return toResponse(comunidadeAtualizada);
    }

    public void deletar(Long id) {
        Comunidade comunidade = comunidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comunidade não encontrada com ID: " + id));
        comunidadeRepository.delete(comunidade);
    }

    private ComunidadeResponse toResponse(Comunidade comunidade) {
        ComunidadeResponse response = new ComunidadeResponse();
        response.setId(comunidade.getId());
        response.setNome(comunidade.getNome());
        response.setCidade(comunidade.getCidade());
        response.setUf(comunidade.getUf());
        response.setTotalPessoas(comunidade.getTotalPessoas());
        return response;
    }
}

