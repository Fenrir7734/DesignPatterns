package org.example.director;

import org.example.Rotation;
import org.example.director.builder.CaptionBuilder;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;

public class ImageCaption {
    private final String caption;
    private final Color color;
    private final Font font;
    private final Rotation rotation;

    private ImageCaption(CaptionBuilderImpl builder) {
        this.caption = builder.caption;
        this.font = new Font(builder.font, builder.fontStyle, builder.size);
        this.rotation = builder.rotation;
        this.color = builder.color;

        validate();
    }

    private void validate() {
        if (this.font.getSize() < 36 || this.font.getSize() > 128) {
            throw new IllegalArgumentException("Font size must be a number in the inclusive range [36, 128]");
        }

        // some more validation
    }

    public static CaptionBuilderImpl builder(String text) {
        return new CaptionBuilderImpl(text);
    }

    // some methods here

    public static class CaptionBuilderImpl implements CaptionBuilder {
        private final String caption;
        private String font = "Arial";
        private int fontStyle = Font.PLAIN;
        private int size = 46;
        private Color color = Color.BLACK;
        private Rotation rotation = new Rotation(0, 0, 0);
        private int alphaRule = AlphaComposite.SRC_OVER;
        private float alpha = 1.0f;

        public CaptionBuilderImpl(String caption) {
            this.caption = caption;
        }

        @Override
        public CaptionBuilder font(String font) {
            this.font = font;
            return this;
        }

        @Override
        public CaptionBuilder fontStyle(int fontStyle) {
            this.fontStyle = fontStyle;
            return this;
        }

        @Override
        public CaptionBuilder size(int size) {
            this.size = size;
            return this;
        }

        @Override
        public CaptionBuilder color(Color color) {
            this.color = color;
            return this;
        }

        @Override
        public CaptionBuilder rotate(double theta, double x, double y) {
            return rotate(new Rotation(theta, x, y));
        }

        @Override
        public CaptionBuilder rotate(Rotation rotation) {
            this.rotation = rotation;
            return this;
        }

        public ImageCaption build() {
            return new ImageCaption(this);
        }
    }
}
