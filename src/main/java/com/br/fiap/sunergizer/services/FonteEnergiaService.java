package com.br.fiap.sunergizer.services;

import com.br.fiap.sunergizer.dto.FonteEnergiaRequest;
import com.br.fiap.sunergizer.dto.FonteEnergiaResponse;
import com.br.fiap.sunergizer.models.FonteEnergia;
import com.br.fiap.sunergizer.repository.FonteEnergiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FonteEnergiaService {

    @Autowired
    private FonteEnergiaRepository fonteEnergiaRepository;

    public List<FonteEnergiaResponse> obterTodas() {
        List<FonteEnergia> fontes = fonteEnergiaRepository.findAll();
        return fontes.stream()
                .map(this::mapearParaResponse)
                .collect(Collectors.toList());
    }

    public FonteEnergiaResponse obterPorId(Long id) {
        FonteEnergia fonte = fonteEnergiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fonte de energia não encontrada"));
        return mapearParaResponse(fonte);
    }

    public FonteEnergiaResponse adicionar(FonteEnergiaRequest request) {
        FonteEnergia fonte = new FonteEnergia();
        fonte.setTipo(request.getTipo());
        fonte.setDescricao(request.getDescricao());

        fonte = fonteEnergiaRepository.save(fonte);
        return mapearParaResponse(fonte);
    }

    public FonteEnergiaResponse atualizarPorId(Long id, FonteEnergiaRequest request) {
        FonteEnergia fonte = fonteEnergiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fonte de energia não encontrada"));

        fonte.setTipo(request.getTipo());
        fonte.setDescricao(request.getDescricao());

        fonte = fonteEnergiaRepository.save(fonte);
        return mapearParaResponse(fonte);
    }

    public void deletarPorId(Long id) {
        FonteEnergia fonte = fonteEnergiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fonte de energia não encontrada"));
        fonteEnergiaRepository.delete(fonte);
    }

    // Método auxiliar para mapear FonteEnergia para FonteEnergiaResponse
    private FonteEnergiaResponse mapearParaResponse(FonteEnergia fonte) {
        FonteEnergiaResponse response = new FonteEnergiaResponse();
        response.setId(fonte.getId());
        response.setTipo(fonte.getTipo());
        response.setDescricao(fonte.getDescricao());
        return response;
    }
}

