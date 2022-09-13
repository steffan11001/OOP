package PaooGame.States;


import PaooGame.Items.Item;
import PaooGame.RefLinks;
import PaooGame.Maps.Map;

import java.awt.*;
import java.util.ArrayList;

/*! \class public class PlayState extends State
    \brief Implementeaza/controleaza jocul.
 */
public class PlayState extends State
{

    private Map map;    /*!< Referinta catre harta curenta.*/

    //private Pock rock;

    /*! \fn public PlayState(RefLinks refLink)
        \brief Constructorul de initializare al clasei

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public PlayState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza
        super(refLink);
            ///Construieste harta jocului
        map = new Map(refLink);
            ///Referinta catre harta construita este setata si in obiectul shortcut pentru a fi accesibila si in alte clase ale programului.
        refLink.SetMap(map);
            ///Construieste eroul



        //rock = new Pock (refLink,100, 100);
    }

    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a jocului.
     */
    @Override
    public void Update()
    {
        map.Update();
        if(refLink.GetMouseManager().getxMouse()>=450 && refLink.GetMouseManager().getxMouse()<=510 &&
                refLink.GetMouseManager().getyMouse()>=25 && refLink.GetMouseManager().getyMouse()<=60&&
                refLink.GetMouseManager().isLeftClick())
        {
            State.SetState(refLink.GetGame().getMenuState());
        }


    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a jocului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */

    @Override
    public void Draw(Graphics g)
    {

        map.Draw(g);


        //rock.Draw(g);
    }


}
