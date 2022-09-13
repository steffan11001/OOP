package PaooGame.Graphics;

import java.awt.*;
import java.awt.font.ImageGraphicAttribute;
import java.awt.image.BufferedImage;

/*! \class public class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Game assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */
public class Assets
{
        /// Referinte catre elementele grafice (dale) utilizate in joc.
    public static BufferedImage heroLeft;
    public static BufferedImage heroRight;
    public static BufferedImage soil;
    public static BufferedImage grass;
    public static BufferedImage mountain;
    public static BufferedImage townGrass;
    public static BufferedImage townGrassDestroyed;
    public static BufferedImage townSoil;
    public static BufferedImage water;
    public static BufferedImage rockUp;
    public static BufferedImage rockDown;
    public static BufferedImage rockLeft;
    public static BufferedImage rockRight;
    public static BufferedImage tree;
    public static BufferedImage backGround;
    public static BufferedImage menuBackground;
    public static BufferedImage instruction;


    public static BufferedImage[] narutoStaticRight;
    public static BufferedImage[] narutoStaticLeft;
    public static BufferedImage[] narutoRunRight;
    public static BufferedImage[] narutoRunLeft;
    public static BufferedImage[] narutoComboRight;


    public static BufferedImage[] sasukeStaticRight;
    public static BufferedImage[] sasukeStaticLeft;
    public static BufferedImage[] sasukeRunRight;
    public static BufferedImage[] sasukeRunLeft;
    public static BufferedImage[] sasukeComboLeft;




    /*! \fn public static void Init()
        \brief Functia initializaza referintele catre elementele grafice utilizate.

        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void Init()
    {
            /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/PaooGameSpriteSheet.png"));
        SpriteSheet theEnd = new SpriteSheet(ImageLoader.LoadImage("/textures/b2.png"));
        SpriteSheet menuBackGr=new SpriteSheet(ImageLoader.LoadImage("/textures/background.png"));
        SpriteSheet naruto = new SpriteSheet(ImageLoader.LoadImage("/textures/unity0.png"));
        SpriteSheet sasuke = new SpriteSheet(ImageLoader.LoadImage("/textures/SasukeSpriteSheet.png"));
        SpriteSheet in = new SpriteSheet(ImageLoader.LoadImage("/textures/Intruction.png"));

        //player1 =naruto.cropHero(0,0);
        /// Se obtin subimaginile corespunzatoare elementelor necesare.
        backGround=theEnd.cropBack(0,0);
        menuBackground=menuBackGr.cropBack(0,0);
        instruction=in.cropBack(0,0);

        narutoStaticRight=new BufferedImage[6];
        narutoStaticLeft=new BufferedImage[6];
        narutoRunRight=new BufferedImage[6];
        narutoRunLeft=new BufferedImage[6];
        narutoComboRight=new BufferedImage[8];

        sasukeStaticRight=new BufferedImage[4];
        sasukeStaticLeft=new BufferedImage[4];
        sasukeRunLeft=new BufferedImage[6];
        sasukeRunRight=new BufferedImage[6];
        sasukeComboLeft=new BufferedImage[12];



        narutoStaticRight[0]= naruto.cropHero(0,0);
        narutoStaticRight[1]= naruto.cropHero(1,0);
        narutoStaticRight[2]= naruto.cropHero(2,0);
        narutoStaticRight[3]= naruto.cropHero(3,0);
        narutoStaticRight[4]= naruto.cropHero(4,0);
        narutoStaticRight[5]= naruto.cropHero(5,0);

        narutoStaticLeft[0]=naruto.cropHero(6,0);
        narutoStaticLeft[1]=naruto.cropHero(10,0);
        narutoStaticLeft[2]=naruto.cropHero(7,0);
        narutoStaticLeft[3]=naruto.cropHero(8,0);
        narutoStaticLeft[4]=naruto.cropHero(9,0);
        narutoStaticLeft[5]=naruto.cropHero(11,0);



        narutoRunRight[0]=naruto.cropHeroRun(0,1);
        narutoRunRight[1]=naruto.cropHeroRun(1,1);
        narutoRunRight[2]=naruto.cropHeroRun(2,1);
        narutoRunRight[3]=naruto.cropHeroRun(3,1);
        narutoRunRight[4]=naruto.cropHeroRun(4,1);
        narutoRunRight[5]=naruto.cropHeroRun(5,1);

        narutoRunLeft[0]=naruto.cropHeroRun(6,1);
        narutoRunLeft[1]=naruto.cropHeroRun(7,1);
        narutoRunLeft[2]=naruto.cropHeroRun(8,1);
        narutoRunLeft[3]=naruto.cropHeroRun(9,1);
        narutoRunLeft[4]=naruto.cropHeroRun(10,1);
        narutoRunLeft[5]=naruto.cropHeroRun(11,1);

        narutoComboRight[0]=naruto.cropHero(0,2);
        narutoComboRight[1]=naruto.cropHero(1,2);
        narutoComboRight[2]=naruto.cropHero(2,2);
        narutoComboRight[3]=naruto.cropHero(3,2);
        narutoComboRight[4]=naruto.cropHero(4,2);
        narutoComboRight[5]=naruto.cropHero(5,2);
        narutoComboRight[6]=naruto.cropHero(6,2);
        narutoComboRight[7]=naruto.cropHero(7,2);



        sasukeStaticRight[0]=sasuke.cropHero(0,0);
        sasukeStaticRight[1]=sasuke.cropHero(1,0);
        sasukeStaticRight[2]=sasuke.cropHero(2,0);
        sasukeStaticRight[3]=sasuke.cropHero(3,0);

        sasukeStaticLeft[0]=sasuke.cropHero(4,0);
        sasukeStaticLeft[1]=sasuke.cropHero(5,0);
        sasukeStaticLeft[2]=sasuke.cropHero(6,0);
        sasukeStaticLeft[3]=sasuke.cropHero(7,0);

        sasukeRunRight[0]= sasuke.cropHero(0,1);
        sasukeRunRight[1]= sasuke.cropHero(1,1);
        sasukeRunRight[2]= sasuke.cropHero(2,1);
        sasukeRunRight[3]= sasuke.cropHero(3,1);
        sasukeRunRight[4]= sasuke.cropHero(4,1);
        sasukeRunRight[5]= sasuke.cropHero(5,1);

        sasukeRunLeft[0]=sasuke.cropHero(6,1);
        sasukeRunLeft[1]=sasuke.cropHero(7,1);
        sasukeRunLeft[2]=sasuke.cropHero(8,1);
        sasukeRunLeft[3]=sasuke.cropHero(9,1);
        sasukeRunLeft[4]=sasuke.cropHero(10,1);
        sasukeRunLeft[5]=sasuke.cropHero(11,1);

        sasukeComboLeft[11]=sasuke.cropHero(0,3);
        sasukeComboLeft[10]=sasuke.cropHero(1,3);
        sasukeComboLeft[9]=sasuke.cropHero(2,3);
        sasukeComboLeft[8]=sasuke.cropHero(3,3);
        sasukeComboLeft[7]=sasuke.cropHero(4,3);
        sasukeComboLeft[6]=sasuke.cropHero(5,3);
        sasukeComboLeft[5]=sasuke.cropHero(6,3);
        sasukeComboLeft[4]=sasuke.cropHero(7,3);
        sasukeComboLeft[3]=sasuke.cropHero(8,3);
        sasukeComboLeft[2]=sasuke.cropHero(9,3);
        sasukeComboLeft[1]=sasuke.cropHero(10,3);
        sasukeComboLeft[0]=sasuke.cropHero(11,3);






        grass = sheet.crop(0, 0);
        soil = sheet.crop(1, 0);
        water = sheet.crop(2, 0);
        mountain = sheet.crop(3, 0);
        townGrass = sheet.crop(0, 1);
        townGrassDestroyed = sheet.crop(1, 1);
        townSoil = sheet.crop(2, 1);
        tree = sheet.crop(3, 1);
        heroLeft = sheet.crop(0, 2);
        heroRight = sheet.crop(1, 2);
        rockUp = sheet.crop(2, 2);
        rockDown = sheet.crop(3, 2);
        rockLeft = sheet.crop(0, 3);
        rockRight = sheet.crop(1, 3);
    }
}
