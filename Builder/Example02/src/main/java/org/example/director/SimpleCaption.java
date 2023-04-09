package org.example.director;

import org.example.Rotation;
import org.example.director.builder.CaptionBuilder;

import java.awt.Color;
import java.awt.Font;

public class SimpleCaption {
    private final String caption;
    private final String font;
    private final int fontStyle;
    private final int size;
    private final Color color;
    private final Rotation rotation;

    private SimpleCaption(CaptionBuilderImpl builder) {
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

        public SimpleCaption build() {
            return new SimpleCaption(this);
        }
    }
}
