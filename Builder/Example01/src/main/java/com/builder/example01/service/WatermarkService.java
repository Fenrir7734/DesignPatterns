package com.builder.example01.service;

import com.builder.example01.watermark.WatermarkWriter;
import com.builder.example01.watermark.caption.CaptionStyle;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WatermarkService {
    private final WatermarkWriter watermarkWriter = new WatermarkWriter();

    public byte[] writeWatermark(byte[] bytes, String text, CaptionStyle style) throws IOException {
        return watermarkWriter.write(bytes, text, style);
    }
}
