package com.comp301.a06image;

import java.awt.*;

public class ZoomDecorator implements Image {

  private Image img;
  private int multiplier;

  public ZoomDecorator(Image image, int multiplier) {
    if (image == null || multiplier < 1) {
      throw new IllegalArgumentException();
    }

    img = image;
    this.multiplier = multiplier;
  }

  public ZoomDecorator(Image image) {
    if (image == null) {
      throw new IllegalArgumentException();
    }
    img = image;
    this.multiplier = 2;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x < 0 || y < 0 || x > img.getWidth() * multiplier || y > img.getHeight() * multiplier) {
      throw new IllegalArgumentException();
    }
    return img.getPixelColor((int) Math.floor(x / multiplier), (int) Math.floor(y / multiplier));
  }

  @Override
  public int getWidth() {
    return img.getWidth() * multiplier;
  }

  @Override
  public int getHeight() {
    return img.getHeight() * multiplier;
  }

  @Override
  public int getNumLayers() {
    return img.getNumLayers() + 1;
  }
}
