package com.br.fiap.sunergizer.controllers;

import com.br.fiap.sunergizer.dto.ClienteRequest;
import com.br.fiap.sunergizer.dto.ClienteResponse;
import com.br.fiap.sunergizer.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/view/clientes")
public class ClienteViewController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteService.obterTodos());
        return "cliente/list";
    }

    @GetMapping("/novo")
    public String novoCliente(Model model) {
        model.addAttribute("cliente", new ClienteRequest());
        return "cliente/form";
    }

    @PostMapping
    public String salvarCliente(@ModelAttribute ClienteRequest clienteRequest) {
        clienteService.adicionar(clienteRequest);
        return "redirect:/view/clientes";
    }

    @GetMapping("/editar/{id}")
    public String editarCliente(@PathVariable Long id, Model model) {
        ClienteResponse cliente = clienteService.obterPorId(id);
        model.addAttribute("cliente", cliente);
        return "cliente/form";
    }

    @GetMapping("/deletar/{id}")
    public String deletarCliente(@PathVariable Long id) {
        clienteService.deletarPorId(id);
        return "redirect:/view/clientes";
    }
}

