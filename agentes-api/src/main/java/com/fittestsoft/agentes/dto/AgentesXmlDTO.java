package com.fittestsoft.agentes.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "agentes")
public class AgentesXmlDTO {

    @JacksonXmlProperty(isAttribute = true)
    private String versao;

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<AgenteXmlDTO> agente;

    public AgentesXmlDTO() {
    }

    public AgentesXmlDTO(String versao, List<AgenteXmlDTO> agente) {
        this.versao = versao;
        this.agente = agente;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public List<AgenteXmlDTO> getAgente() {
        return agente;
    }

    public void setAgente(List<AgenteXmlDTO> agente) {
        this.agente = agente;
    }
}
