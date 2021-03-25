package entities;

import system.Game;
import system.GameObject;
import system.ID;
import system.textures.SpriteSheet;
import system.textures.Textures;

import java.awt.*;

public class Player extends GameObject {

    public Player(int x, int y, ID id) {
        super(x, y, id);

    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        y = Game.clamp(y, 0, Game.height);
        x = Game.clamp(x, 0, Game.width);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Textures.player_sheet.getSubimage(0,0,32,32), x ,y , 80, 80, null);
    }
}
