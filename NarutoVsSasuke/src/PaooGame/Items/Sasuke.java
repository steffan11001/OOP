package PaooGame.Items;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.time.YearMonth;
import java.util.concurrent.TimeUnit;
import PaooGame.Graphics.Animation;
import PaooGame.RefLinks;
import PaooGame.Graphics.Assets;

/*! \class public class Hero extends Character
    \brief Implementeaza notiunea de erou/player (caracterul controlat de jucator).

    Elementele suplimentare pe care le aduce fata de clasa de baza sunt:
        imaginea (acest atribut poate fi ridicat si in clasa de baza)
        deplasarea
        atacul (nu este implementat momentan)
        dreptunghiul de coliziune
 */
public class Sasuke extends Character
{
    /*!< Referinta catre imaginea curenta a eroului.*/
    //Animation
    private Animation animSasukeStaticRight, animSasukeStaticLeft,animSasukeRunRight,animSasukeRunLeft,animSasukeComboLeft;
    private long lastAttackTimer, attackCooldown = 100, attackTimer = attackCooldown;


    /*! \fn public Hero(RefLinks refLink, float x, float y)
        \brief Constructorul de initializare al clasei Hero.

        \param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
        \param x Pozitia initiala pe axa X a eroului.
        \param y Pozitia initiala pe axa Y a eroului.
     */
    public Sasuke(RefLinks refLink, float x, float y)
    {
        ///Apel al constructorului clasei de baza
        super(refLink, x,y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);
        ///Seteaza imaginea de start a eroului
        //image = Assets.narutoStaticRight1;

        animSasukeStaticRight=new Animation(200,Assets.sasukeStaticRight);
        animSasukeStaticLeft=new Animation(200,Assets.sasukeStaticLeft);
        animSasukeRunLeft=new Animation(100,Assets.sasukeRunLeft);
        animSasukeRunRight=new Animation(100,Assets.sasukeRunRight);
        animSasukeComboLeft=new Animation(70,Assets.sasukeComboLeft);



        ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea implicita(normala)
        normalBounds.x = 23;
        normalBounds.y = 25;
        normalBounds.width = 50;
        normalBounds.height = 70;

        ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea de atac
        attackBounds.x = 10;
        attackBounds.y = 10;
        attackBounds.width = 70;
        attackBounds.height = 70;
    }

    /*! \fn public void Update()
        \brief Actualizeaza pozitia si imaginea eroului.
     */
    @Override
    public void Update()  {
        animSasukeStaticRight.timer();
        animSasukeStaticLeft.timer();
        animSasukeRunRight.timer();
        animSasukeRunLeft.timer();
        animSasukeComboLeft.timer();
        ///Verifica daca a fost apasata o tasta
        GetInput();
        ///Actualizeaza pozitia
        Move();

        CheckAttack();
    }

    private void CheckAttack()
    {

        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if(attackTimer < attackCooldown)
            return;

        Rectangle cb=getCollisionBounds(0,0);
        Rectangle attackRec=new Rectangle();
        int attackRecSize= 100;
        attackRec.width=attackRecSize;
        attackRec.height=attackRecSize;

        if(refLink.GetKeyManager().player2attack)
        {
            attackRec.x= cb.x - attackRecSize;
            attackRec.y=cb.y +cb.height /2 - attackRecSize/2;
        }

        attackTimer = 0;

        for(Item it: refLink.GetMap().GetItemsManager().GetPlayers())
        {
            if (it.equals(this))
                continue;
            if (it.getCollisionBounds(0, 0).intersects(attackRec)) {
                it.Hurt(10);
                return;
            }
        }

          /*
        if (getCollisionBounds(0, 0).intersects(attackRec))
            Hurt(1);


         */


    }

    /*! \fn private void GetInput()
        \brief Verifica daca a fost apasata o tasta din cele stabilite pentru controlul eroului.
     */
    private void GetInput()
    {
        ///Implicit eroul nu trebuie sa se deplaseze daca nu este apasata o tasta
        xMove = 0;
        yMove = 0;
        ///Verificare apasare tasta "sus"
        /*
        if(refLink.GetKeyManager().up)
        {
            yMove = -speed;
        }
            ///Verificare apasare tasta "jos"
        if(refLink.GetKeyManager().down)
        {
            yMove = speed;
        }

         */
        ///Verificare apasare tasta "left"
        if(refLink.GetKeyManager().left)
        {
            xMove = -speed;
        }
        ///Verificare apasare tasta "dreapta"
        if(refLink.GetKeyManager().right)
        {
            xMove = speed;
        }

    }
    @Override
    public void Die(){

    }

    /*! \fn public void Draw(Graphics g)
        \brief Randeaza/deseneaza eroul in noua pozitie.

        \brief g Contextul grafi in care trebuie efectuata desenarea eroului.
     */
    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(getCurrentAnimationFrame(), (int) x, (int) y, width, height, null);

        ///doar pentru debug daca se doreste vizualizarea dreptunghiului de coliziune altfel se vor comenta urmatoarele doua linii
        //g.setColor(Color.green);
        //g.fillRect((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);
    }

    private BufferedImage getCurrentAnimationFrame()
    {
        ///Actualizeaza imaginea
        if(xMove<0)
            return animSasukeRunLeft.getCurrentImage();
        else if(xMove>0)
            return animSasukeRunRight.getCurrentImage();
        else if(refLink.GetKeyManager().player2attack)
            return animSasukeComboLeft.getCurrentImage();
        else
            return animSasukeStaticLeft.getCurrentImage();

    }
}
