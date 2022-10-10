package com.fittestsoft.agentes.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UploadedFileDTO {
    private Long size;

    private String name;

    @JsonIgnore
    private String path;

    private UploadedFileDTO(Long size, String name, String path) {
        this.size = size;
        this.name = name;
        this.path = path;
    }

    public static UploadedFileDTO of(Long size, String name, String path) {
        return new UploadedFileDTO(size, name, path);
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
