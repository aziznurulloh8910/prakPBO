import greenfoot.*; 

public class GameOver extends Actor
{
    public void addedToWorld(World Latar) 
    {
        setImage(new GreenfootImage("GAME OVER",60, Color.RED,null));
    }
    
    public void act()
    {
        Greenfoot.stop();
    }
}
