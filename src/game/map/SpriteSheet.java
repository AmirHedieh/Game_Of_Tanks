package game.map;

import game.Utils.Utility;
import game.template.bufferstrategy.ThreadPool;

import java.awt.image.BufferedImage;

public class SpriteSheet
{
    private String path;
    private int width;
    private int height;

    private int[] pixels;

    public SpriteSheet(String path)
    {
        BufferedImage image = Utility.loadImage("src/resource/sprite_sheet.png");

        this.path = path;
        this.width = image.getWidth();
        this.height = image.getHeight();

        pixels = image.getRGB(0, 0, width, height, null, 0, width);

        for (int i = 0; i < pixels.length; i++)
        {
            pixels[i] = (pixels[i] & 0xff) / 64;
        }

        for (int i = 0; i < 8; i++)
        {
            System.out.println(pixels[i]);
        }
    }
}
