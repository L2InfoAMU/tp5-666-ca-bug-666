package image;

import javafx.scene.paint.Color;

import static util.Matrices.*;

public abstract class RasterImage implements Image {

    public int width;
    public int height;

    public RasterImage(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public RasterImage(Color[][] pixels){
        requiresNonNull(pixels);
        requiresNonZeroDimensions(pixels);
        this.width = pixels.length;
        this.height = pixels[0].length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    protected void setWidth(int width){
        this.width = width;
    }

    protected void setHeight(int height){
        this.height = height;
    }

    public abstract void createRepresentation();

    public abstract void setPixelColor(Color color, int x, int y);

    abstract void setPixelsColor(Color color);

    abstract void setPixelsColor(Color[][] pixels);

    public abstract Color getPixelColor(int x, int y);
}
