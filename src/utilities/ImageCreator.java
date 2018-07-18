/*
 * Decompiled with CFR 0_122.
 */
package utilities;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * 
 * @author manuelpamplona
 */
public class ImageCreator {
    public static void save(Image src, String ext, String name) {
        BufferedImage image = ImageCreator.toBufferedImage(src);
        String fileName = name;
        File file = new File(fileName + "." + ext);
        try {
            ImageIO.write((RenderedImage)image, ext, file);
        }
        catch (IOException e) {
            System.out.println("Write error for " + file.getPath() + ": " + e.getMessage());
        }
    }

    private static BufferedImage toBufferedImage(Image src) {
        int w = src.getWidth(null);
        int h = src.getHeight(null);
        int type = 1;
        BufferedImage dest = new BufferedImage(w, h, type);
        Graphics2D g2 = dest.createGraphics();
        g2.drawImage(src, 0, 0, null);
        g2.dispose();
        return dest;
    }
}

