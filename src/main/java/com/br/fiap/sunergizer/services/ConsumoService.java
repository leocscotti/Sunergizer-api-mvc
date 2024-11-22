package com.br.fiap.sunergizer.services;

import com.br.fiap.sunergizer.dto.ConsumoRequest;
import com.br.fiap.sunergizer.dto.ConsumoResponse;
import com.br.fiap.sunergizer.models.Cliente;
import com.br.fiap.sunergizer.models.Consumo;
import com.br.fiap.sunergizer.models.FonteEnergia;
import com.br.fiap.sunergizer.repository.ClienteRepository;
import com.br.fiap.sunergizer.repository.ConsumoRepository;
import com.br.fiap.sunergizer.repository.FonteEnergiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsumoService {

    @Autowired
    private ConsumoRepository consumoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private FonteEnergiaRepository fonteRepository;

    public List<ConsumoResponse> obterTodos() {
        List<Consumo> consumos = consumoRepository.findAll();
        return consumos.stream()
                .map(this::mapearParaResponse)
                .collect(Collectors.toList());
    }

    public ConsumoResponse obterPorId(Long id) {
        Consumo consumo = consumoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consumo não encontrado"));
        return mapearParaResponse(consumo);
    }

    public ConsumoResponse adicionar(ConsumoRequest request) {
        Cliente cliente = clienteRepository.findById(request.getIdCliente())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        FonteEnergia fonte = fonteRepository.findById(request.getIdFonte())
                .orElseThrow(() -> new RuntimeException("Fonte não encontrada"));

        Consumo consumo = new Consumo();
        consumo.setCliente(cliente);
        consumo.setFonte(fonte);
        consumo.setDataRegistro(request.getDataRegistro());
        consumo.setKwhConsumidos(request.getKwhConsumidos());

        consumo = consumoRepository.save(consumo);
        return mapearParaResponse(consumo);
    }

    public ConsumoResponse atualizarPorId(Long id, ConsumoRequest request) {
        Consumo consumo = consumoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consumo não encontrado"));

        Cliente cliente = clienteRepository.findById(request.getIdCliente())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        FonteEnergia fonte = fonteRepository.findById(request.getIdFonte())
                .orElseThrow(() -> new RuntimeException("Fonte não encontrada"));

        consumo.setCliente(cliente);
        consumo.setFonte(fonte);
        consumo.setDataRegistro(request.getDataRegistro());
        consumo.setKwhConsumidos(request.getKwhConsumidos());

        consumo = consumoRepository.save(consumo);
        return mapearParaResponse(consumo);
    }

    public void deletarPorId(Long id) {
        Consumo consumo = consumoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consumo não encontrado"));
        consumoRepository.delete(consumo);
    }

    private ConsumoResponse mapearParaResponse(Consumo consumo) {
        ConsumoResponse response = new ConsumoResponse();
        response.setId(consumo.getId());
        response.setIdCliente(consumo.getCliente().getId());
        response.setNomeCliente(consumo.getCliente().getNome());
        response.setIdFonte(consumo.getFonte().getId());
        response.setTipoFonte(consumo.getFonte().getTipo());
        response.setDataRegistro(consumo.getDataRegistro());
        response.setKwhConsumidos(consumo.getKwhConsumidos());
        return response;
    }
}

