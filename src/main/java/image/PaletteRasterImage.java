package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import static util.Matrices.*;

public class PaletteRasterImage implements Image{
    //Définition des attributs

    public int width;
    public int height;
    int[][] indexesOfColors;
    List<Color> palette;

    //Implémentation des constructeurs
    public PaletteRasterImage(Color color, int width, int height) {
        this.width = width;
        this.height = height;
        createRepresentation();
        setPixelsColor(color);
    }

    public PaletteRasterImage(Color[][] pixels){
        requiresNonNull(pixels);
        requiresNonZeroDimensions(pixels);
        this.width = pixels.length;
        this.height = pixels[0].length;
        createRepresentation();
        setPixelsColor(pixels);

    }

    //Implémentation des méthodes de l'interface Image
    @Override

    public Color getPixelColor(int x, int y) {
        return  palette.get(indexesOfColors[x][y]);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    //Implémentation des méthodes propres à PaletteRasterImage


    public void createRepresentation(){
        palette = new ArrayList<>();
        indexesOfColors = new int[width][height];
    }

    public void setPixelColor(Color color, int x, int y){
        if(!palette.contains(color))
            palette.add(color);
        indexesOfColors[x][y]=palette.indexOf(color);
    }

    private void setPixelsColor(Color color){
        for(int index=0; index<width;index++){
            for(int secondIndex = 0; secondIndex<height; secondIndex++){
                setPixelColor(color,index,secondIndex);
            }
        }
    }

    private void setPixelsColor(Color[][] pixels) {
        for (int index = 0; index < pixels.length; index++) {
            for (int secondIndex = 0; secondIndex < pixels[0].length; secondIndex++) {
                setPixelColor(pixels[index][secondIndex], index, secondIndex);
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
