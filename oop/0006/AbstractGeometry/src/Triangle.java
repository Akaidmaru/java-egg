public class Triangle extends Figure implements Drawable{
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle() {
    }

    public Triangle(double sideA) {
        /*This is used to calculate an Equilateral triangle,
            since all of its sides are equal
            */
        this.sideA = sideA;
        this.sideB = sideA;
        this.sideC = sideA;
    }

    public Triangle(double sideA, double sideB) {
        /*This is used to calculate an Isosceles triangle,
            since two sides are equal but one is different.
            */
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideB;
    }

    public Triangle(double sideA, double sideB, double sideC) {
        /* This is used to calculate a Scalene triangle,
            since all of its sides are different.
            */
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

    private boolean isValidTriangle() {
        return (sideA > 0 && sideB > 0 && sideC > 0) &&
                (sideA + sideB > sideC) &&
                (sideA + sideC > sideB) &&
                (sideB + sideC > sideA);
    }


    @Override
    public double areaCalculation() {
        /*This uses Heron´s formula to calculate any triangle knowing their sizes,
            this works awesome thanks to constructors.
            */
        if (!isValidTriangle()){
            System.out.println("The sides don´t form a valid triangle.");
            return 0;
        }
        double semiPerimeter = perimeterCalculation() / 2;
        return Math.sqrt(semiPerimeter*(semiPerimeter-sideA)*(semiPerimeter-sideB)*(semiPerimeter-sideC));
    }

    @Override
    public double perimeterCalculation() {
        if (!isValidTriangle()){
            System.out.println("The sides don´t form a valid triangle.");
            return 0;
        }
        return sideA + sideB + sideC;
    }

    @Override
    public void draw() {
        System.out.println("This is a triangle");
        }
}

