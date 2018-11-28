package image;

import javafx.scene.paint.Color;

import static util.Matrices.getColumnCount;
import static util.Matrices.getRowCount;
import static util.Matrices.requiresNonNull;

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
        requiresNonNull(pixels);
        this.pixels = colors.clone();
        this.width = getRowCount(pixels);
        this.height = getColumnCount(pixels);

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

    //TODO implémenter les méthodes
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

}
