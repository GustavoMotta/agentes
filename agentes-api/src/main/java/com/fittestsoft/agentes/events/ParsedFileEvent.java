package com.fittestsoft.agentes.events;

import com.fittestsoft.agentes.dto.UploadedFileDTO;
import org.springframework.context.ApplicationEvent;

public class ParsedFileEvent extends ApplicationEvent {

    private final UploadedFileDTO bean;

    public ParsedFileEvent(Object source, UploadedFileDTO bean) {
        super(source);
        this.bean = bean;
    }

    public UploadedFileDTO getBean() {
        return bean;
    }
}
