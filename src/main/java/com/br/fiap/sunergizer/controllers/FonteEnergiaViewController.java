package com.br.fiap.sunergizer.controllers;

import com.br.fiap.sunergizer.dto.FonteEnergiaRequest;
import com.br.fiap.sunergizer.dto.FonteEnergiaResponse;
import com.br.fiap.sunergizer.services.FonteEnergiaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/view/fontesenergia")
public class FonteEnergiaViewController {

    private final FonteEnergiaService fonteEnergiaService;

    public FonteEnergiaViewController(FonteEnergiaService fonteEnergiaService) {
        this.fonteEnergiaService = fonteEnergiaService;
    }

    @GetMapping
    public String listarFontesEnergia(Model model) {
        model.addAttribute("fontesenergia", fonteEnergiaService.obterTodas());
        return "fonteenergia/list";
    }

    @GetMapping("/nova")
    public String novaFonteEnergiaForm(Model model) {
        model.addAttribute("fonteEnergia", new FonteEnergiaRequest());
        return "fonteenergia/form";
    }

    @PostMapping
    public String salvarFonteEnergia(@ModelAttribute FonteEnergiaRequest fonteEnergia) {
        fonteEnergiaService.adicionar(fonteEnergia);
        return "redirect:/view/fontesenergia";
    }

    @GetMapping("/editar/{id}")
    public String editarFonteEnergiaForm(@PathVariable Long id, Model model) {
        FonteEnergiaResponse fonteEnergia = fonteEnergiaService.obterPorId(id);
        model.addAttribute("fonteEnergia", fonteEnergia);
        return "fonteenergia/form";
    }

    @PostMapping("/editar/{id}")
    public String atualizarFonteEnergia(@PathVariable Long id, @ModelAttribute FonteEnergiaRequest fonteEnergia) {
        fonteEnergiaService.atualizarPorId(id, fonteEnergia);
        return "redirect:/view/fontesenergia";
    }

    @GetMapping("/deletar/{id}")
    public String deletarFonteEnergia(@PathVariable Long id) {
        fonteEnergiaService.deletarPorId(id);
        return "redirect:/view/fontesenergia";
    }
}

