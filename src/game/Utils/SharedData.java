package game.Utils;

import game.elements.Bullet;
import game.elements.ObjectId;

/**
 * a SingleTon patterned class that shares needed info between all classes
 */
public class SharedData
{

    public ObjectId gameType;
    public ObjectId playerType;
    public Boolean clientShot = false;
    public Bullet clientLastShotBullet;

    //Singleton
    private static SharedData sharedData;

    public SharedData()
    {
        sharedData = this;
    }

    public static SharedData getData()
    {
        return sharedData;
    }
}
