package com.br.fiap.sunergizer.dto;

import jakarta.validation.constraints.NotBlank;

public class FonteEnergiaRequest {

    @NotBlank(message= "O tipo da fonte de energia é obrigatório")
    private String tipo;

    @NotBlank(message = "a descricao da fonte da energia é obrigatória")
    private String descricao;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
