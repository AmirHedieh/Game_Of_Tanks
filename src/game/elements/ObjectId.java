package game.elements;

public enum ObjectId
{
    Player,              //lightPink(208, 135, 190)
    MachineGun,
    MissileGun,
    LightBullet,
    HeavyBullet,
    AITank,              //Orange(255, 114, 0)            ||    if it has damage upgrade under red(255, 0, 0)     ||    if it has tank health upgrade under Phosphoric(213, 236, 6)
    BuriedRobot,         //black(0, 0, 0)
    Turret,              //darkYellow(166, 166, 76)       ||      if it is dual turret darkGreen(22, 62, 34)            ||    if it has update active weapon under lightOrange(221, 171, 36)
    HardWall,            //yellow (255, 255, 0)
    SoftWall,            //blue (0, 0, 255)
    Plant,               //green (0, 255, 0)
    Soil,                //white (255, 255, 255)
    Teazel,              //purple (255, 0, 255)
    ServerPlayer,
    ClientPlayer,
    SinglePlayer,
    Alone,
    TwoPlayer,
    DamageUpgrade,
    MissileGunUpgrade,   //lightBlue(88, 162, 230)
    MachineGunUpgrade,   //lightGreen(143, 202, 160)
    HealthUpgrade,       //under the AITank
    ShieldUpgrade;
}
