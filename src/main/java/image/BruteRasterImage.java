package image;

import javafx.scene.paint.Color;

import static util.Matrices.*;

public class BruteRasterImage extends RasterImage implements Image{

    public int width;
    public int height;
    Color[][] pixels;

    public BruteRasterImage(Color color, int width, int height) {
        super(width,height);
        createRepresentation();
        setPixelsColor(color);
    }

    public BruteRasterImage(Color[][] pixels) {
        super(pixels);
        this.pixels = pixels.clone();
    }


    //Implémentation des méthodes de l'interface
    @Override
    public Color getPixelColor(int x, int y) {
        return pixels[x][y];
    }


    //Implémentation des méthodes propres à la classe BruteRasterImage

    public void createRepresentation(){
       pixels = new Color[width][height];
    }


    public void setPixelColor(Color color, int x, int y){
        pixels[x][y] = color;
    }

     protected void setPixelsColor(Color color){
        for(int index=0; index<width;index++){
            for(int secondIndex = 0; secondIndex<height; secondIndex++){
                pixels[index][secondIndex] = color;
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

}
