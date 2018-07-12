package game.multiplayer;

import game.elements.*;

import java.io.Serializable;

public class ClientSendingData implements Serializable
{
    private Tank clientTank = null;
    private Bullet lastShotBullet = null;

    public void setClientTank(Tank clientTank)
    {
        this.clientTank = clientTank;
    }

    public void setLastShotBullet(Bullet lastShotBullet)
    {
        this.lastShotBullet = lastShotBullet;
    }

    public Tank getClientTank()
    {

        return clientTank;
    }

    public Bullet getLastShotBullet()
    {
        return lastShotBullet;
    }
}
