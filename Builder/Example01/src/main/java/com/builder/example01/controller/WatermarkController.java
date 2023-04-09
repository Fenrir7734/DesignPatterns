package com.builder.example01.controller;

import com.builder.example01.service.WatermarkService;
import com.builder.example01.watermark.caption.CaptionStyle;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;

@RestController
@RequestMapping("/api/watermark")
@RequiredArgsConstructor
class WatermarkController {
    private static final String CONTENT_DISPOSITION_HEADER_NAME = "Content-Disposition";
    private static final String CONTENT_DISPOSITION_HEADER_PNG_VALUE = "attachment; filename=\"img.png\"";

    private final WatermarkService watermarkService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    void addWatermark(
            @RequestParam("image") MultipartFile multipartFile,
            @RequestParam(value = "text") String text,
            @RequestParam(value = "style", required = false) CaptionStyle style,
            HttpServletResponse response) throws IOException {

        byte[] content = watermarkService.writeWatermark(multipartFile.getBytes(), text, style);

        response.setStatus(HttpServletResponse.SC_OK);
        response.addHeader(CONTENT_DISPOSITION_HEADER_NAME, CONTENT_DISPOSITION_HEADER_PNG_VALUE);
        response.setContentLength(content.length);

        try (OutputStream out = response.getOutputStream()) {
            out.write(content, 0, content.length);
        }
    }
}
