package entities;

import system.GameObject;
import system.ID;

import java.awt.*;

public class Player extends GameObject {

    public Player(int x, int y, ID id) {
        super(x, y, id);



    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
    }

    @Override
    public void render(Graphics g) {
        if(id == ID.player) g.setColor(Color.WHITE);
        g.fillRect(x, y,40,40);
    }
}
