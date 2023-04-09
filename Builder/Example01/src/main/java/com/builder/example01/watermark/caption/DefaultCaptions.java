package com.builder.example01.watermark.caption;

import java.awt.*;

public class DefaultCaptions {

    public Caption defaultCaption(String text) {
        return Caption.builder(text).build();
    }

    public Caption handwrittenCaption(String text) {
        return Caption.builder(text)
                .color(Color.BLUE)
                .font("Bradley Hand ITC TT")
                .size(36)
                .build();
    }

    public Caption stylisedCaption(String text) {
        return Caption.builder(text)
                .color(Color.RED)
                .font("Algerian")
                .fontStyle(Font.BOLD)
                .size(36)
                .rotate(0.5, 0, 0)
                .alphaRule(AlphaComposite.SRC_OVER)
                .alpha(0.5f)
                .build();
    }

    public Caption comicCaption(String text) {
        return Caption.builder(text)
                .font("Comic Sans MS")
                .fontStyle(Font.BOLD)
                .size(24)
                .build();
    }
}
