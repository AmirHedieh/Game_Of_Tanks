package game.map;

import game.Utils.Utility;
import game.template.bufferstrategy.ThreadPool;

import java.awt.image.BufferedImage;

public class SpriteSheet
{
    private BufferedImage image;

    public SpriteSheet(String path)
    {
        image = Utility.loadImage("src/resource/sprite_sheet.png");
    }

    public BufferedImage grabImage(int column, int row, int width, int height)
    {
        return image.getSubimage( (column * 100) - 100, (row * 100) - 100, width, height);
    }
}
