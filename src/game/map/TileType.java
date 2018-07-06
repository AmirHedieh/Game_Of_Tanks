package game.map;

/**
 * This enumerator is for describe the type of our tiles
 * we have x type of tile
 * each type has a texture name, isDestructible, isPassable.
 */
public enum TileType
{
    //enums
    //TODO: create final textures
    //TODO: complete the enumerators
    HardWall("hard wall", false, false),
    SoftWall("soft wall", true, false);

    //fields
    String textureName;
    boolean destructible;
    boolean passable;

    //constructor
    TileType(String textureName, boolean destructible, boolean passable)
    {
        this.textureName = textureName;
        this.destructible = destructible;
        this.passable = passable;
    }

    //methods

}
