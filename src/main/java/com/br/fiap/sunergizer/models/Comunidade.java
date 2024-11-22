package com.br.fiap.sunergizer.models;

import jakarta.persistence.*;

@Entity
@Table(name= "tb_comunidades")

public class Comunidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "nm_comunidade")
    private String nome;

    @Column(name= "cidade")
    private String cidade;

    @Column(name= "uf")
    private String uf;

    @Column(name= "total_pessoas")
    private int totalPessoas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
