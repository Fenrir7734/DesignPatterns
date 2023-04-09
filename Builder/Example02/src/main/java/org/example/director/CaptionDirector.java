package org.example.director;


import org.example.director.builder.CaptionBuilder;

import java.awt.Color;
import java.awt.Font;

public class CaptionDirector {

    public void handwrittenCaption(CaptionBuilder captionBuilder) {
        captionBuilder
                .color(Color.BLUE)
                .font("Bradley Hand ITC TT")
                .size(36);
    }

    public void stylisedCaption(CaptionBuilder captionBuilder) {
        captionBuilder
                .color(Color.RED)
                .font("Algerian")
                .fontStyle(Font.BOLD)
                .size(36)
                .rotate(0.5, 0, 0);
    }

    public void comicCaption(CaptionBuilder captionBuilder) {
        captionBuilder
                .font("Comic Sans MS")
                .fontStyle(Font.BOLD)
                .size(24);
    }
}
