package org.example.director.builder;

import org.example.Rotation;

import java.awt.Color;

public interface CaptionBuilder {
    CaptionBuilder font(String font);
    CaptionBuilder fontStyle(int fontStyle);
    CaptionBuilder size(int size);
    CaptionBuilder color(Color color);
    CaptionBuilder rotate(double theta, double x, double y);
    CaptionBuilder rotate(Rotation rotation);
}
