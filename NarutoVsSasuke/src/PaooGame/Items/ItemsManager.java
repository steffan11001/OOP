package PaooGame.Items;

import PaooGame.RefLinks;

import java.awt.*;
import java.util.ArrayList;

public class ItemsManager {

    private RefLinks refLinks;
    private ArrayList<Item> players;


    public ItemsManager(RefLinks refLinks)
    {
        this.refLinks=refLinks;
        this.players= new ArrayList<Item>();
    }

    public void Update()
    {
        for(int i=0;i< players.size();i++)
        {
            Item it= players.get(i);
            it.Update();
            if(!it.isActive())
            {
                players.remove(it);
            }
        }


    }

    public void addItem(Item it)
    {
        players.add(it);
    }

    public void Draw(Graphics g)
    {
        for(Item it: players)
        {
            it.Draw(g);
        }
        g.setColor(Color.red);

        g.fillRect(20,20,players.get(0).GetLife(),30);
        g.fillRect(540, 20,players.get(1).GetLife(),30);
    }

    public RefLinks getRefLinks() {
        return refLinks;
    }

    public ArrayList<Item> GetPlayers() {
        return players;
    }
}
