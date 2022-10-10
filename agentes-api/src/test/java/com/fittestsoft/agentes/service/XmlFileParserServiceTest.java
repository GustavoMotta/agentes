package com.fittestsoft.agentes.service;

import com.fittestsoft.agentes.dto.UploadedFileDTO;
import com.fittestsoft.agentes.exception.FileParseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;

@SpringBootTest
class XmlFileParserServiceTest {

    @Autowired
    private XmlFileParserService parserService;

    @MockBean
    private LogService logService;

    @Test
    public void shouldLogCodigoAgente() {
        parserService.parse(UploadedFileDTO.of(4019L, "exemplo.xml", Paths.get("src/test/resources/xml/").toString()));
        then(this.logService).should().info("Agente: 1");
    }

    @Test
    public void shouldLogFalha() {
        Exception exception = assertThrows(FileParseException.class, () -> {
            parserService.parse(UploadedFileDTO.of(4019L, "exemplo-falha.xml", Paths.get("src/test/resources/xml/").toString()));
            then(this.logService).should().error("Falha ao realizar o parse do arquivo", any());
        });
        assertEquals("Falha ao realizar o parse do arquivo", exception.getMessage());
    }
}