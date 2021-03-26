package game.entities;

import game.system.Game;
import game.system.GameObject;
import game.system.ID;
import game.system.KeyInput;
import game.system.textures.Textures;

import java.awt.*;
import java.awt.event.KeyEvent;

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
        movePLayer();


    }

    private void movePLayer(){
        if(KeyInput.keys_down.get(KeyEvent.VK_W)){
            velY = -5;
        }
        else if(KeyInput.keys_down.get(KeyEvent.VK_S)) {
            velY = 5;
        }
        else {
            velY = 0;
        }

        if(KeyInput.keys_down.get(KeyEvent.VK_A)){
            velX = -5;
        } else if(KeyInput.keys_down.get(KeyEvent.VK_D)){
            velX = 5;
        } else{
            velX = 0;
        }
    }


    @Override
    public void render(Graphics g) {
        g.drawImage(Textures.player_sheet.getSubimage(0,0,32,32), x ,y , 80, 80, null);
    }
}
