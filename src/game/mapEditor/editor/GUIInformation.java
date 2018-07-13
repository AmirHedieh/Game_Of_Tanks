package game.mapEditor.editor;

/**
 * Information that the GUI has, which its components also need access to. Like
 * the GridView needs to know what tile is selected and should be drawn when
 * you draw on the grid.
 */
public interface GUIInformation
{

    /**
     * Get the tile that is selected and should be drawn.
     *
     * @return Tile The selected tile.
     */
    public Tile getSelectedTile();
}
