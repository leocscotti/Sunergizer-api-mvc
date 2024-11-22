package com.br.fiap.sunergizer.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_consumos")
public class Consumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_fonte", nullable = false)
    private FonteEnergia fonte;

    @Column(name = "dt_registro")
    private LocalDateTime dataRegistro;

    @Column(name = "kwh_consumidos")
    private Double kwhConsumidos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public FonteEnergia getFonte() {
        return fonte;
    }

    public void setFonte(FonteEnergia fonte) {
        this.fonte = fonte;
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

