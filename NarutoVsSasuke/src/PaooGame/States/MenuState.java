package PaooGame.States;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import javax.swing.*;
import java.awt.*;

/*! \class public class MenuState extends State
    \brief Implementeaza notiunea de menu pentru joc.
 */
public class MenuState extends State
{
    /*! \fn public MenuState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public MenuState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza.
        super(refLink);
    }
    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a meniului.
     */
    @Override
    public void Update()
    {
        if(refLink.GetMouseManager().getxMouse()>=440 && refLink.GetMouseManager().getxMouse()<=525 &&
                refLink.GetMouseManager().getyMouse()>=140 && refLink.GetMouseManager().getyMouse()<=200&&
                refLink.GetMouseManager().isLeftClick())
        {
            State.SetState(refLink.GetGame().getPlayState());
        }
        if(refLink.GetMouseManager().getxMouse()>=365 && refLink.GetMouseManager().getxMouse()<=600 &&
                refLink.GetMouseManager().getyMouse()>=200 && refLink.GetMouseManager().getyMouse()<=260&&
                refLink.GetMouseManager().isLeftClick())
        {
            State.SetState(refLink.GetGame().getSettingsState());
        }
        if(refLink.GetMouseManager().getxMouse()>=430 && refLink.GetMouseManager().getxMouse()<=530 &&
                refLink.GetMouseManager().getyMouse()>=260 && refLink.GetMouseManager().getyMouse()<=320&&
                refLink.GetMouseManager().isLeftClick())
        {
            System.exit(0);
        }




    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a meniului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(Assets.menuBackground,(int)0,(int)0,960,480,null);

        //g.drawRect(415,135,125,60);

    }
}
