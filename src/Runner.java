import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        Point startPoint = new Point(10, 15);
        Rectangle originalRect = new Rectangle(20, 10, startPoint);
        ArrayList<Point> origPoints = originalRect.getAllPoints();
        int counter1 = 0;
        int counter2 = 0;

        for (int i = 0; i < 50; i++){
            ArrayList<Point> newPoints = Rectangle.generateRandomRectanglePoints();
            boolean shouldBreak = false;
            for (Point point : origPoints){
                for (Point newpoint : newPoints){
                    if (point.toString().equals(newpoint.toString())){
                        counter1++;
                        shouldBreak = true;
                        break;
                    }
                }
                if (shouldBreak){
                    break;
                }
            }
        }
        System.out.println(counter1);

        for (int i = 0; i < 10000000; i++){
            Rectangle newRect = Rectangle.generateRandomRectangle();
            ArrayList<Point> corners = newRect.findCorners();
            boolean shouldBreak = false;
            for (Point corner : corners){
                if (corner.getX() >= originalRect.getPoint().getX() && corner.getX() <= originalRect.getPoint().getX() + originalRect.getLength()){
                    if (corner.getY() <= originalRect.getPoint().getY() && corner.getY() >= originalRect.getPoint().getY() - originalRect.getWidth()){
                        counter2++;
                        shouldBreak = true;
                        break;
                    }
                }
            }
            if (!shouldBreak){
                if (corners.get(0).getX() >= originalRect.getPoint().getX() && corners.get(1).getX() <= originalRect.getPoint().getX() + originalRect.getLength()){
                    if (corners.get(0).getY() >= originalRect.getPoint().getY() && corners.get(2).getY() <= originalRect.getPoint().getY() - originalRect.getWidth()){
                        counter2++;
                    }
                } else if (corners.get(0).getY() <= originalRect.getPoint().getY() && corners.get(2).getY() >= originalRect.getPoint().getY() - originalRect.getWidth()){
                    counter2++;
                }
            }
        }

        double percentTemp = (double) counter2 / 10000000;
        int percent = (int) (percentTemp * 1000 + 0.5);
        System.out.println(percent / 10.0 + "%");
    }
}