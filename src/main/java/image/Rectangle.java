package image;

import javafx.scene.paint.Color;

public class Rectangle implements Shape {

    int x,y;
    int width;
    int height;
    Color color;

    public Rectangle(int x, int y, int width, int height, Color color) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    //retourne vrai si le point est compris dans le rectangle et faux sinon
    @Override
    public boolean contains(Point point) {
        if ((point.x >= x && point.x<= x+width)&&(point.y>=y && point.y<=y+height) )
            return true;
        return false;
    }

    //retourne la couleur du rectangle
    @Override
    public Color getColor() {
        return color;
    }
}
