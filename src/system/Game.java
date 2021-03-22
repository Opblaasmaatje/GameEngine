package system;

import entities.BasicEnemy;
import entities.Player;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {
    public boolean running = false;
    public Window window;
    public static int width = 800;
    public static int height = width / 12 * 9;
    public static int current_fps;
    private Handler handler;
    private Random r;

    public Game(){
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        window = new Window(this, width, height, "xddd");
        handler.addObject(new Player(400,300,ID.player));
        handler.addObject(new BasicEnemy(0,0, ID.BasicEnemy));
        start();
    }

    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running)
                render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
//                current_fps = frames;
                frames = 0;
            }
        }
        stop();
    }

    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0,0, width, height);

        handler.render(g);

        g.dispose();
        bs.show();
    }

    public static int clamp(int var, int min, int max){
        if(var >= max) return max;
        else if(var <= min) return min;
        return var;
    }

    public void tick(){
        System.out.println(current_fps);
        handler.tick();
    }

    public static void main(String[] args){
        new Game();
    }

    public synchronized void start(){
        running = true;
        new Thread(this).start();
    }

    public void stop(){
        running = false;
    }
}
