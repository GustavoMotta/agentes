package com.fittestsoft.agentes.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import java.io.FileInputStream;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
class FileControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldUploadFile() throws Exception {
        MockMultipartFile multipartFile = new MockMultipartFile("file", "exemplo.xml",
                "text/xml", new FileInputStream(Paths.get("src/test/resources/xml/exemplo.xml").toFile()));
        this.mvc.perform(multipart("/api/files").file(multipartFile))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json("{\"size\":4019,\"name\":\"exemplo.xml\"}"));
    }

    @Test
    public void shouldNotUploadFileWrongType() throws Exception {
        MockMultipartFile multipartFile = new MockMultipartFile("file", "exemplo.txt",
                "plain/text", new FileInputStream(Paths.get("src/test/resources/xml/exemplo.txt").toFile()));
        this.mvc.perform(multipart("/api/files").file(multipartFile))
                .andExpect(status().is5xxServerError())
                .andExpect(content().json("{\"message\":\"Arquivo com formato inválido\"}"));
    }
}