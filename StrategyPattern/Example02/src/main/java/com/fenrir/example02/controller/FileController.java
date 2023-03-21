package com.fenrir.example02.controller;

import com.fenrir.example02.generator.GeneratorType;
import com.fenrir.example02.generator.model.DataModel;
import com.fenrir.example02.service.FileService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@RestController
@RequestMapping("/api/file")
@RequiredArgsConstructor
class FileController {
    private static final String CONTENT_DISPOSITION_HEADER_NAME = "Content-Disposition";
    private static final String CONTENT_DISPOSITION_HEADER_ZIP_VALUE = "attachment; filename=\"raport.zip\"";

    private final FileService fileService;

    @PostMapping(produces = "application/zip")
    void generateFile(
            @RequestBody DataModel dataModel,
            @RequestParam("type") List<GeneratorType> types,
            HttpServletResponse response) throws IOException {

        byte[] content = fileService.generateFile(dataModel, types);

        response.setStatus(HttpServletResponse.SC_OK);
        response.addHeader(CONTENT_DISPOSITION_HEADER_NAME, CONTENT_DISPOSITION_HEADER_ZIP_VALUE);
        response.setContentLength(content.length);

        try (OutputStream out = response.getOutputStream()) {
            out.write(content, 0, content.length);
        }
    }
}
