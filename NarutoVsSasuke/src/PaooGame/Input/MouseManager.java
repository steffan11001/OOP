package PaooGame.Input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener {

    private boolean leftClick,rightClick;
    private int xMouse,yMouse;

    public MouseManager()
    {
    }

    public boolean isLeftClick() {
        return leftClick;
    }

    public boolean isRightClick() {
        return rightClick;
    }

    public int getxMouse() {
        return xMouse;
    }

    public int getyMouse() {
        return yMouse;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
            if(e.getButton()==MouseEvent.BUTTON1)
            {
                leftClick=true;
            }
            else if(e.getButton()==MouseEvent.BUTTON3)
            {
                rightClick=true;
            }
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1)
        {
            leftClick=false;
        }
        else if(e.getButton()==MouseEvent.BUTTON3)
        {
            rightClick=false   ;
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        xMouse=e.getX();
        yMouse=e.getY();

    }
}
