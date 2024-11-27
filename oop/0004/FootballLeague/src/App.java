public class App {
    public static void main(String[] args) throws Exception {
// Utilities.limpiarPantalla();
        Jugador[] players = new Jugador[10];
        Equipo[] teams = new Equipo[10];

        int LastPlayer = 0;
        int LastTeam = 0;
        int option = 0;
        do {

            System.out.println("""
                    LIGA DE FUTBOL:
                    1- CREAR JUGADOR
                    2- CREAR EQUIPO
                    3- ASIGNAR JUGADOR A EQUIPO
                    4- MOSTRAR LISTA DE JUGADORES
                    5- MOSTRAR LISTA DE EQUIPOS
                    6- SALIR
                    """);

            Scanner lee = new Scanner(System.in);
            System.out.println("Ingrese opcion: ");
            try {

                option = lee.nextInt();
// Utilities.limpiarPantalla();

            } catch (Exception e) {
// Utilities.limpiarPantalla();
                System.out.println("Dato invalido");
            }
            switch (option) {
                case 1:
                    LastPlayer = crearJugadores(players, teams, LastPlayer);
                case 2:
                    LastTeam = crearEquipos(teams, LastTeam);
                    break;
                case 5:
                    mostrarEquipos(teams);
                    break;

                default:
                    break;
            }
        } while (option != 6);

    }
}