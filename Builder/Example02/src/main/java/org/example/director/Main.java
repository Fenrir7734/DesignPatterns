package org.example.director;

public class Main {
    private static final String TEXT = "Sample text";

    public static void main(String[] args) {
        final CaptionDirector director = new CaptionDirector();

        final SimpleCaption.CaptionBuilderImpl simpleCaptionBuilder = SimpleCaption.builder(TEXT);
        director.comicCaption(simpleCaptionBuilder);
        final SimpleCaption simpleCaption = simpleCaptionBuilder.build();

        final ImageCaption.CaptionBuilderImpl imageCaptionBuilder = ImageCaption.builder(TEXT);
        director.comicCaption(imageCaptionBuilder);
        final ImageCaption imageCaption = imageCaptionBuilder.build();
    }
}
