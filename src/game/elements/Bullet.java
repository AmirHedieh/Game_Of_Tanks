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
    public Bullet(double startX, double startY, double mouseX, double mouseY, int damage){
        super(startX,startY);
        this.damage = damage;
        shootDirectionAngle = calculateShootAngle(startX,startY,mouseX,mouseY);
        System.out.println(shootDirectionAngle);
        //moving in 4 direction needs specific velocity
        if(mouseX > startX && mouseY > startY){
            velX = 3;
            velY = 3;
        }
        else if(mouseX > startX && mouseY < startY){
            velX = 3;
            velY = 3;
        }
        else if(mouseX < startX && mouseY < startY){
            velX = -3;
            velY = -3;
        }
        if(mouseX < startX && mouseY > startY){
            velX = -3;
            velY = -3;
        }

    }

    //methods

    /**
     * calculate the angle that bullet must go.
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
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
