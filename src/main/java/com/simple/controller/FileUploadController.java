package com.simple.controller;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadController.class);

    private static final String FILE_DIRECTORY_PATH = "E:\\";

    @PostMapping(value = "/public/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public String uploadFile(@RequestPart("file") final MultipartFile[] files) throws IOException {
        LOGGER.info("Passing through file uploading controller...");
        return processFiles(files);
    }

    public String processFiles(MultipartFile[] files) throws IOException {
        final StringBuilder names = new StringBuilder("files: [");
        for (MultipartFile file : files) {
            file.transferTo(new File(FILE_DIRECTORY_PATH + file.getOriginalFilename()));
            LOGGER.info(file.getOriginalFilename());
            names.append(file.getOriginalFilename()).append(" ,");
        }
        return names.append("]").toString();
    }

}
