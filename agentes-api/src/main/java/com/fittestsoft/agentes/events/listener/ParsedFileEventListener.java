package com.fittestsoft.agentes.events.listener;

import com.fittestsoft.agentes.events.ParsedFileEvent;
import com.fittestsoft.agentes.service.FileService;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ParsedFileEventListener implements ApplicationListener<ParsedFileEvent> {

    private final FileService fileService;

    public ParsedFileEventListener(FileService fileService) {
        this.fileService = fileService;
    }

    @Override
    public void onApplicationEvent(ParsedFileEvent event) {
        fileService.remove(event.getBean());
    }
}
