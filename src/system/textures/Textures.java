package system.textures;

import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Textures {
    private static BufferedImageLoader loader = new BufferedImageLoader();
    public static BufferedImage player_sheet;

    public Textures(){
        player_sheet = loader.loadImage("assets/sprites/player/player_sheet.png");
    }

}
