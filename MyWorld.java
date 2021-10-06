import greenfoot.*; 

public class MyWorld extends World
{
    public boolean GAMEOVER=false;
    private int mscore=0;
    private Score score;
    public boolean song = true;
    public GreenfootSound songGame;
    
    public MyWorld()
    {    
        super(400, 400, 1,false); 

        Kepala kepala=new Kepala();
        addObject(kepala,100,200);

        Ular ular=new Ular();
        addObject(ular,kepala.getX()-Ular.delta,kepala.getY());
        ular.ular=kepala;

        addMakanan();

        score=new Score();
        score.setScore(mscore);
        addObject(score,getWidth()-75,35);
        prepare();
        
        songGame = new GreenfootSound("sound.wav");
    }

    public void addMakanan()
    {
        addObject(new Makanan(),Greenfoot.getRandomNumber(getWidth()/Ular.delta)*Ular.delta,Greenfoot.getRandomNumber(getHeight()/Ular.delta)*Ular.delta);
    }

    public void setScore(int a)
    {
        mscore+=a;
        score.setScore(mscore);
    }

    private void prepare()
    {
        titleGame titleGame = new titleGame();
        addObject(titleGame,115,47);
        titleGame.setLocation(105,40);
    }
    
    public void act(){
        if(song){
            songGame.play();
        }
        if(GAMEOVER=false){
            songGame.stop();
        }
    }
    
    public void started()
    {
        super.started();
        songGame.setVolume(100);
        songGame.playLoop();
    }

    public void stopped()
    {
        super.stopped();
        songGame.pause();
        song=false;
    }
}
