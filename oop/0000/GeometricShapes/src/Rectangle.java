public class Rectangle {
    private double width;
    private double height;
    private static int rectangleCounter = 0;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
        rectangleCounter++;
    }


    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public static int getRectangleCounter() {
        return rectangleCounter;
    }

    private double area(){
        return width * height;
    }

    private double perimeter(){
        return 2 * (width + height);
    }

    public void printArea(){
        System.out.println(this.area());
    }

    public void printPerimeter(){
        System.out.println(this.perimeter());
    }

}
