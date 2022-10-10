package com.fittestsoft.agentes.service;

import com.fittestsoft.agentes.dto.UploadedFileDTO;
import com.fittestsoft.agentes.events.UploadedFileEvent;
import com.fittestsoft.agentes.exception.FileRemoveException;
import com.fittestsoft.agentes.exception.FileUploadException;
import com.fittestsoft.agentes.exception.InvalidFileTypeException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.UUID;

@Service
public class FileService {

    private final ApplicationEventPublisher eventPublisher;

    @Value("${file.upload.directory.name}")
    private String directory;

    @Value("${file.upload.validTypes}")
    private String validTypes;

    @Value("${file.upload.directory.createDynamic}")
    private boolean createDynamicDirectory;

    public FileService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public UploadedFileDTO upload(MultipartFile multipartFile) {
        try (InputStream inputStream = multipartFile.getInputStream()) {
            String fileName = getFileName(multipartFile);
            validateFileType(multipartFile.getContentType());
            Path uploadPath = getUploadDirPath();
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            long size = multipartFile.getSize();
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            UploadedFileDTO bean = UploadedFileDTO.of(size, fileName, uploadPath.toString());
            eventPublisher.publishEvent(new UploadedFileEvent(this, bean));
            return bean;
        } catch (IOException ioe) {
            throw new FileUploadException("Falha ao realizar upload.");
        }
    }

    public void remove(UploadedFileDTO bean) {
        try {
            Files.deleteIfExists(Paths.get(bean.getPath(), bean.getName()));
            if (createDynamicDirectory) {
                Files.deleteIfExists(Paths.get(bean.getPath()));
            }
        } catch (IOException e) {
            throw new FileUploadException("Falha ao remover arquivo.");
        }
    }

    private String getFileName(MultipartFile multipartFile) {
        return StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
    }

    private Path getUploadDirPath() {
        if (createDynamicDirectory) {
            return Paths.get(directory + "/" + UUID.randomUUID());
        }
        return Paths.get(directory);
    }

    private void validateFileType(String fileType) {
        if (!validTypes.contains(fileType)) {
            throw new InvalidFileTypeException("Arquivo com formato inválido");
        }
    }
}
