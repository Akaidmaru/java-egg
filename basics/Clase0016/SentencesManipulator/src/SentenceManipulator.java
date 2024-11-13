import java.util.Arrays;
import java.util.Scanner;

public class SentenceManipulator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String sentence = "";
        int userOption;
        do {
            System.out.println("""
                    ***** Menú de opciones *****
                    1) Crear oración o Borrar oración
                    2) Cantidad de caracteres de la oración
                    3) Cantidad de palabras de la oración
                    4) Mostrar palabras ordenadas alfabéticamente
                    5) Ingresar un número y devolver la palabra correspondiente
                    6) Buscar palabra dentro de la oración
                    7) Modificar palabra dentro de la oración
                    8) Agregar contenido a la oración
                    9) Salir
                    """);
            userOption = input.nextInt();
            input.nextLine();

            switch (userOption) {
                case 1 -> {
                    if (sentence.isBlank() || sentence.isEmpty()) {
                        System.out.println("Crear oración");
                        sentence = input.nextLine();
                    } else {
                        System.out.println("Borrar oración");
                    }
                }
                case 2 -> {
                    int sentenceLength = sentence.length();
                    System.out.println("La cantidad de caracteres es: " + sentenceLength);
                }
                case 3 -> {
                    String[] words = sentence.split(" ");
                    System.out.println("La cantidad de palabras es " + words.length);
                }
                case 4 -> {
                    String[] words = sentence.split(" ");
                    Arrays.sort(words);
                    System.out.println("Las palabras en orden alfabético: ");
                    System.out.println(Arrays.toString(words));
                }
                case 5 -> {
                    String[] words = sentence.split(" ");
                    System.out.println("Ingresa un número para obtener la palabra correspondiente: ");
                    userOption = input.nextInt();
                    if (userOption > words.length) {
                        System.out.println("Número inválido. Intente nuevamente");
                    } else {
                        System.out.println("La palabra en la posición " + userOption + " es: " + words[userOption]);
                    }
                }
                case 6 -> {
                    boolean hasWord = false;
                    String[] words = sentence.split(" ");
                    System.out.println("Ingresa una palabra para verificar si existe en la oración: ");
                    String userWord = input.nextLine();
                    int location = 0;

                    for (int i = 0; i < words.length; i++) { // Cambiar por foreach
                        if (words[i].equalsIgnoreCase(userWord)) {
                            hasWord = true;
                            location = i;
                        }
                    }
                    if (hasWord) {
                        System.out.println("La palabra " + userWord + " se encuentra en la posición: " + ((int) location + 1));
                    } else {
                        System.out.println("La plabra " + userWord + " no se encuentra en la oración.");
                    }
                }
                case 7 -> {
                    boolean hasWord = false;
                    String[] words = sentence.split(" ");
                    System.out.println("Ingresa una palabra para verificar si existe en la oración: ");
                    String userWord = input.nextLine();
                    int location = 0;
                    for (int i = 0; i < words.length; i++) { // Cambiar por foreach
                        if (words[i].equalsIgnoreCase(userWord)) {
                            hasWord = true;
                            location = i;
                        }
                    }
                    if (hasWord) {
                        System.out.println("La palabra " + userWord + " se encuentra en la posición: " + location + 1);
                        System.out.println("¿Con cuál palabra te gustaría reemplazarla?");
                        userWord = input.nextLine();
                        boolean hasDigit = false;
                        for (int i = 0; i < userWord.length(); i++) {
                            if (Character.isDigit(userWord.charAt(i))) {
                                hasDigit = true;
                            }
                        }
                        if (hasDigit) {
                            System.out.println("La palabra no puede ser usada ya que tiene números.");
                        } else {
                            words[location] = userWord;
                            System.out.println("La palabra ha sido modificada.");
                        }
                        sentence = String.join(" ", words);
                        System.out.println("La nueva oración es: " + sentence);
                    } else {
                        System.out.println("La palabra " + userWord + " no se encuentra en la oración.");
                    }
                }
                case 8 -> {
                    System.out.println("Ingresa un contenido para agregar al final de la oración: ");
                    sentence += input.nextLine();
                    System.out.println("La nueva oración es: ");
                    System.out.println(sentence);
                }
            }
        } while (userOption != 9);
    }
}
