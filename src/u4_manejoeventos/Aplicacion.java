//Paquete
package u4_manejoeventos;

//Biblioteca importada
import javax.swing.SwingUtilities; //para ejecutar código relacionado con la interfaz gráfica

/** Clase de inicio, la clase Main que inicia la ventana principal.
 */
public class Aplicacion {
    
    //Ejecución de la interfaz gráfica 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaPrincipal());
        // Usamos una expresión lambda para crear una nueva instancia de VentanaPrincipal,
        // lo que abre la ventana principal del programa al iniciar la aplicación.
    }
}