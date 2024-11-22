package com.br.fiap.sunergizer.dto;

import java.time.LocalDateTime;

public class ConsumoResponse {

    private Long id;
    private Long idCliente;
    private String nomeCliente;
    private Long idFonte;
    private String tipoFonte;
    private LocalDateTime dataRegistro;
    private Double kwhConsumidos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Long getIdFonte() {
        return idFonte;
    }

    public void setIdFonte(Long idFonte) {
        this.idFonte = idFonte;
    }

    public String getTipoFonte() {
        return tipoFonte;
    }

    public void setTipoFonte(String tipoFonte) {
        this.tipoFonte = tipoFonte;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Double getKwhConsumidos() {
        return kwhConsumidos;
    }

    public void setKwhConsumidos(Double kwhConsumidos) {
        this.kwhConsumidos = kwhConsumidos;
    }
}

