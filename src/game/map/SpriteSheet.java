package game.map;

import game.Utils.Utility;

import java.awt.image.BufferedImage;

public class SpriteSheet
{
    private String path;
    private int width;
    private int height;

    private int[] pixels;

    public SpriteSheet(String path)
    {
        BufferedImage image = Utility.loadImage("");

        this.path = path;
        this.width = image.getWidth();
        this.height = image.getHeight();

        pixels = image.getRGB(0, 0, width, height, null, 0, width);

    }
}
