package image;

import javafx.scene.paint.Color;

import static util.Matrices.*;

public abstract class RasterImage implements Image {

    public int width;
    public int height;

    public RasterImage(Color color, int width, int height) {
        this.width = width;
        this.height = height;
        setPixelsColor(color);
    }

    public RasterImage(Color[][] pixels){
        requiresNonNull(pixels);
        requiresNonZeroDimensions(pixels);
        this.width = pixels.length;
        this.height = pixels[0].length;
        createRepresentation();
        setPixelsColor(pixels);
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

    protected void setPixelsColor(Color color){
        for(int index=0; index<width;index++){
            for(int secondIndex = 0; secondIndex<height; secondIndex++){
                setPixelColor(color, index,secondIndex);
            }
        }
    }

    protected void setPixelsColor(Color[][] pixels) {
        for (int index = 0; index < pixels.length; index++) {
            for (int secondIndex = 0; secondIndex < pixels[0].length; secondIndex++) {
                setPixelColor(pixels[index][secondIndex], index,secondIndex);
            }
        }
    }

    public abstract Color getPixelColor(int x, int y);
}
