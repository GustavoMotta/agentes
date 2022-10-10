package com.fittestsoft.agentes.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class RegiaoXmlDTO {

    @JacksonXmlProperty(isAttribute = true)
    private String sigla;

    private GeracaoXmlDTO geracao;

    private CompraXmlDTO compra;

    private PrecoMedioXmlDTO precoMedio;

    public RegiaoXmlDTO() {
    }

    public RegiaoXmlDTO(String sigla, GeracaoXmlDTO geracao, CompraXmlDTO compra, PrecoMedioXmlDTO precoMedio) {
        this.sigla = sigla;
        this.geracao = geracao;
        this.compra = compra;
        this.precoMedio = precoMedio;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public GeracaoXmlDTO getGeracao() {
        return geracao;
    }

    public void setGeracao(GeracaoXmlDTO geracao) {
        this.geracao = geracao;
    }

    public CompraXmlDTO getCompra() {
        return compra;
    }

    public void setCompra(CompraXmlDTO compra) {
        this.compra = compra;
    }

    public PrecoMedioXmlDTO getPrecoMedio() {
        return precoMedio;
    }

    public void setPrecoMedio(PrecoMedioXmlDTO precoMedio) {
        this.precoMedio = precoMedio;
    }
}
