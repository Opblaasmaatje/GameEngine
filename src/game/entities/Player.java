package game.entities;

import game.system.*;
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

        y = Helper.clamp(y, 0, Game.width - 85);
        x = Helper.clamp(x, 0, Game.width - 85);
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
