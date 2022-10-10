package com.fittestsoft.agentes.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class PrecoMedioXmlDTO {

    @JsonIgnore //Ignorado conforme requisito
    private List<Double> valor;

    public PrecoMedioXmlDTO() {
    }

    public PrecoMedioXmlDTO(List<Double> valor) {
        this.valor = valor;
    }

    public List<Double> getValor() {
        return valor;
    }

    public void setValor(List<Double> valor) {
        this.valor = valor;
    }
}
