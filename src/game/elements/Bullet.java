package game.elements;

/**
 * each Gun makes bullets to hit others.
 * Bullets takes their damages from the gun which made them.
 */
public class Bullet extends GameObject{ // todo: 2 classes must extend bullet ( missle - machine gun)
    //fields
    public final int BULLET_WIDTH = 5 ;
    public final int BULLET_HEIGHT = 5;

    protected int damage;
    private double shootDirectionAngle;
    private double targetX , targetY;

    //constructor
    public Bullet(double startX, double startY, double mouseX, double mouseY, ObjectId id){
        super(startX,startY,id);
        targetX = mouseX;
        targetY = mouseY;
        shootDirectionAngle = calculateShootAngle(startX,startY,mouseX,mouseY);
        //moving in 4 direction needs specific velocity
        if(mouseX > startX && mouseY > startY){
            velX = 14;
            velY = 14;
        }
        else if(mouseX > startX && mouseY < startY){
            velX = 14;
            velY = 14;
        }
        else if(mouseX < startX && mouseY < startY){
            velX = -14;
            velY = -14;
        }
        else if(mouseX < startX && mouseY > startY){
            velX = -14;
            velY = -14;
        }
        //from now on if conditions are for times where angle is 0 or PI/2
        else if(mouseX == startX && mouseY > startY){
            velX = 0;
            velY = 14;
        }
        else if(mouseX == startX && mouseY < startY){
            velX = 0;
            velY = 14;
        }
        else if(mouseX > startX && mouseY == startY){
            velX = 14;
            velY = 0;
        }
        else if(mouseX < startX && mouseY == startY){
            velX = -14;
            velY = 0;
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

    /**
     * the X position where bullet is going to(where mouse was clicked)
     * @return X of where mouse was clicked to shoot there
     */
    public double getTargetX() {
        return targetX;
    }

    /**
     * the Y position where bullet is going to(where mouse was clicked)
     * @return Y of where mouse was clicked to shoot there
     */
    public double getTargetY() {
        return targetY;
    }

    /**
     * returns the angle of the way bullet must go.
     * @return the angle that way of bullet go.
     */
    public double getShootDirectionAngle() {
        return shootDirectionAngle;
    }
}
