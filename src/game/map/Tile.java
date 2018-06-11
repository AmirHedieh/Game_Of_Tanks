package game.map;

import com.sun.prism.Texture;

/**
 * //TODO: complete this javadoc :)))
 */
public class Tile
{
    //fields
    private float x;
    private float y;
    private float width;
    private float height;
    private TileType tileType;
    private Texture texture;

    //constructor

    public Tile(float x, float y, float width, float height, TileType tileType)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.tileType = tileType;
        //TODO: read about Texture class and OpenGL
        //this.texture = QuickLoad();
    }

    /**
     * @return x(location) of the tile
     */
    public float getX()
    {
        return x;
    }

    /**
     * set the x(location) of the tile
     * @param x
     */
    public void setX(float x)
    {
        this.x = x;
    }


    /**
     * @return y(location) of the tile
     */
    public float getY()
    {
        return y;
    }

    /**
     * set the y(location) of the tile
     * @param y
     */
    public void setY(float y)
    {
        this.y = y;
    }

    /**
     * @return width of the tile
     */
    public float getWidth()
    {
        return width;
    }

    /**
     * set the width of the tile
     * @param width
     */
    public void setWidth(float width)
    {
        this.width = width;
    }


    /**
     * @return height of the tile
     */
    public float getHeight()
    {
        return height;
    }

    /**
     * set the height of the tile
     * @param height
     */
    public void setHeight(float height)
    {
        this.height = height;
    }


    /**
     * @return Type of the tile
     */
    public TileType getTileType()
    {
        return tileType;
    }

    /**
     * set the type of a tile
     * @param tileType
     */
    public void setTileType(TileType tileType)
    {
        this.tileType = tileType;
    }


    public Texture getTexture()
    {
        return texture;
    }

    public void setTexture(Texture texture)
    {
        this.texture = texture;
    }


    //methods
}