public class Rectangle extends Figure implements Drawable{
    private double base;
    private double height;

    public Rectangle() {
    }

    public Rectangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double areaCalculation() {
        return base * height;
    }

    @Override
    public double perimeterCalculation() {
        return 2 * base + 2 * height;
    }

    @Override
    public void draw() {
        System.out.println("This is a rectangle");
    }
}
