public class Circle extends Figure implements Drawable{
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double areaCalculation() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double perimeterCalculation() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void draw() {
        System.out.println("This is a circle");
    }
}
