package org.example.withoutbuilder;

import org.example.Rotation;

import java.awt.Color;
import java.awt.Font;

public class Caption {
    private final String caption;
    private String font = "Arial";
    private int fontStyle = Font.PLAIN;
    private int size = 46;
    private Color color = Color.BLACK;
    private Rotation rotation = new Rotation(0, 0, 0);

    public Caption(String caption, String font, Integer fontStyle, Integer size, Color color, Rotation rotation) {
        this.caption = caption;
        this.font = font != null ? font : this.font;
        this.fontStyle = fontStyle != null ? fontStyle : this.fontStyle;
        this.size = size != null ? size : this.size;
        this.color = color != null ? color : this.color;
        this.rotation = rotation != null ? rotation : this.rotation;

        validate();
    }

    private void validate() {
        if (this.size < 12 || this.size > 64) {
            throw new IllegalArgumentException("Font size must be a number in the inclusive range [12, 64]");
        }

        // some more validation
    }

    // some methods here
}


