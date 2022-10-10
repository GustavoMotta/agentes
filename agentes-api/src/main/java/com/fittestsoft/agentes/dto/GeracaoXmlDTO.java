package com.fittestsoft.agentes.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.List;

public class GeracaoXmlDTO {

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Double> valor;

    public GeracaoXmlDTO() {
    }

    public GeracaoXmlDTO(List<Double> valor) {
        this.valor = valor;
    }

    public List<Double> getValor() {
        return valor;
    }

    public void setValor(List<Double> valor) {
        this.valor = valor;
    }
}
