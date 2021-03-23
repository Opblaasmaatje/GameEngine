package system.textures;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class BufferedImageLoader {
    private BufferedImage image;

    public BufferedImage loadImage(String path){
        try{
            image = ImageIO.read(new File(path));
            return image;
        }catch (Exception e){
            System.out.println("Something went wrong. check again");
            return null;
        }
    }
}
