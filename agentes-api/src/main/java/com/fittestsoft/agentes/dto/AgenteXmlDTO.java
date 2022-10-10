package com.fittestsoft.agentes.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.Date;
import java.util.List;

public class AgenteXmlDTO {

    private Integer codigo;

    private Date data;

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<RegiaoXmlDTO> regiao;

    public AgenteXmlDTO() {
    }

    public AgenteXmlDTO(Integer codigo, Date data, List<RegiaoXmlDTO> regiao) {
        this.codigo = codigo;
        this.data = data;
        this.regiao = regiao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<RegiaoXmlDTO> getRegiao() {
        return regiao;
    }

    public void setRegiao(List<RegiaoXmlDTO> regiao) {
        this.regiao = regiao;
    }
}
