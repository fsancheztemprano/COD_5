package b10;

/**
 *
 * @author emendezduran
 */
public class PROG_Boletin_10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Metodos.instrucciones();
        do {
            Metodos.jugar();
        } while (Metodos.reiniciar());

        System.exit(0);
        
        //COMENTARIO PARA EJERCICIO DE COD PARA APRENDER A HACER UN FETCH Y MERGE
    }
}
    

