public class Rectangulo {

    private static int contadorRectangulos = 0;
    private double ancho;
    private double alto;

    public Rectangulo(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
        contadorRectangulos++;
    }

    public Rectangulo() {
        this(0, 0);
    }

    private double area() {
        return (this.alto * this.ancho);
    }

    private double perimetro() {
        return (2 * (this.alto + this.ancho));
    }

    public void imprimirArea() {
        System.out.println(this.area());
    }

    public void imprimirPerimetro() {
        System.out.println(this.perimetro());
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public static int numeroRectangulos() {
        return contadorRectangulos;
    }

}
