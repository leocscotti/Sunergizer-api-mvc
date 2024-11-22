package com.br.fiap.sunergizer.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public class ConsumoRequest {

    @NotBlank(message = "o id do cliente é obrigatório")
    private Long idCliente;

    @NotBlank(message = "o id da fonte é obrigatória")
    private Long idFonte;

    private LocalDateTime dataRegistro;

    @Size(min= 2, message = "o consumo deve ter no mínimo 2 digitos")
    private Double kwhConsumidos;

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdFonte() {
        return idFonte;
    }

    public void setIdFonte(Long idFonte) {
        this.idFonte = idFonte;
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

