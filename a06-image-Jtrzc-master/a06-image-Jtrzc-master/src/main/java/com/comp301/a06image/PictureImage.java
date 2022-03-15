package com.comp301.a06image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PictureImage implements Image {

  private BufferedImage img;

  public PictureImage(String pathname) throws IOException {
    File file = new File(pathname);
    img = ImageIO.read(file);
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x < 0 || y < 0 || x >= img.getWidth() || y >= img.getHeight()) {
      throw new IllegalArgumentException();
    }
    Color color = new Color(img.getRGB(x, y));
    return color;
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
    return 1;
  }
}
