package game.elements;

/**
 * primary gun of the tank. it has higher damage  but less fire rate than machine gun.
 */
public class MissileGun extends Gun {

    //fields

    //constructor
    public MissileGun(double x, double y){ //todo : try not to pass tank from subclass to father
        super(x,y);
        damage = 100;
        ammo = 15;
        reloadTime = 1000; // millisecond
    }
    //methods


}
