package com.builder.example01.watermark;

import com.builder.example01.watermark.caption.Caption;
import com.builder.example01.watermark.caption.CaptionFactory;
import com.builder.example01.watermark.caption.CaptionStyle;
import com.builder.example01.watermark.caption.Rotation;

import javax.imageio.ImageIO;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class WatermarkWriter {
    private final CaptionFactory captionFactory = new CaptionFactory();

    public byte[] write(byte[] bytes, String text, CaptionStyle style) throws IOException {
        BufferedImage image = readImage(bytes);
        writeText(image, text, style);
        return toByteArray(image);
    }

    private BufferedImage readImage(byte[] bytes) throws IOException {
        try (InputStream in = new ByteArrayInputStream(bytes)) {
            return ImageIO.read(in);
        }
    }

    private void writeText(BufferedImage image, String text, CaptionStyle style) {
        Graphics2D g2d = (Graphics2D) image.getGraphics();
        Caption caption = captionFactory.getCaption(style, text);

        configureCaptions(g2d, caption);

        Rectangle2D rect = getFontContainer(g2d, text);
        int x = calculateCaptionPosition(image.getWidth(), (int) rect.getWidth());
        int y = calculateCaptionPosition(image.getHeight(), (int) rect.getHeight());

        g2d.drawString(text, x, y);
    }

    private void configureCaptions(Graphics2D g2d, Caption caption) {
        g2d.setComposite(caption.getAlphaComposite());
        g2d.setColor(caption.getColor());
        g2d.setFont(caption.getFont());

        Rotation rotation = caption.getRotation();
        g2d.rotate(rotation.theta(), rotation.x(), rotation.y());
    }

    private Rectangle2D getFontContainer(Graphics2D g2d, String text) {
        FontMetrics fontMetrics = g2d.getFontMetrics();
        return fontMetrics.getStringBounds(text, g2d);
    }

    private int calculateCaptionPosition(int containerSize, int captionSize) {
        return (containerSize - captionSize) / 2;
    }

    private byte[] toByteArray(BufferedImage image) throws IOException {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            ImageIO.write(image, "png", out);
            return out.toByteArray();
        }
    }
}
