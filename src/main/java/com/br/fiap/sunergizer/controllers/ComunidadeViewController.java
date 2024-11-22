package com.br.fiap.sunergizer.controllers;

import com.br.fiap.sunergizer.dto.ComunidadeRequest;
import com.br.fiap.sunergizer.dto.ComunidadeResponse;
import com.br.fiap.sunergizer.services.ComunidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/view/comunidades")
public class ComunidadeViewController {

    @Autowired
    private ComunidadeService comunidadeService;

    @GetMapping
    public String listarComunidades(Model model) {
        model.addAttribute("comunidades", comunidadeService.obterTodas());
        return "comunidade/list";
    }

    @GetMapping("/novo")
    public String novaComunidade(Model model) {
        model.addAttribute("comunidade", new ComunidadeRequest());
        return "comunidade/form";
    }

    @PostMapping
    public String salvarComunidade(@ModelAttribute ComunidadeRequest comunidadeRequest) {
        comunidadeService.criar(comunidadeRequest);
        return "redirect:/view/comunidades";
    }

    @GetMapping("/editar/{id}")
    public String editarComunidade(@PathVariable Long id, Model model) {
        ComunidadeResponse comunidade = comunidadeService.obterPorId(id);
        model.addAttribute("comunidade", comunidade);
        return "comunidade/form";
    }

    @GetMapping("/deletar/{id}")
    public String deletarComunidade(@PathVariable Long id) {
        comunidadeService.deletar(id);
        return "redirect:/view/comunidades";
    }
}
