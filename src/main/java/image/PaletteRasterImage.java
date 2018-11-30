package image;

import javafx.scene.paint.Color;

import java.util.List;

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

    }

    public PaletteRasterImage(Color[][] pixels){

    }

    //Implémentation des méthodes de l'interface Image
    //TODO modifier les méthodes pour avoir des retours corrects
    @Override
    public Color getPixelColor(int x, int y) {
        return null;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    //Implémentation des méthodes propres à PaletteRasterImage

    //TODO implémenter les méthodes

    public void createRepresentation(){
        palette = null;
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
