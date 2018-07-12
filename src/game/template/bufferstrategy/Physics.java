package game.template.bufferstrategy;

import game.elements.*;

import java.util.Iterator;

public class Physics
{
    ///////////////////////////////
    //////AI Tanks collision///////
    ///////////////////////////////
    public static boolean aiTankCheckHardWallsCollisionUp(Objects objects , AITank tank){
        for (int i = 0; i < objects.getMap().getHardWall().size(); i++) {
            if (tank.getBounds().intersects(objects.getMap().getHardWall().get(i).getBounds())) {
                if (tank.getY() > objects.getMap().getHardWall().get(i).getY()) {
                    return true;
                }
            }
        }
        for (int i = 0; i < objects.getTurrets().size(); i++) {
            if (tank.getBounds().intersects(objects.getTurrets().get(i).getBounds())) {
                if (tank.getY() > objects.getTurrets().get(i).getY()) {
                    return true;
                }
            }
        }
        for (int i = 0; i < objects.getTanks().size(); i++) {
            if (tank.getBounds().intersects(objects.getTanks().get(i).getBounds())) {
                if (tank.getY() > objects.getTanks().get(i).getY()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean aiTankCheckHardWallsCollisionDown(Objects objects , AITank tank){
        for (int i = 0; i < objects.getMap().getHardWall().size(); i++) {
            if (tank.getBounds().intersects(objects.getMap().getHardWall().get(i).getBounds())) {
                if (tank.getY() < objects.getMap().getHardWall().get(i).getY()) {
                    return true;
                }
            }
        }
        for (int i = 0; i < objects.getTurrets().size(); i++) {
            if (tank.getBounds().intersects(objects.getTurrets().get(i).getBounds())) {
                if (tank.getY() < objects.getTurrets().get(i).getY()) {
                    return true;
                }
            }
        }
        for (int i = 0; i < objects.getTanks().size(); i++) {
            if (tank.getBounds().intersects(objects.getTanks().get(i).getBounds())) {
                if (tank.getY() < objects.getTanks().get(i).getY()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean aiTankCheckHardWallsCollisionRight(Objects objects , AITank tank){
        for (int i = 0; i < objects.getMap().getHardWall().size(); i++) {
            if (tank.getBounds().intersects(objects.getMap().getHardWall().get(i).getBounds())) {
                if (tank.getX() < objects.getMap().getHardWall().get(i).getX()) {
                    return true;
                }
            }
        }
        for (int i = 0; i < objects.getTurrets().size(); i++) {
            if (tank.getBounds().intersects(objects.getTurrets().get(i).getBounds())) {
                if (tank.getX() < objects.getTurrets().get(i).getX()) {
                    return true;
                }
            }
        }
        for (int i = 0; i < objects.getTanks().size(); i++) {
            if (tank.getBounds().intersects(objects.getTanks().get(i).getBounds())) {
                if (tank.getX() < objects.getTanks().get(i).getX()) {
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean aiTankCheckHardWallsCollisionLeft(Objects objects , AITank tank){
        for (int i = 0; i < objects.getMap().getHardWall().size(); i++) {
            if (tank.getBounds().intersects(objects.getMap().getHardWall().get(i).getBounds())) {
                if (tank.getX() > objects.getMap().getHardWall().get(i).getX()) {
                    return true;
                }
            }
        }
        for (int i = 0; i < objects.getTurrets().size(); i++) {
            if (tank.getBounds().intersects(objects.getTurrets().get(i).getBounds())) {
                if (tank.getX() > objects.getTurrets().get(i).getX()) {
                    return true;
                }
            }
        }
        for (int i = 0; i < objects.getTanks().size(); i++) {
            if (tank.getBounds().intersects(objects.getTanks().get(i).getBounds())) {
                if (tank.getX() > objects.getTanks().get(i).getX()) {
                    return true;
                }
            }
        }
        return false;
    }
    //////////////////////////////////
    //////BuriedRobot collision///////
    //////////////////////////////////
    public static boolean BuriedRobotCollisionUp(Objects objects , BuriedRobot robot){
        for (int i = 0; i < objects.getMap().getHardWall().size(); i++) {
            if (robot.getBounds().intersects(objects.getMap().getHardWall().get(i).getBounds())) {
                if (robot.getY() > objects.getMap().getHardWall().get(i).getY()) {
                    return true;
                }
            }
        }
        for (int i = 0; i < objects.getTurrets().size(); i++) {
            if (robot.getBounds().intersects(objects.getTurrets().get(i).getBounds())) {
                if (robot.getY() > objects.getTurrets().get(i).getY()) {
                    return true;
                }
            }
        }
        for (int i = 0; i < objects.getTanks().size(); i++) {
            if (robot.getBounds().intersects(objects.getTanks().get(i).getBounds())) {
                if (robot.getY() > objects.getTanks().get(i).getY()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean BuriedRobotCollisionDown(Objects objects , BuriedRobot robot){
        for (int i = 0; i < objects.getMap().getHardWall().size(); i++) {
            if (robot.getBounds().intersects(objects.getMap().getHardWall().get(i).getBounds())) {
                if (robot.getY() < objects.getMap().getHardWall().get(i).getY()) {
                    return true;
                }
            }
        }
        for (int i = 0; i < objects.getTurrets().size(); i++) {
            if (robot.getBounds().intersects(objects.getTurrets().get(i).getBounds())) {
                if (robot.getY() < objects.getTurrets().get(i).getY()) {
                    return true;
                }
            }
        }
        for (int i = 0; i < objects.getTanks().size(); i++) {
            if (robot.getBounds().intersects(objects.getTanks().get(i).getBounds())) {
                if (robot.getY() < objects.getTanks().get(i).getY()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean BuriedRobotCollisionRight(Objects objects , BuriedRobot robot){
        for (int i = 0; i < objects.getMap().getHardWall().size(); i++) {
            if (robot.getBounds().intersects(objects.getMap().getHardWall().get(i).getBounds())) {
                if (robot.getX() < objects.getMap().getHardWall().get(i).getX()) {
                    return true;
                }
            }
        }
        for (int i = 0; i < objects.getTurrets().size(); i++) {
            if (robot.getBounds().intersects(objects.getTurrets().get(i).getBounds())) {
                if (robot.getX() < objects.getTurrets().get(i).getX()) {
                    return true;
                }
            }
        }
        for (int i = 0; i < objects.getTanks().size(); i++) {
            if (robot.getBounds().intersects(objects.getTanks().get(i).getBounds())) {
                if (robot.getX() < objects.getTanks().get(i).getX()) {
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean BuriedRobotCollisionLeft(Objects objects , BuriedRobot robot){
        for (int i = 0; i < objects.getMap().getHardWall().size(); i++) {
            if (robot.getBounds().intersects(objects.getMap().getHardWall().get(i).getBounds())) {
                if (robot.getX() > objects.getMap().getHardWall().get(i).getX()) {
                    return true;
                }
            }
        }
        for (int i = 0; i < objects.getTurrets().size(); i++) {
            if (robot.getBounds().intersects(objects.getTurrets().get(i).getBounds())) {
                if (robot.getX() > objects.getTurrets().get(i).getX()) {
                    return true;
                }
            }
        }
        for (int i = 0; i < objects.getTanks().size(); i++) {
            if (robot.getBounds().intersects(objects.getTanks().get(i).getBounds())) {
                if (robot.getX() > objects.getTanks().get(i).getX()) {
                    return true;
                }
            }
        }
        return false;
    }
    /////////////////////////////
    //////player collision///////
    /////////////////////////////
    public static boolean checkHardWallsCollisionUp(Objects objects)
    {
        for (int i = 0; i < objects.getMap().getHardWall().size(); i++)
        {
            if (objects.getPlayers().get(0).getBounds().intersects(objects.getMap().getHardWall().get(i).getBounds()))
            {
                if (objects.getPlayers().get(0).getY() > objects.getMap().getHardWall().get(i).getY())
                {
                    return true;
                }
            }
        }
        for (int i = 0; i < objects.getTurrets().size(); i++) {
            if (objects.getPlayers().get(0).getBounds().intersects(objects.getTurrets().get(i).getBounds())) {
                if (objects.getPlayers().get(0).getY() > objects.getTurrets().get(i).getY()) {
                    return true;
                }
            }
        }
        for (int i = 0; i < objects.getTanks().size(); i++) {
            if (objects.getPlayers().get(0).getBounds().intersects(objects.getTanks().get(i).getBounds())) {
                if (objects.getPlayers().get(0).getY() > objects.getTanks().get(i).getY()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkHardWallsCollisionDown(Objects objects)
    {
        for (int i = 0; i < objects.getMap().getHardWall().size(); i++)
        {
            if (objects.getPlayers().get(0).getBounds().intersects(objects.getMap().getHardWall().get(i).getBounds()))
            {
                if (objects.getPlayers().get(0).getY() < objects.getMap().getHardWall().get(i).getY())
                {
                    return true;
                }
            }
        }
        for (int i = 0; i < objects.getTurrets().size(); i++) {
            if (objects.getPlayers().get(0).getBounds().intersects(objects.getTurrets().get(i).getBounds())) {
                if (objects.getPlayers().get(0).getY() < objects.getTurrets().get(i).getY()) {
                    return true;
                }
            }
        }
        for (int i = 0; i < objects.getTanks().size(); i++) {
            if (objects.getPlayers().get(0).getBounds().intersects(objects.getTanks().get(i).getBounds())) {
                if (objects.getPlayers().get(0).getY() < objects.getTanks().get(i).getY()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkHardWallsCollisionRight(Objects objects)
    {
        for (int i = 0; i < objects.getMap().getHardWall().size(); i++)
        {
            if (objects.getPlayers().get(0).getBounds().intersects(objects.getMap().getHardWall().get(i).getBounds()))
            {
                if (objects.getPlayers().get(0).getX() < objects.getMap().getHardWall().get(i).getX())
                {
                    return true;
                }
            }
        }
        for (int i = 0; i < objects.getTurrets().size(); i++) {
            if (objects.getPlayers().get(0).getBounds().intersects(objects.getTurrets().get(i).getBounds())) {
                if (objects.getPlayers().get(0).getX() < objects.getTurrets().get(i).getX()) {
                    return true;
                }
            }
        }
        for (int i = 0; i < objects.getTanks().size(); i++) {
            if (objects.getPlayers().get(0).getBounds().intersects(objects.getTanks().get(i).getBounds())) {
                if (objects.getPlayers().get(0).getX() < objects.getTanks().get(i).getX()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkHardWallsCollisionLeft(Objects objects)
    {
        for (int i = 0; i < objects.getMap().getHardWall().size(); i++)
        {
            if (objects.getPlayers().get(0).getBounds().intersects(objects.getMap().getHardWall().get(i).getBounds()))
            {
                if (objects.getPlayers().get(0).getX() > objects.getMap().getHardWall().get(i).getX())
                {
                    return true;
                }
            }
        }
        for (int i = 0; i < objects.getTurrets().size(); i++) {
            if (objects.getPlayers().get(0).getBounds().intersects(objects.getTurrets().get(i).getBounds())) {
                if (objects.getPlayers().get(0).getX() > objects.getTurrets().get(i).getX()) {
                    return true;
                }
            }
        }
        for (int i = 0; i < objects.getTanks().size(); i++) {
            if (objects.getPlayers().get(0).getBounds().intersects(objects.getTanks().get(i).getBounds())) {
                if (objects.getPlayers().get(0).getX() > objects.getTanks().get(i).getX()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void checkMapBounds(GameObject object)
    {
        if (object.getX() > 3400)
        {
            object.setX(3400);
        }
        else if (object.getX() < 0)
        {
            object.setX(0);
        }

        if (object.getY() > 6400)
        {
            object.setY(6400);
        }
        else if (object.getY() < 0)
        {
            object.setY(0);
        }
    }

    public static void checkBulletsCollision(Objects objects)
    {
        //hardWalls
        for (int i = 0; i < objects.getBullets().size(); i++)
        {
            for (int j = 0; j < objects.getMap().getHardWall().size(); j++)
            {
                if (objects.getBullets().get(i).getBounds().intersects(objects.getMap().getHardWall().get(j).getBounds()))
                {
                    objects.getBullets().remove(i);
                    break;
                }
            }
        }

        //buriedRobot
        Iterator<Bullet> bulletIterator = objects.getBullets().iterator();
        Iterator<BuriedRobot> buriedRobotIterator = objects.getRobots().iterator();
        /*while (bulletIterator.hasNext())
        {
            while (buriedRobotIterator.hasNext())
            {
                if (bulletIterator.next().getBounds().intersects(buriedRobotIterator.next().getBounds()))
                {
                    bulletIterator.remove();
                    buriedRobotIterator.remove();
                    break;
                }
            }
        }*/

    }
}
