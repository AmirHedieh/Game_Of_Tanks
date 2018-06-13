package game.elements;

/**
 * each Gun makes bullets to hit others.
 * Bullets takes their damages from the gun which made them.
 */
public class Bullet extends GameObject{ // todo: 2 classes must extend bullet ( missle - machine gun)
    //fields
    private int damage;
    private double slope;

    //constructor
    public Bullet(double x, double y, int startPointX, double startPointY, int damage){
        super(x,y);
        this.damage = damage;
        slope = countLineSlope(x,y,startPointX,startPointY);
        System.out.println(slope);
        velX = 2;
    }

    //methods

    private double countLineSlope(double x1, double y1, double x2, double y2){
        System.out.println(x1  + "-" + y1+"-" + x2+"-"+y2);
        slope = (double)(y2 - y1) / (double)(x2 - x1);
        return slope;
    }
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

    public double getSlope() {
        return slope;
    }
}
