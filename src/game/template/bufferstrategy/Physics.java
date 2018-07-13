package game.template.bufferstrategy;

import game.Utils.Sound;
import game.Utils.Utility;
import game.elements.*;

import java.awt.*;
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
            Rectangle rectangle = new Rectangle((int)objects.getMap().getHardWall().get(i).getX(),(int)objects.getMap().getHardWall().get(i).getY()+20,90,83);
            if (objects.getPlayers().get(0).getBounds().intersects(rectangle))
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
            Rectangle rectangle = new Rectangle((int)objects.getMap().getHardWall().get(i).getX()+10,(int)objects.getMap().getHardWall().get(i).getY(),80,83);
            if (objects.getPlayers().get(0).getBounds().intersects(rectangle))
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
            Rectangle rectangle = new Rectangle((int)objects.getMap().getHardWall().get(i).getX(),(int)objects.getMap().getHardWall().get(i).getY()+20,83,80);
            if (objects.getPlayers().get(0).getBounds().intersects(rectangle))
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
            Rectangle rectangle = new Rectangle((int)objects.getMap().getHardWall().get(i).getX()+20,(int)objects.getMap().getHardWall().get(i).getY()+20,83,80);
            if (objects.getPlayers().get(0).getBounds().intersects(rectangle))
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
        for (int i = 0; i < objects.getBullets().size(); i++) {
            //collision with walls
            for (int j = 0; j < objects.getMap().getHardWall().size(); j++) {
//                Rectangle rectangle = new Rectangle((int) objects.getMap().getHardWall().get(j).getX() + 20, (int) objects.getMap().getHardWall().get(j).getY() + 20, 45, 45);
//                if (objects.getBullets().get(i).getBounds().intersects(rectangle)) {
                if (objects.getBullets().get(i).getBounds().intersects(objects.getMap().getHardWall().get(j).getBounds())) {
                    Sound sound = new Sound(Utility.bulletHitHardWall, false);
                    sound.playSound();
                    objects.getBullets().remove(i);
                    break;
                }
            }
        }
            //collision with buried robots
        for (int i = 0; i < objects.getBullets().size(); i++) {
            for(int j = 0 ; j < objects.getRobots().size() ; j++){
//                if(objects.getBullets().get(i).getBounds().intersects(new Rectangle((int)objects.getRobots().get(j).getX()+20,
//                        (int)objects.getRobots().get(j).getY()+20,
//                        60,60))){
                if (objects.getBullets().get(i).getBounds().intersects(objects.getRobots().get(j).getBounds())) {
                    damageRobot(objects,objects.getRobots().get(j),objects.getBullets().get(i).getDamage());
                    objects.getBullets().remove(i);
                    break;
                }
            }
        }
    }

    private static void damageRobot(Objects objects, BuriedRobot robot, int damage){
        robot.setHealth(robot.getHealth() - damage);
        if(robot.getHealth() <= 0){ // if robot health get down to zero it gets destroyed and must be removed from objects
            objects.getRobots().remove(robot);
        }
    }
}
