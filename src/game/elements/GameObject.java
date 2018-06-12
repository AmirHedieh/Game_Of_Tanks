package game.elements;

/**
 * each object in the game like tank or bullets and ... has a location(x,y)
 * and certain velocity at X,Y Dimensions.
 */
public class GameObject {
    //fields
    protected int x , y;
    protected int velX,velY;

    //constructor
    public GameObject(int x, int y){
        this.x = x;
        this.y = y;
        velX = 0;
        velY = 0;
    }

    //methods

    /**
     * set a X location for object
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * set a Y location for object
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * set horizontal velocity for object
     * @param velX
     */
    public void setVelX(int velX) {
        this.velX = velX;
    }

    /**
     * set vertical velocity for object
     * @param velY
     */
    public void setVelY(int velY) {
        this.velY = velY;
    }

    /**
     * returns x
     * @return X location of object
     */
    public int getX() {
        return x;
    }

    /**
     * returns y
     * @return Y location of object
     */
    public int getY() {
        return y;
    }

    /**
     * velocity at x direction
     * @return horizontal velocity
     */
    public int getVelX() {
        return velX;
    }

    /**
     * velocity at y direction
     * @return vertical velocity
     */
    public int getVelY() {
        return velY;
    }

}
