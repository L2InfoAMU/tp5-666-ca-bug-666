package image;

import javafx.scene.paint.Color;

import static util.Matrices.*;

public class BruteRasterImage implements Image {

    public int width;
    public int height;
    Color[][] pixels;

    public BruteRasterImage(Color color, int width, int height) {
        this.width = width;
        this.height = height;
        createRepresentation();
        setPixelsColor(color);
    }

    public BruteRasterImage(Color[][] colors) {
        requiresNonNull(colors);
        requiresNonZeroDimensions(colors);
        this.pixels = colors.clone();
        this.width = pixels.length;
        this.height = pixels[0].length;

    }


    //Implémentation des méthodes de l'interface
    @Override
    public Color getPixelColor(int x, int y) {
        return pixels[x][y];
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    //Implémentation des méthodes propres à la classe BruteRasterImage

    public void createRepresentation(){
       pixels = new Color[width][height];
    }

    public void setPixelColor(Color color, int x, int y){
        pixels[x][y] = color;
    }

    private void setPixelsColor(Color color){
        for(int index=0; index<width;index++){
            for(int secondIndex = 0; secondIndex<height; secondIndex++){
                pixels[index][secondIndex] = color;
            }
        }
    }

    private void setPixelsColor(Color[][] pixels) {
        for (int index = 0; index < pixels.length; index++) {
            for (int secondIndex = 0; secondIndex < pixels[0].length; secondIndex++) {
                setPixelColor(pixels[index][secondIndex], index,secondIndex);
            }
        }
    }

    protected void setWidth(int width){
        this.width = width;
    }

    protected void setHeight(int height){
        this.height = height;
    }

}
