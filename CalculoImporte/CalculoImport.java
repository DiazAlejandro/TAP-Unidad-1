import javax.swing.*; //Importa las librerias necesarias
import java.awt.*;
import java.awt.event.*;

/**
 * Clase que calcula el importe de dos cantidades
 * 
 * @author: Alejandro Diaz Ruiz
 * @version: 12/02/2020
 */
public class CalculoImport extends JFrame{  
    private JLabel     importe;   //Declaración de un Label
    private JButton    calculo;   //Declaración de un boton
    private JTextField cantidad;  //Declaración de una caja de texto para ingresar la cantidad
    private JTextField precio;    //Declaración de una caja de texto para ingresar el precio
    
    /**
     * Constructor de la clase CalculoImport
     */
    public CalculoImport(){   
        setTitle("Calculo importe");                    //Titulo de la ventana
        setLayout(new FlowLayout());                    //Crea una nueva paleta o lienzo para mostrar sus elementos
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Finaliza la tarea al presionar cerrar ventana
        JLabel   tCantidad = new JLabel("Cantidad: ");  //Asigna el texto a un JLabel
        JLabel   tPrecio   = new JLabel("Precio: ");    //Asigna el texto a un JLabel
                 importe   = new JLabel("Importe:");    //Asigna el texto a un JLabel
                 calculo   = new JButton("Calcular");   //Asigna el texto a un JBotton
                 cantidad  = new JTextField(6);         //Crea un JTextField para reibir la cantidad
                 precio    = new JTextField(6);         //Crea un JTextField para reibirel precio
        add(tCantidad);  // Añade el Jlabel al lienzo
        add(cantidad);   // Añade el JTextField al lienzo
        add(tPrecio);    // Añade el Jlabel al lienzo
        add(precio);     // Añade el JTextField al lienzo
        add(calculo);    // Añade el JButton al lienzo
        add(importe);    // Añade el Jlabel al lienzo
        
        ActionEv actEv = new ActionEv();       //Instancia de un objeto ActionEv
        calculo.addActionListener(actEv);      //Indica quien es el administrador de nuestro evento
        cantidad.addActionListener(actEv);
        precio.addActionListener(actEv);
        setVisible(true);   //Visibilidad activada
        setSize(250,200);   //Tamaño de la ventana
    
    }    
    /**
     * Clase privada ActionEv
     */
    private class ActionEv implements ActionListener{
        @Override    
        /**
         * Método que esta dentro de la clase ActionEvent que permite saber que objeto esta generando el evento
         * @param ae ActionEvent evento generado
         */
        public void actionPerformed(ActionEvent ae) {    
            if (ae.getSource() == calculo)
                StdOut.println("Productor del evento: Calculo");
                else if (ae.getSource() == cantidad)
                     StdOut.println("Productor del evento: Cantidad");
                     else StdOut.println("Productor del evento: Precio");
                     
            try{   //Bloque del try-catch
                Double imp = Double.parseDouble(cantidad.getText())*
                             Double.parseDouble(precio.getText());    //Operación del calculo del importe.
                importe.setText(""+imp);  //Asigan el resultado al JLabel para mostrarlo en pantalla
            } catch (Exception e){  //Tipo de excepcion lanzada
                JOptionPane.showMessageDialog(null, "Error, no está introduciendo datos correctos."); //Error mostrado en pantalla
            }       //Fin del bloque Try-catch
        }
    }
    
    /**
     * Clase privada KeyEv que se implementa KeyListener para obtener los eventos generados por el teclado
     * es decir, si queremos que únicamente se habiliten teclas específicas.
     */
    private class KeyEv implements KeyListener{
        public void keyPressed(KeyEvent ke){}
        public void keyReleased(KeyEvent ke){}
        
        /**
         * Método que se encarga de saber si la tecla pulsada es o no es un digito
         */
        public void keyTyped(KeyEvent ke){
            char caracter = ke.getKeyChar();
            if (!Character.isDigit(caracter)) //Si es diferente de un digito entonces ->
                ke.consume(); //Finaliza el evento 
        }
    }
    /**
     * Método main
     */
    public static void main (String [] args){ 
        CalculoImport calc = new CalculoImport();   //Crea un objeto de la clase calculo Importe
    }
}