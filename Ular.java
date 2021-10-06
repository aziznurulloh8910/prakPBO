import greenfoot.*;  

public class Ular extends Actor
{
    public Ular ular;
    public static int delta=10;
    public int arahx=1,arahy=0,posx=0,posy=0;
    public static boolean ADDEKOR=false;
    protected boolean SUDAHTAMBAH=false;
    
    public void addedToWorld(World Latar)
    {
        setGambar(delta);
        posx=getX();
        posy=getY();  
        SUDAHTAMBAH=false;
    }
    
    private void setGambar(int d)
    {
        GreenfootImage image=new GreenfootImage(d,d);
        image.setColor(Color.BLACK);
        image.fill();
        setImage(image);
    }
    
    public void addUlar()
    {
        if(SUDAHTAMBAH)return;
        Ular ularo=new Ular();
        ularo.ular=this;
        getWorld().addObject(ularo,getX(),getY());
        SUDAHTAMBAH=true;
        ADDEKOR=false;
    }
    
    public void act() 
    {
        if(((MyWorld)getWorld()).GAMEOVER)return;
        posx=getX();
        posy=getY();
        if(ular!=null)
        {
            if((getX()==ular.posx && getY()==ular.posy)||(getX()==ular.getX() && getY()==ular.getY()))
            {
            
            }
            else 
            {
                setLocation(ular.posx,ular.posy); 
            }
        }
        else
        {
            int px=getX()+arahx*delta;
            int py=getY()+arahy*delta;
            if(px>getWorld().getWidth()+delta)px=-delta;
            if(px<-delta)px=getWorld().getWidth()+delta;
            if(py>getWorld().getHeight()+delta)py=-delta;
            if(py<-delta)py=getWorld().getHeight()+delta;
            setLocation(px,py);
        }     
        if(ADDEKOR)addUlar();  
    }    
}
