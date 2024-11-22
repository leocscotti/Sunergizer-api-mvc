package com.br.fiap.sunergizer.services;

import com.br.fiap.sunergizer.dto.ClienteRequest;
import com.br.fiap.sunergizer.dto.ClienteResponse;
import com.br.fiap.sunergizer.models.Cliente;
import com.br.fiap.sunergizer.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteResponse> obterTodos() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(this::mapearParaResponse)
                .collect(Collectors.toList());
    }

    public ClienteResponse obterPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return mapearParaResponse(cliente);
    }

    public ClienteResponse adicionar(ClienteRequest request) {
        Cliente cliente = new Cliente();
        cliente.setNome(request.getNome());
        cliente.setEmail(request.getEmail());
        cliente.setEndereco(request.getEndereco());
        cliente.setDataCadastro(request.getDataCadastro());

        cliente = clienteRepository.save(cliente);
        return mapearParaResponse(cliente);
    }

    public ClienteResponse atualizarPorId(Long id, ClienteRequest request) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        cliente.setNome(request.getNome());
        cliente.setEmail(request.getEmail());
        cliente.setEndereco(request.getEndereco());
        cliente.setDataCadastro(request.getDataCadastro());

        cliente = clienteRepository.save(cliente);
        return mapearParaResponse(cliente);
    }

    public void deletarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        clienteRepository.delete(cliente);
    }

    private ClienteResponse mapearParaResponse(Cliente cliente) {
        ClienteResponse response = new ClienteResponse();
        response.setId(cliente.getId());
        response.setNome(cliente.getNome());
        response.setEndereco(cliente.getEndereco());
        response.setEmail(cliente.getEmail());
        response.setDataCadastro(cliente.getDataCadastro());
        return response;
    }
}

