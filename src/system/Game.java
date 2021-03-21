package system;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
    public boolean running = false;
    public Window window;
    public int height = 400;
    public int width = 600;
    public static int current_fps;

    public Game(){
        window = new Window(this, width, height, "xddd");
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
                current_fps = frames;
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

        g.setColor(Color.RED);
        g.fillRect(50,50, 20, 20);

        g.dispose();
        bs.show();
    }

    public void tick(){
        System.out.println(current_fps);
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
