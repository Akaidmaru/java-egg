public class Car {
    private String make;
    private String model;
    private int year;

    public Car() {
    }

    public Car(String make) {
        this.make = make;
    }

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void printInfo() {
        String info = "";
        info += this.make == null ? "" : this.make;
        info += this.model == null ? "" :", " +  this.model;
        info += this.year > 0 ? ", " + String.valueOf(this.year) : "";

        System.out.println(info);
    }
}
