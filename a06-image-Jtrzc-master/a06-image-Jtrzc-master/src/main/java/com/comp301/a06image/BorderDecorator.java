package com.comp301.a06image;

import java.awt.*;

public class BorderDecorator implements Image {

  private Image img;
  private int thiccness;
  private Color borderColor;

  public BorderDecorator(Image image, int thiccness, Color borderColor) {

    if (thiccness < 0 || image == null) {
      throw new IllegalArgumentException();
    }
    img = image;
    this.thiccness = thiccness;
    this.borderColor = borderColor;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x < 0
        || y < 0
        || x + 1 > img.getWidth() + thiccness * 2
        || y + 1 > img.getHeight() + thiccness * 2) {
      throw new IllegalArgumentException();
    }
    if (x >= thiccness
        && x < img.getWidth() + thiccness
        && y >= thiccness
        && y < img.getHeight() + thiccness) {
      return img.getPixelColor(x - thiccness, y - thiccness);
    } else {
      return borderColor;
    }
  }

  @Override
  public int getWidth() {
    return img.getWidth() + thiccness * 2;
  }

  @Override
  public int getHeight() {
    return img.getHeight() + thiccness * 2;
  }

  @Override
  public int getNumLayers() {
    return img.getNumLayers() + 1;
  }
}
