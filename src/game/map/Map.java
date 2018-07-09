package game.map;

import game.Utils.Utility;
import game.elements.*;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Map
{
    BufferedImage mapImage;
    private ArrayList<HardWall> hardWall = new ArrayList<>();
    private ArrayList<Plant> plant = new ArrayList<>();
    private ArrayList<SoftWall> softWall = new ArrayList<>();
    private ArrayList<Teazel> teazel = new ArrayList<>();
    private ArrayList<Soil> soil = new ArrayList<>();

    public Map(Objects objects)
    {
        mapImage = Utility.loadBufferedImage("src/resource/map.png");
        for (int xx = 0; xx < mapImage.getWidth(); xx++)
        {
            for (int yy = 0; yy < mapImage.getHeight(); yy++)
            {
                int pixel = mapImage.getRGB(xx, yy);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;

                if ((red == 255) && (green == 255) && (blue == 0)) //HardWall
                {
                    hardWall.add(new HardWall(xx * 100, yy * 100));
                }
                else if ((red == 0) && (green == 0) && (blue == 255)) //SoftWall
                {
                    softWall.add(new SoftWall(xx * 100, yy * 100));
                }
                else if ((red == 0) && (green == 255) && (blue == 0)) //Plant
                {
                    plant.add(new Plant(xx * 100, yy * 100));
                }
                else if ((red == 255) && (green == 255) && (blue == 255)) //Soil
                {
                    soil.add(new Soil(xx * 100, yy * 100));
                }
                else if ((red == 255) && (green == 0) && (blue == 255)) //Teazel
                {
                    teazel.add(new Teazel(xx * 100, yy * 100));
                }
            }
        }
    }

    public BufferedImage getMapImage()
    {
        return mapImage;
    }

    public void setMapImage(BufferedImage mapImage)
    {
        this.mapImage = mapImage;
    }

    public ArrayList<HardWall> getHardWall()
    {
        return hardWall;
    }

    public void setHardWall(ArrayList<HardWall> hardWall)
    {
        this.hardWall = hardWall;
    }

    public ArrayList<Plant> getPlant()
    {
        return plant;
    }

    public void setPlant(ArrayList<Plant> plant)
    {
        this.plant = plant;
    }

    public ArrayList<SoftWall> getSoftWall()
    {
        return softWall;
    }

    public void setSoftWall(ArrayList<SoftWall> softWall)
    {
        this.softWall = softWall;
    }

    public ArrayList<Teazel> getTeazel()
    {
        return teazel;
    }

    public void setTeazel(ArrayList<Teazel> teazel)
    {
        this.teazel = teazel;
    }

    public ArrayList<Soil> getSoil()
    {
        return soil;
    }

    public void setSoil(ArrayList<Soil> soil)
    {
        this.soil = soil;
    }

}
