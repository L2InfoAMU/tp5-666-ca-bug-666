package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage extends RasterImage implements Image{
    //Définition des attributs

    int[][] indexesOfColors;
    List<Color> palette;

    //Implémentation des constructeurs
    public PaletteRasterImage(Color color, int width, int height) {
        super(width, height);
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

}
