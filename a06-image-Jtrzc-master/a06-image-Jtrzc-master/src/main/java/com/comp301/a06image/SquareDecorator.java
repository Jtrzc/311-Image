package com.comp301.a06image;

import java.awt.*;

public class SquareDecorator implements Image {

  private Image img;
  private int squareX;
  private int squareY;
  private int size;
  private Color color;

  public SquareDecorator(Image image, int squareX, int squareY, int squareSize, Color color) {
    if (image == null || squareSize < 0) {
      throw new IllegalArgumentException();
    }
    img = image;
    this.squareX = squareX;
    this.squareY = squareY;
    size = squareSize;
    this.color = color;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x < 0 || y < 0 || x >= img.getWidth() || y >= img.getHeight()) {
      throw new IllegalArgumentException();
    }
    if (((x >= squareX) && (x < squareX + size)) && ((y >= squareY) && (y < squareY + size))) {
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
