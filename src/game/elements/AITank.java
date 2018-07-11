package game.elements;

import java.io.Serializable;

/**
 * the enemy Tank that use AIHandler to play with player. the gun for this must be determined
 * by last parameter in constructor. each tank use MachineGun or MissileGun, not both.
 * its speed is lower than player tank.
 */
public class AITank extends Tank implements Serializable{
    private boolean activated;

    public AITank(double x, double y, int health, ObjectId id,Gun gun){
        super(x,y,health,id);
        if(gun instanceof MissileGun){
            selectedGun = missileGun;
        }
        else if(gun instanceof MachineGun){
            selectedGun = machineGun;
        }
        setVelX(8);
        setVelY(8);
        activated = false;
    }

    /**
     * if tank is playing or its sleep(waiting to be invoked).
     * @return activated or not
     */
    public boolean isActivated() {
        return activated;
    }

    /**
     * determine that tank is On or Off.
     * @param activated true if On - false if Off
     */
    public void setActivated(boolean activated) {
        this.activated = activated;
    }

}
