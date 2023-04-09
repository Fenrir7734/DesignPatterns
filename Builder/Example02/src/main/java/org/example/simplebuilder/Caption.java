package org.example.simplebuilder;

import org.example.Rotation;

import java.awt.Color;
import java.awt.Font;

public class Caption {
    private final String caption;
    private final String font;
    private final int fontStyle;
    private final int size;
    private final Color color;
    private final Rotation rotation;

    public Caption(CaptionBuilder builder) {
        this.caption = builder.caption;
        this.font = builder.font;
        this.fontStyle = builder.fontStyle;
        this.size = builder.size;
        this.color = builder.color;
        this.rotation = builder.rotation;

        validate();
    }

    private void validate() {
        if (this.size < 12 || this.size > 64) {
            throw new IllegalArgumentException("Font size must be a number in the inclusive range [12, 64]");
        }

        // some more validation
    }

    public static CaptionBuilder builder(String text) {
        return new CaptionBuilder(text);
    }

    // some methods here

    public static class CaptionBuilder {
        private final String caption;
        private String font = "Arial";
        private int fontStyle = Font.PLAIN;
        private int size = 46;
        private Color color = Color.BLACK;
        private Rotation rotation = new Rotation(0, 0, 0);

        public CaptionBuilder(String caption) {
            this.caption = caption;
        }

        public CaptionBuilder font(String font) {
            this.font = font;
            return this;
        }

        public CaptionBuilder fontStyle(int fontStyle) {
            this.fontStyle = fontStyle;
            return this;
        }

        public CaptionBuilder size(int size) {
            this.size = size;
            return this;
        }

        public CaptionBuilder color(Color color) {
            this.color = color;
            return this;
        }

        public CaptionBuilder rotate(double theta, double x, double y) {
            return rotate(new Rotation(theta, x, y));
        }

        public CaptionBuilder rotate(Rotation rotation) {
            this.rotation = rotation;
            return this;
        }

        public Caption build() {
            return new Caption(this);
        }
    }
}
