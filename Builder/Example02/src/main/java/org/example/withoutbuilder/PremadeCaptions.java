package org.example.withoutbuilder;

import org.example.Rotation;

import java.awt.Color;
import java.awt.Font;

public class PremadeCaptions {
    public Caption defaultCaption(String text) {
        return new Caption(text, null, null, null, null, null);
    }

    public Caption handwrittenCaption(String text) {
        return new Caption(text, "Bradley Hand ITC TT", null, 36, null, null);
    }

    public Caption stylisedCaption(String text) {
        return new Caption(text, "Algerian", Font.BOLD, 36, Color.RED, new Rotation(0.5, 0, 0));
    }

    public Caption comicCaption(String text) {
        return new Caption(text, "Comic Sans MS", Font.BOLD, 24, null, null);
    }
}


