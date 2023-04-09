package com.builder.example01.watermark.caption;

public class CaptionFactory {
    private final DefaultCaptions captions = new DefaultCaptions();

    public Caption getCaption(CaptionStyle style, String text) {
        if (style == null) {
            style = CaptionStyle.DEFAULT;
        }

        return switch (style) {
            case DEFAULT -> captions.defaultCaption(text);
            case STYLISED -> captions.stylisedCaption(text);
            case HANDWRITTEN -> captions.handwrittenCaption(text);
            case COMIC -> captions.comicCaption(text);
        };
    }
}
