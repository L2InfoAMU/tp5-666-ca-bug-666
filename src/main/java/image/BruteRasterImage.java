package image;

import javafx.scene.paint.Color;
import static util.Matrices.requiresNonNull;

public class BruteRasterImage {
    public Color color;
    public int width;
    public int height;
    Color[][] pixels;

    public BruteRasterImage(Color color, int width, int height) {
        this.color = color;
        this.width = width;
        this.height = height;
    }

    public BruteRasterImage(Color[][] pixels) {
        requiresNonNull(pixels);
        this.pixels = pixels;
    }

    //TODO implémenter les méthodes




}
