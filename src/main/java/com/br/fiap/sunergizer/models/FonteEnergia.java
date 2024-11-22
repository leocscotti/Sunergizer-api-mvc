package com.br.fiap.sunergizer.models;

import jakarta.persistence.*;

@Entity
@Table(name= "tb_fontes_energia")
public class FonteEnergia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "tp_fonte_energia")
    private String tipo;

    @Column(name= "ds_fonte_energia")
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
