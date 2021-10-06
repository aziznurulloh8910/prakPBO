import greenfoot.*;

public class Kepala extends Ular
{    
    public void addUlar()
    {
        
    }
    
    public void act() 
    {
        Actor actor=getOneIntersectingObject(Ular.class);
        if(actor!=null){
            getWorld().addObject(new GameOver(),(int)(0.5*getWorld().getWidth()),(int)(0.5*getWorld().getHeight()));
            ((MyWorld)getWorld()).GAMEOVER=true;
            Greenfoot.playSound("fail.WAV");
            return;
        }
        
        actor=getOneIntersectingObject(Makanan.class);
        if(actor!=null){
            getWorld().removeObject(actor);
            Greenfoot.playSound("eat.mp3");
            ((MyWorld)getWorld()).setScore(1);
            Ular.ADDEKOR=true;
            ((MyWorld)getWorld()).addMakanan();
        }
        
        if(Greenfoot.isKeyDown("up") && arahy!=1){
            arahx=0;
            arahy=-1;
        }else if(Greenfoot.isKeyDown("down") && arahy!=-1){
            arahx=0;
            arahy=1;
        }else if(Greenfoot.isKeyDown("right") && arahx!=-1){
            arahx=1;
            arahy=0;
        }else if(Greenfoot.isKeyDown("left") && arahx!=1){
            arahx=-1;
            arahy=0;
        }
        super.act();
    }    
}
