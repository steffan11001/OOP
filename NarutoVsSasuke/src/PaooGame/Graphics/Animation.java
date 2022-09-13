package PaooGame.Graphics;

import java.awt.*;
import java.awt.image.BufferedImage;



public class Animation  {
    private int speed,index;
    private long lastTime,currentTime;

    private BufferedImage[] frames;


    public Animation(int speed , BufferedImage[] frames)
    {
        this.speed = speed;
        this.frames=frames;
        index=0;
        lastTime=System.currentTimeMillis();
    }

    public void timer()
    {
        currentTime+=System.currentTimeMillis()-lastTime;
        lastTime=System.currentTimeMillis();

        if(currentTime>speed){
            index++;
            currentTime=0;
            if(index>=frames.length)
                index=0;
        }

    }

    public BufferedImage getCurrentImage()
    {
        return frames[index];
    }
}
