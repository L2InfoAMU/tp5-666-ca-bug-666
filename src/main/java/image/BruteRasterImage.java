package image;

import javafx.scene.paint.Color;


public class BruteRasterImage extends RasterImage implements Image{

    Color[][] pixels;

    public BruteRasterImage(Color color, int width, int height) {
        super(width,height);
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

}
