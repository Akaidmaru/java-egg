public class Person {
    private String name;
    private int age;

    public Person(String nombre, int edad) {
        this.name = nombre;
        this.age = edad;
    }

    public String printInfo() {
        return "Persona{" +
                "nombre='" + name + '\'' +
                ", edad=" + age +
                '}';
    }
}
