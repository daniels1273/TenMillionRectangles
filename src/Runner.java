import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        Point startPoint = new Point(10, 15);
        Rectangle originalRect = new Rectangle(20, 10, startPoint);
        ArrayList<Point> origPoints = originalRect.getAllPoints();
        int counter = 0;

        for (int i = 0; i < 50; i++){
            ArrayList<Point> newPoints = Rectangle.generateRandomRectanglePoints();
            boolean shouldBreak = false;
            for (Point point : origPoints){
                for (Point newpoint : newPoints){
                    if (point.toString().equals(newpoint.toString())){
                        counter++;
                        shouldBreak = true;
                        break;
                    }
                }
                if (shouldBreak){
                    break;
                }
            }
        }
        System.out.println(counter);

    }
}