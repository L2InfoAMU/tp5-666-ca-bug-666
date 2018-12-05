package image;

import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

public class SparseRasterImage extends RasterImage implements Image {

    Map<Point,Color> colorMap;

    public SparseRasterImage(Color color, int width, int height) {
        super(color, width, height);
    }

    public SparseRasterImage(Color[][] pixels) {
        super(pixels);
    }

    @Override
    public void createRepresentation() {
        colorMap = new HashMap<Point,Color>(getHeight()*getWidth());
    }

    @Override
    public void setPixelColor(Color color, int x, int y) {
    Point toAddPoint = new Point(x,y);
    colorMap.put(toAddPoint,color);
    }

    @Override
    public Color getPixelColor(int x, int y) {
        Point point = new Point(x,y);
        return colorMap.get(point);
    }
}
