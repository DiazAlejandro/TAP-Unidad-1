//Importar librerias
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Clase que muestra dentro de un JFrame nueve botones.
 * Al presionar cada botón muestra un valor diferente en un JLabel.
 * 
 * @author: Alejandro Diaz Ruiz
 * @version: 10/02/2020
 */

public class CajaDeBotones extends JFrame implements ActionListener{
    private JLabel txt; //Objeto de tipo JLabel que almacenará el valor del botón seleccionado.
    private JButton c1,c2,c3,c4,c5,c6,c7,c8,c9; //Objetos de tipo JButton (Botones)
    
    /**
     * Constructor para mostrar los botones dentro de un JFrame
     */
    public CajaDeBotones(){
        setTitle("Botones");                            //Titulo del JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cierra la ventana pero mantiene la ejecución
        c1 = new JButton("Boton 1");                    //Instancía nueve nuevos botones.
        c2 = new JButton("Boton 2");
        c3 = new JButton("Boton 3");
        c4 = new JButton("Boton 4");
        c5 = new JButton("Boton 5");
        c6 = new JButton("Boton 6");
        c7 = new JButton("Boton 7");
        c8 = new JButton("Boton 8");
        c9 = new JButton("Boton 9");
        txt = new JLabel();                             //Instancia un JLabel
        add(c1); add(c2); add(c3);                      //Añade al JFrame principal cada uno de los objetos
        add(c4); add(c5); add(c6);                      //Se añaden del botón 1 al botón 9 dejando al final
        add(c7); add(c8); add(c9);                      //el JLabel
        add(txt);
        
        //A cada botón se le agrega el método ActionListener para saber que botón está generando el evento
        c1.addActionListener(this);
        c2.addActionListener(this);
        c3.addActionListener(this);
        c4.addActionListener(this);
        c5.addActionListener(this);
        c6.addActionListener(this);
        c7.addActionListener(this);
        c8.addActionListener(this);
        c9.addActionListener(this);
        
       
        setVisible(true);               //Activa la visibilidad del JFrame
        setLayout(new GridLayout(4,3)); //Establece un nuevo tipo de distribución (4 filas por 3 columnas)
        setSize(300,300);               //Tamaño del JFrame
    }
    
    /**
     * Método que hereda de ActionListener, mediante el cual permite saber que botón a sido clickeado
     * @param ae Acción que recibirá cuando un botón sea clickeado. 
     * @Override
     */
    
    public void actionPerformed(ActionEvent ae) {
        //Con getSource() identifica que objeto a generado el evento y si se cumple, asigna el valor
        //del botón en el JLabel mediante setText()
        if(ae.getSource() == c1) txt.setText("Boton 1"); 
            else if(ae.getSource() == c2) txt.setText("Boton 2");
                else if(ae.getSource() == c3) txt.setText("Boton 3");
                    else if(ae.getSource() == c4) txt.setText("Boton 4");
                        else if(ae.getSource() == c5) txt.setText("Boton 5");
                            else if(ae.getSource() == c6) txt.setText("Boton 6");
                                else if(ae.getSource() == c7) txt.setText("Boton 7");
                                    else if(ae.getSource() == c8) txt.setText("Boton 8");
                                        else if(ae.getSource() == c9) txt.setText("Boton 9");
    }
    
    /**
     * Método principal.
     */
    public static void main (String [] args){
        //Crea e instancia un nuevo objeto de esta misma clase.
        CajaDeBotones c1 = new CajaDeBotones();
    }
}