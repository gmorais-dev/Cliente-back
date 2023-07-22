package com.cliente.aplicacao.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class telefone {
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonIgnoreProperties("telefone")
    private Cliente cliente;
    private long id;
    private int numero;
    private int ddd;
}
