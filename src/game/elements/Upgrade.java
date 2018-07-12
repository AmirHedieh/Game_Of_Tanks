package game.elements;

import game.Utils.SharedData;
import game.Utils.Utility;

import java.io.Serializable;
import java.util.ArrayList;

public class Upgrade extends GameObject implements Serializable {
    //fields
//    private ObjectId type;
    private Objects objects;
    private Boolean activated;
    private Tank user;

    //constructor
    public Upgrade(){

    }

    public Upgrade(double x , double y, Objects objects, ObjectId type){
        super(x,y,type);
//        this.type = type;
        this.objects = objects;
        activated = false;
    }

    //methods
    public void tick(){
        determineTarget();
        checkToBeUsed();
    }

    public void checkToBeUsed(){
        if(Math.abs(user.x - this.x) < 95 && Math.abs(user.y - this.y) < 95){
            System.out.println("INNNNNNNN");
            if(id.equals(ObjectId.DamageUpgrade)){
                user.getMissileGun().setDamage(user.getMissileGun().damage + 20);
                user.getMachineGun().setDamage(user.getMachineGun().damage + 20);
                activated = false;
            }
            else if(id.equals(ObjectId.HealthUpgrade)){
                user.setHealth(user.health + 100);
                activated = false;
            }
            else if (id.equals(ObjectId.AmmoUpgrade)){
                user.getMissileGun().setAmmo(user.getMissileGun().ammo + 15);
                user.getMachineGun().setAmmo(user.getMachineGun().ammo + 15);
                activated = false;
            }
            else if(id.equals(ObjectId.ShieldUpgrade)){
                //body
                activated = false;
            }
        }
    }

    /**
     * set user to the tank which is closer to upgrade
     */
    public void determineTarget(){
        for(int i = 0 ; i < objects.getPlayers().size() ; i++){
            if(SharedData.getData().gameType.equals(ObjectId.TwoPlayer)) {
                user = (Utility.calculateDistance(this, objects.getPlayers().get(0)) > Utility.calculateDistance(this, objects.getPlayers().get(1))) ?
                        objects.getPlayers().get(1) : objects.getPlayers().get(0);
            }
            else { //in single player
                user = objects.getPlayers().get(0);
            }
        }
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }
}
