import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese su contraseña: ");
        String password = input.nextLine();
        input.close();
        boolean hasLength = password.length() >= 8;
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        if (!hasLength) {
            System.out.println("Tu contraseña debe tener al menos 8 caracteres.");
        } else {
            for (int index = 0; index < password.length(); index++) {
                if (Character.isLowerCase(password.charAt(index))) {
                    hasLower = true;
                } else if (Character.isUpperCase(password.charAt(index))) {
                    hasUpper = true;
                } else if (Character.isDigit(password.charAt(index))) {
                    hasDigit = true;
                } else if (!Character.isLetterOrDigit(password.charAt(index))) {
                    hasSpecial = true;
                }
            }
        }

        if (hasLength && hasUpper && hasLower && hasDigit && hasSpecial) {
            System.out.println("¡Contraseña segura! Cumple con todos los criterios.");
        } else {
            System.out.println("Contraseña no segura. Desbe cumplir con las siguientes condiciones: ");
            if (!hasLength) {
                System.out.println("- Debe incluir al menos 8 caracteres.");
            }
            if (!hasUpper) {
                System.out.println("- Debe incluir al menos una mayúscula.");
            }
            if (!hasLower) {
                System.out.println("- Debe incluir al menos una minúscula.");
            }
            if (!hasDigit) {
                System.out.println("- Debe incluir al menos un dígito.");
            }
            if (!hasSpecial) {
                System.out.println("- Debe incluir al menos un caracter especial.");
            }
        }


    }
}
