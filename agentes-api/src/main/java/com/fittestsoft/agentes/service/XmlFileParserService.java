package com.fittestsoft.agentes.service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fittestsoft.agentes.dto.AgentesXmlDTO;
import com.fittestsoft.agentes.dto.UploadedFileDTO;
import com.fittestsoft.agentes.exception.FileParseException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Paths;

@Service
public class XmlFileParserService implements FileParserService {

    private final LogService logService;

    public XmlFileParserService(LogService logService) {
        this.logService = logService;
    }

    @Override
    public void parse(UploadedFileDTO bean) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            AgentesXmlDTO value = xmlMapper.readValue(Paths.get(bean.getPath(), bean.getName()).toFile(), AgentesXmlDTO.class);
            value.getAgente().forEach(agente -> logService.info(String.format("Agente: %d", agente.getCodigo())));
        } catch (IOException e) {
            logService.error("Falha ao realizar o parse do arquivo", e);
            throw new FileParseException("Falha ao realizar o parse do arquivo");
        }
    }
}
