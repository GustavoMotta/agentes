package com.fittestsoft.agentes.events;

import com.fittestsoft.agentes.dto.UploadedFileDTO;
import org.springframework.context.ApplicationEvent;

public class UploadedFileEvent extends ApplicationEvent {

    private final UploadedFileDTO bean;

    public UploadedFileEvent(Object source, UploadedFileDTO bean) {
        super(source);
        this.bean = bean;
    }

    public UploadedFileDTO getBean() {
        return bean;
    }
}
