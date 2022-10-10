package com.fittestsoft.agentes.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.List;

public class CompraXmlDTO {

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Double> valor;

    public CompraXmlDTO() {
    }

    public CompraXmlDTO(List<Double> valor) {
        this.valor = valor;
    }

    public List<Double> getValor() {
        return valor;
    }

    public void setValor(List<Double> valor) {
        this.valor = valor;
    }
}
