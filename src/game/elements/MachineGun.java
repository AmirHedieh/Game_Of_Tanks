package game.elements;

/**
 * secondary gun of the tank. it has higher fire rate but less damage than missile gun.
 */
public class MachineGun extends Gun {

    //fields

    //constructor
    public MachineGun(Tank tank){ //todo : try not to pass tank from subclass to father
        super(tank);
        damage = 20;
        ammo = 70;
    }
    //methods

}
