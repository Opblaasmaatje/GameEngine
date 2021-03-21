package system;

import java.awt.*;
import java.awt.Canvas;
import javax.swing.JFrame;

public class Window extends Canvas {
    public JFrame frame;

    public Window(Game game, int width, int height, String name){
        frame = new JFrame(name);
        frame.setMinimumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setPreferredSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.requestFocus();
        frame.toFront();
    }
}

