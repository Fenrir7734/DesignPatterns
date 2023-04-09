package com.builder.example01.watermark.caption.builder;

import com.builder.example01.watermark.caption.Caption;
import com.builder.example01.watermark.caption.Rotation;

import java.awt.Color;

public interface CaptionBuilder extends AlphaStep {
    CaptionBuilder font(String font);
    CaptionBuilder fontStyle(int fontStyle);
    CaptionBuilder size(int size);
    CaptionBuilder color(Color color);
    CaptionBuilder rotate(double theta, double x, double y);
    CaptionBuilder rotate(Rotation rotation);
    AlphaStep alphaRule(int rule);
    Caption build();
}
