package game.elements;

/**
 * an entity which is a moving object though the map.
 * it contains a gun to hit other objects. it also has
 * specific amount of health. if health comes down to zero
 * the tank becomes dead.
 * type determines that if the tank is AI or Player(1 for AI, 0 for Player).
 */
public class Tank extends GameObject{
    //fields
    public final int TANK_WIDTH = 128 ;
    public final int TANK_HEIGHT = 128;

    private int health;
    private Gun gun;
    private int type;

    //constructor
    public Tank(int x, int y, int health, int type){ // gun must be added manually after making tank
        super(x,y);
        this.health = health;
        this.type = type;
    }

    //methods

    /**
     * set amount of health for tank.
     * @param health
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * set a gun for tank.
     * @param gun
     */
    public void setGun(Gun gun) {
        this.gun = gun;
    }

    /**
     * set a type for tank(1 for AI, 0 for Player).
     * @param type
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return amount of health remained for tank
     */
    public int getHealth() {
        return health;
    }

    /**
     * @return gun of the tank.
     */
    public Gun getGun() {
        return gun;
    }

    /**
     * 0 if tank is AI.
     * 1 if tank is Player.
     * @return the type of tank
     */
    public int getType() {
        return type;
    }
}
