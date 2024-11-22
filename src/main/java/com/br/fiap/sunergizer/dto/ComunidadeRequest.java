package com.br.fiap.sunergizer.dto;

import jakarta.validation.constraints.*;

public class ComunidadeRequest {

    @NotBlank(message = "O nome da comunidade é obrigatório")
    private String nome;

    @NotBlank(message = "A cidade é obrigatória")
    private String cidade;

    @Size(max=2, message = "A UF deve seguir o padrão de unidade federativa, ex: SP")
    @NotBlank(message = "A UF é obrigatória")
    private String uf;

    @Min(value= 2, message = "A comunidade deve ter no mínimo 2 pessoas")
    @NotBlank(message = "O número total de pessoas na comunidade é obrigatório")
    private int totalPessoas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getTotalPessoas() {
        return totalPessoas;
    }

    public void setTotalPessoas(int totalPessoas) {
        this.totalPessoas = totalPessoas;
    }
}
