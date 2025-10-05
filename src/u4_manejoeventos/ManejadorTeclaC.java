//Paquete
package u4_manejoeventos;

// Bibliotecas importadas
import java.awt.event.KeyEvent;     //permite detectar qué tecla fue presionada
import java.awt.event.KeyListener;  //para escuchar eventos del teclado como presionar, soltar, etc.
import javax.swing.JList;           //representa una lista gráfica en la interfaz
import javax.swing.DefaultListModel; //el modelo que contiene los datos de la lista

//La clase que escucha el teclado y reacciona cuando se presiona la tecla C
public class ManejadorTeclaC implements KeyListener {
    
    //Atributo que guarda la lista sobre la que se realizará la acción
    private final JList<String> lista; 

    //el constructor que recibe la lista desde otra clase para modificarla aquí
    public ManejadorTeclaC(JList<String> lista) {
        this.lista = lista; //aqui se asigna la lista recibida al atributo 
    }

    //Método de keyPressed
    @Override
    //se ejecuta cuando el usuario presiona una tecla
    public void keyPressed(KeyEvent e) {
        //verifica si la tecla presionada es la C
        if (e.getKeyCode() == KeyEvent.VK_C) {
            //aqui se llama al método que hace la acción
            ejecutarAccionC(); 
        }
    }

    //Algunos métodos obligados no usados 
    @Override
    //se ejecuta al escribir un carácter
    public void keyTyped(KeyEvent e) { /* No se usa */ } 
    
    @Override
    //ejecuta al soltar una tecla
    public void keyReleased(KeyEvent e) { /* No se usa */ } 

    //Método privado que realiza la acción cuando se presiona la tecla C
    private void ejecutarAccionC() {
        //Aquí se muestra mensajes en consola
        System.out.println("\n--- EVENTO DE TECLADO CAPTURADO ---");
        System.out.println(">>> Tecla 'C' detectada <<<");
        
        //obtiene el modelo de datos de la lista, es decir, los elementos que contiene
        DefaultListModel<String> model = (DefaultListModel<String>) lista.getModel();
        
        //si la lista tiene elementos, se alternará la selección
        if (!model.isEmpty()) {
            int index = 0; // <-- índice del elemento que quieres alternar (0 = primero, 1 = segundo, etc.)
            
            //Para alternar la selección del elemento
            if (lista.isSelectedIndex(index)) {
                //si estaba seleccionado, se deselecciona
                lista.removeSelectionInterval(index, index); 
                System.out.println("Elemento en posición " + (index+1) + " deseleccionado.");
            } else {
                //si no estaba seleccionado, se selecciona y no se quitan otras selecciones
                lista.addSelectionInterval(index, index); 
                System.out.println("Elemento en posición " + (index+1) + " seleccionado.");
            }
        }
    }
}