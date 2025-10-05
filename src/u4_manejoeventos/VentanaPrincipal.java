package u4_manejoeventos;

//Bibliotecas importadas
import javax.swing.*;   //Importa todas las clases de la librería Swing como JFrame, JButton, JList, JPanel, etc.
import java.awt.*;      //Para las clases del paquete AWT, necesarias para manejar layouts, colores, gráficos, etc.

/**
 *Esta clase es la ventana principal o la vista de la interfaz gráfica
 */
public class VentanaPrincipal extends JFrame {

    private JList<String> itemList;             //Lista visual que muestra elementos de texto en la interfaz
    private DefaultListModel<String> listModel; //Modelo que almacena los datos o elementos de la lista
    private JButton actionButton;               //botón gráfico que se mostrará en la parte inferior

    public VentanaPrincipal() {
        //Aquí va la configuración de la Ventana 
        //El título que se muestra en la barra superior de la ventana
        setTitle("Ejercicio: Captura de Tecla 'C' (POO - UEA)");  
        
        //indica que al cerrar la ventana se termine el programa completamente
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
       //Tamaño de la ventana 
        setSize(450, 450);  
        
       //para centrar la ventana en la pantalla al abrirla
        setLocationRelativeTo(null);  
        
        //Componentes de JList y JButton
        listModel = new DefaultListModel<>();  
        //crea el modelo de datos que contendrá los elementos de la lista

        //agregamos tres elementos de texto al modelo, los datos que se mostrarán en pantalla
        listModel.addElement("1. Elemento Lista");
        listModel.addElement("2. Elemento Lista");
        listModel.addElement("3. Elemento Lista");

        //Componente gráfico JList y lo vincula con el modelo anterior
        itemList = new JList<>(listModel);  

        //Configuramos la lista para permitir seleccionar múltiples elementos
        itemList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); 
        
        //Botón con el texto visible “Botón Requerido (JButton)”.
        actionButton = new JButton("Botón Requerido (JButton)");  

        //Acción que se ejecuta al hacer clic en el botón 
        actionButton.addActionListener(e -> {
            //ejemplo para imprimir mensaje y seleccionar/desseleccionar el primer elemento de la lista
            System.out.println(">>> Botón presionado <<<");

            DefaultListModel<String> model = (DefaultListModel<String>) itemList.getModel();
            if (!model.isEmpty()) {
                if (itemList.getSelectedIndex() == 0) {
                    itemList.clearSelection();
                    System.out.println("Primer elemento deseleccionado desde el botón.");
                } else {
                    itemList.setSelectedIndex(0);
                    System.out.println("Primer elemento seleccionado desde el botón.");
                }
            }
        });
        
        // Panel principal con un diseño BorderLayout y márgenes de 10 píxeles entre componentes
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));  
        
        //Borde vacío de 10 píxeles en cada lado, para dar espacio interno
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  
        
        //Lista dentro de un JScrollPane para que tenga barra de desplazamiento
        mainPanel.add(new JScrollPane(itemList), BorderLayout.CENTER);  
        
        //Botón en la parte inferior del panel
        mainPanel.add(actionButton, BorderLayout.SOUTH);  
        
        //Panel principal, el contenido visible de la ventana JFrame
        setContentPane(mainPanel);  
        
        //Registro del Listener para detectar la tecla C
        ManejadorTeclaC listener = new ManejadorTeclaC(itemList);  
        //Crea el objeto que escuchará los eventos de teclado.
        //Se le pasa la lista como parámetro, para que el listener pueda modificarla al detectar la tecla C

        itemList.addKeyListener(listener);  
        //Registramos el listener sobre la lista directamente
        //Así la tecla C se captura correctamente cuando la lista tiene foco

        itemList.setFocusable(true);  
        //permite que la lista pueda recibir el foco del teclado

        itemList.requestFocusInWindow();  
        //solicita el foco de teclado inmediatamente al abrir la ventana

        //Hace visible la ventana y todos sus componentes
        setVisible(true);  
    }
}