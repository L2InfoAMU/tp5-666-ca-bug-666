package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import static util.Matrices.*;

public class PaletteRasterImage extends RasterImage implements Image{
    //Définition des attributs

    public int width;
    public int height;
    int[][] indexesOfColors;
    List<Color> palette;

    //Implémentation des constructeurs
    public PaletteRasterImage(Color color, int width, int height) {
        super(width, height);
        createRepresentation();
        setPixelsColor(color);
    }

    public PaletteRasterImage(Color[][] pixels){
        super(pixels);
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

    protected void setPixelsColor(Color color){
        for(int index=0; index<width;index++){
            for(int secondIndex = 0; secondIndex<height; secondIndex++){
                setPixelColor(color,index,secondIndex);
            }
        }
    }

    protected void setPixelsColor(Color[][] pixels) {
        for (int index = 0; index < pixels.length; index++) {
            for (int secondIndex = 0; secondIndex < pixels[0].length; secondIndex++) {
                setPixelColor(pixels[index][secondIndex], index, secondIndex);
            }
        }
    }
}
