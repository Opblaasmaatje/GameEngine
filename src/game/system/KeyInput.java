package game.system;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class KeyInput extends KeyAdapter {

    private Handler handler;
    public static HashMap<Integer, Boolean> keys_down = new HashMap<>();

    public KeyInput(Handler handler){
        this.handler = handler;

        keys_down.put(KeyEvent.VK_A, false);
        keys_down.put(KeyEvent.VK_S, false);
        keys_down.put(KeyEvent.VK_D, false);
        keys_down.put(KeyEvent.VK_W, false);
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        keys_down.put(key, true);
//        for (int i = 0 ; i < handler.object.size(); i++){
//            GameObject tempObject = handler.object.get(i);

//            if(tempObject.getId() == ID.player){
//                // player movement here
//                switch (key) {
//                    case KeyEvent.VK_W -> tempObject.setVelY(-5);
//                    case KeyEvent.VK_S -> tempObject.setVelY(5);
//                    case KeyEvent.VK_A -> tempObject.setVelX(-5);
//                    case KeyEvent.VK_D -> tempObject.setVelX(5);
//                }
//            }
//        }
        if(key == KeyEvent.VK_ESCAPE) System.exit(1);
    }



    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        keys_down.put(key, false);
//        for (int i = 0 ; i < handler.object.size(); i++){
//            GameObject tempObject = handler.object.get(i);
//            if(tempObject.getId() == ID.player){
//                // player movement here
//                switch (key) {
//                    case KeyEvent.VK_W, KeyEvent.VK_S -> tempObject.setVelY(0);
//                    case KeyEvent.VK_A, KeyEvent.VK_D -> tempObject.setVelX(0);
//                }
//            }
//        }
    }
}
