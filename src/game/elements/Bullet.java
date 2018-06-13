package game.elements;

/**
 * each Gun makes bullets to hit others.
 * Bullets takes their damages from the gun which made them.
 */
public class Bullet extends GameObject{ // todo: 2 classes must extend bullet ( missle - machine gun)
    //fields
    public final int BULLET_WIDTH = 10 ;
    public final int BULLET_HEIGHT = 10;

    private int damage;
    private double shootDirectionAngle;

    //constructor
    public Bullet(double x, double y, int startPointX, double startPointY, int damage){
        super(x,y);
        this.damage = damage;
        shootDirectionAngle = calculateShootAngle(x,y,startPointX,startPointY);
        System.out.println(shootDirectionAngle);
        velX = 3;
        velY = 3;
    }

    //methods

    private double calculateShootAngle(double x1, double y1, double x2, double y2){
        return Math.atan((y2 - y1) / (x2 - x1));
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

    public double getShootDirectionAngle() {
        return shootDirectionAngle;
    }
}
