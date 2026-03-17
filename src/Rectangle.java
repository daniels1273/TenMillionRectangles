import java.util.ArrayList;

public class Rectangle {

    private int length;
    private int width;
    private Point point;

    public Rectangle(int length, int width, Point point){
        this.length = length;
        this.width = width;
        this.point = point;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public ArrayList<Point> getAllPoints(){
        ArrayList<Point> points = new ArrayList<Point>();
        for (int y = point.getY(); y >= point.getY() - width; y--){
            for (int x = point.getX(); x <= point.getX() + length; x++){
                Point temp = new Point(x, y);
                points.add(temp);
            }
        }
        return points;
    }

    public static ArrayList<Point> generateRandomRectanglePoints(){
        int randX = (int) (Math.random() * 51);
        int randY = (int) (Math.random() * 51);
        int randLen = (int) (Math.random() * 41) + 10;
        int randWidth = (int) (Math.random() * 6) + 5;
        Point newPoint = new Point(randX,randY);
        Rectangle newRect = new Rectangle(randLen, randWidth, newPoint);
        return newRect.getAllPoints();
    }

    public static Rectangle generateRandomRectangle(){
        int randX = (int) (Math.random() * 51);
        int randY = (int) (Math.random() * 51);
        int randLen = (int) (Math.random() * 41) + 10;
        int randWidth = (int) (Math.random() * 6) + 5;
        Point newPoint = new Point(randX,randY);
        return new Rectangle(randLen, randWidth, newPoint);
    }

    public ArrayList<Point> findCorners(){
        ArrayList<Point> corners = new ArrayList<Point>();
        Point topLeft = new Point(getPoint().getX(), getPoint().getY());
        Point topRight = new Point(getPoint().getX() + length, getPoint().getY());
        Point bottomLeft = new Point(getPoint().getX(), getPoint().getY() - width);
        Point bottomRight = new Point(getPoint().getX() + length, getPoint().getY() - width);

        corners.add(topLeft);
        corners.add(topRight);
        corners.add(bottomLeft);
        corners.add(bottomRight);
        return corners;
    }
}