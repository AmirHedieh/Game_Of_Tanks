package game.elements;

/**
 * primary gun of the tank. it has higher damage  but less fire rate than machine gun.
 */
public class MissileGun extends Gun {

    //fields

    //constructor
    public MissileGun(Tank tank){ //todo : try not to pass tank from subclass to father
        super(tank);
        damage = 100;
        ammo = 15;
    }
    //methods


}
