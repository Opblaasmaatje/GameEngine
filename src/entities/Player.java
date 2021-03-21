package entities;

import system.GameObject;
import system.ID;

import java.awt.*;

public class Player extends GameObject {


    public Player(int x, int y, ID id) {
        super(x, y, id);

        velX = 1;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(x, y,40,40);
    }
}
