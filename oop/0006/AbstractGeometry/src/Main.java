public class Main {
    public static void main(String[] args) {
        Triangle triangle1 = new Triangle(3);
        Triangle triangle2 = new Triangle(3, 2);
        Triangle triangle3 = new Triangle(4,2, 3);

        // 1st Triangle
        System.out.println("Area of 1st Triangle: " + triangle1.areaCalculation());
        System.out.println("Perimeter of 1st Triangle: " + triangle1.perimeterCalculation());

        // 2nd Triangle
        System.out.println("Area of 2nd Triangle: " + triangle2.areaCalculation());
        System.out.println("Perimeter of 2nd Triangle: " + triangle2.perimeterCalculation());

        // 3rd Triangle
        System.out.println("Area of 3rd Triangle: " + triangle3.areaCalculation());
        System.out.println("Perimeter of 3rd Triangle: " + triangle3.perimeterCalculation());
    }
}
