import java.util.Scanner;

public class LoginConsola {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // Datos correctos predefinidos (credenciales del sistema)
        String usuarioCorrecto = "Tatiana";
        String claveCorrecta = "1234";

        System.out.println("========================================");
        System.out.println("      SISTEMA DE LOG IN (CONSOLA)      ");
        System.out.println("========================================");

        // Captura de datos
        System.out.print("Ingrese su nombre de usuario: ");
        String usuarioIngresado = teclado.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String claveIngresada = teclado.nextLine();

        System.out.println("----------------------------------------");

        // EVALUACIÓN DE CREDENCIALES
        // ¡OJO! En Java para comparar texto (String) NUNCA se usa "==", se usa .equals()
        if (usuarioIngresado.equals(usuarioCorrecto) && claveIngresada.equals(claveCorrecta)) {
            System.out.println("🔒 ¡ACCESO CONCEDIDO! Bienvenido al sistema.");
        } else {
            System.out.println("❌ ¡ACCESO DENEGADO! Usuario o contraseña incorrectos.");
        }

        System.out.println("========================================");

        teclado.close();
    }
}