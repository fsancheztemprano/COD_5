package prog_boletin_10;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author emendezduran
 */
public class Metodos {

    public static void instrucciones() {
        JOptionPane.showConfirmDialog(null, "Juego de Adivinar: \nEl Jugador 2 establece un numero del 1 al 50 y el numero de intentos permitidos \nEl jugador 1 debera intentar adivinar el numero secreto \nLa unica pista sera si el numero introducido es mayor o menor al numero secreto.", "Adivina el Numero", JOptionPane.DEFAULT_OPTION);
    }

    public static int introCod(String error, String jugador, String mensaje) {
        return Integer.parseInt(JOptionPane.showInputDialog(null, error + "\n" + jugador + "\n" + mensaje, "Adivina el Numero", 3));
    }

    public static int validarCod(String jugador, String mensaje) {
        int i = 0;
        String error = "";
        do {
            i = introCod(error, jugador, mensaje);
            error = "Error, Introduce un Numero Valido\n";
        } while (i < 1 || i > 50);
        return i;
    }

    public static void hint(String str) {
        JOptionPane.showConfirmDialog(null, str, "Adivina el Numero", JOptionPane.DEFAULT_OPTION);

    }

    public static void jugar() {
        int codigo, adivinanza = 0, Intentos;
        if (!eligeOponente()) {
            codigo = validarCod("Jugador 2", "Introduce un numero secreto entre 1 y 50");
            Intentos = validarCod("Jugador 2", "Numero de intentos maximos");
        } else {
            Random rand = new Random();
            codigo = rand.nextInt(49) + 1;
            Intentos = 10;
        }
        do {
            adivinanza = validarCod("Jugador 1", "Introduce un numero secreto entre 1 y 50");
            if (adivinanza > codigo) {
                hint("Tu numero (" + adivinanza + ") es mayor que el numero secreto\n" + diferencia(adivinanza, codigo) + "\nIntentos restantes: " + Intentos);
            } else if (adivinanza < codigo) {
                hint("Tu numero (" + adivinanza + ") es menor que el numero secreto\n" + diferencia(adivinanza, codigo) + "\nIntentos restantes: " + Intentos);
            } else {
                break;
            }
            Intentos--;
        } while (adivinanza != codigo && Intentos != 0);
        if (codigo == adivinanza) {
            hint("Jugador 1 ha ganado!\nHa acertado el numero secreto");
        } else {
            hint("Jugador 2 ha ganado!\nJugador 1 no encontro el numero secreto.");
        }

    }

    public static boolean reiniciar() {
        String[] options = {"SI", "NO"};
        int newg = JOptionPane.showOptionDialog(null, "Nuevo Juego?", "Adivina el Numero", 0, 3, null, options, 0);
        switch (newg) {
            case 0:
                return true;
            default:
                return false;
        }

    }

    public static boolean eligeOponente() {
        String[] options = {"AI", "Humano"};

        int newg = JOptionPane.showOptionDialog(null, "Elije Oponente?", "Adivina el Numero", 0, 3, null, options, 0);
        switch (newg) {
            case 0:
                return true;
            default:
                return false;
        }
    }

    public static String diferencia(int i, int j) {
        int k = Math.abs(i - j);
        if (k > 20) {
            return "moi lonxe";
        } else if (k <= 20 && k >= 10) {
            return "lonxe";
        } else if (k < 10 && k > 5) {
            return "preto";
        } else if (k <= 5 && k > 0) {
            return "moi preto";
        } else {
            return "";
        }

    }

}
