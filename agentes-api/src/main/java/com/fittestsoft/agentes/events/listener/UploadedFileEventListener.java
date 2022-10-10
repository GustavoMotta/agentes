package com.fittestsoft.agentes.events.listener;

import com.fittestsoft.agentes.events.ParsedFileEvent;
import com.fittestsoft.agentes.events.UploadedFileEvent;
import com.fittestsoft.agentes.service.XmlFileParserService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class UploadedFileEventListener implements ApplicationListener<UploadedFileEvent> {

    private final XmlFileParserService parserService;

    private final ApplicationEventPublisher eventPublisher;

    public UploadedFileEventListener(XmlFileParserService parserService, ApplicationEventPublisher eventPublisher) {
        this.parserService = parserService;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void onApplicationEvent(UploadedFileEvent event) {
        parserService.parse(event.getBean());
        eventPublisher.publishEvent(new ParsedFileEvent(this, event.getBean()));
    }
}
