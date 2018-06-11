package game.elements;

/**
 * each Gun makes bullets to hit others.
 * Bullets takes their damages from the gun which made them.
 */
public class Bullet extends GameObject{ // todo: 2 classes must extend bullet ( missle - machine gun)
    //fields
    private int damage;

    //constructor
    public Bullet(int x, int y){
        super(x,y);
    }

    //methods
    /**
     * set damage for bullet
     * @param damage amount of damage it must provides
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * get damage of bullet
     * @return amount of damage it provides
     */
    public int getDamage() {
        return damage;
    }
}
