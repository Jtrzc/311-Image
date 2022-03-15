package com.comp301.a06image;

import java.awt.*;

public class CircleDecorator implements Image {

  private Image img;
  private int cx;
  private int cy;
  private int radius;
  private Color color;

  public CircleDecorator(Image image, int cx, int cy, int radius, Color color) {
    if (radius < 0 || image == null) {
      throw new IllegalArgumentException();
    }
    img = image;
    this.cx = cx;
    this.cy = cy;
    this.radius = radius;
    this.color = color;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x < 0 || y < 0 || x >= img.getWidth() || y >= img.getHeight()) {
      throw new IllegalArgumentException();
    }
    int distance = (int) Math.sqrt((x - cx) * (x - cx) + (y - cy) * (y - cy));
    if (x < cx + radius
        && x > cx - radius
        && y < cy + radius
        && y > cy - radius
        && distance < radius) {
      return color;
    } else {
      return img.getPixelColor(x, y);
    }
  }

  @Override
  public int getWidth() {
    return img.getWidth();
  }

  @Override
  public int getHeight() {
    return img.getHeight();
  }

  @Override
  public int getNumLayers() {
    return img.getNumLayers() + 1;
  }
}
