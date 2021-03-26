package game.system;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class KeyInput extends KeyAdapter {

    private Handler handler;
    public static HashMap<Integer, Boolean> keys_down = new HashMap<>();

    public KeyInput(Handler handler){
        this.handler = handler;

        //initialze keys
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
//
//            }
//        }
        if(key == KeyEvent.VK_ESCAPE) System.exit(1);
    }



    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        keys_down.put(key, false);
    }
}
