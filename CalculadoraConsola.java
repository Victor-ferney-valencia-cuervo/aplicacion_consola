import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraConsola {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double numero1 = leerNumero(scanner, "Ingrese el primer número: ");
        double numero2 = leerNumero(scanner, "Ingrese el segundo número: ");
        char operacion = leerOperacion(scanner);

        try {
            double resultado = calcular(numero1, numero2, operacion);
            mostrarResultado(resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }

    public static double leerNumero(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número real.");
                scanner.nextLine();
            }
        }
    }

    public static char leerOperacion(Scanner scanner) {
        while (true) {
            System.out.print("Seleccione una operación (+, -, *, /): ");
            String entrada = scanner.next();
            if (entrada.length() == 1) {
                char op = entrada.charAt(0);
                if (op == '+' || op == '-' || op == '*' || op == '/') {
                    return op;
                }
            }
            System.out.println("Operación no válida.");
        }
    }

    public static double calcular(double a, double b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) throw new ArithmeticException("División por cero.");
                return a / b;
            default: throw new IllegalArgumentException("Operación no válida.");
        }
    }

    public static void mostrarResultado(double resultado) {
        System.out.printf("Resultado: %.2f%n", resultado);
    }
}

