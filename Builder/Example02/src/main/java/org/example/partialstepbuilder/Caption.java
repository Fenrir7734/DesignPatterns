package org.example.partialstepbuilder;

import org.example.Rotation;
import org.example.partialstepbuilder.builder.AlphaStep;
import org.example.partialstepbuilder.builder.CaptionBuilder;

import java.awt.*;

public class Caption {
    private final String caption;
    private final String font;
    private final int fontStyle;
    private final int size;
    private final Color color;
    private final Rotation rotation;
    private final int alphaRule;
    private final float alpha;

    private Caption(CaptionBuilderImpl builder) {
        this.caption = builder.caption;
        this.font = builder.font;
        this.fontStyle = builder.fontStyle;
        this.size = builder.size;
        this.color = builder.color;
        this.rotation = builder.rotation;
        this.alphaRule = builder.alphaRule;
        this.alpha = builder.alpha;

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
        private int alphaRule = AlphaComposite.SRC_OVER;
        private float alpha = 1.0f;

        public CaptionBuilderImpl(String caption) {
            this.caption = caption;
        }

        @Override
        public CaptionBuilderImpl font(String font) {
            this.font = font;
            return this;
        }

        @Override
        public CaptionBuilderImpl fontStyle(int fontStyle) {
            this.fontStyle = fontStyle;
            return this;
        }

        @Override
        public CaptionBuilderImpl size(int size) {
            this.size = size;
            return this;
        }

        @Override
        public CaptionBuilderImpl color(Color color) {
            this.color = color;
            return this;
        }

        @Override
        public CaptionBuilderImpl rotate(double theta, double x, double y) {
            return rotate(new Rotation(theta, x, y));
        }

        @Override
        public CaptionBuilderImpl rotate(Rotation rotation) {
            this.rotation = rotation;
            return this;
        }

        @Override
        public AlphaStep alphaRule(int rule) {
            this.alphaRule = rule;
            return this;
        }

        @Override
        public CaptionBuilder alpha(float alpha) {
            this.alpha = alpha;
            return this;
        }

        @Override
        public Caption build() {
            return new Caption(this);
        }
    }
}
