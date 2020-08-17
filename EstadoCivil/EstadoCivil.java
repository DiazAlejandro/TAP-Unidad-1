import javax.swing.*; //Importa las librerias necesarias
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Clase que muestra la ejecución e implementación de un JButtonGroup mediante estados civiles
 * 
 * @author: Alejandro Diaz Ruiz
 * @version: 17/02/2020
 */

public class EstadoCivil extends JFrame {
    //Declaración de los componentes (JRadioButton)
    private JRadioButton est1;
    private JRadioButton est2;
    private JRadioButton est3;
    //Declaración del los labels que aparecerán 
    private JLabel txt1;
    private JLabel votado;
    //Declaración e instanciación de ub BottonGroup
    private final ButtonGroup grupo = new ButtonGroup();

    /**
     * Constructor de la clase EstadoCivil
     */
    public EstadoCivil () {
        super("Estados Civiles");                           //Titulo del JFrame
        JPanel estados = new JPanel();                      //Nueva instancia del JPanel
        estados.setLayout(new GridLayout(5,1));             //Establece un nueto tipo de distribución 5 filas por 1 columna
        //Inicializa cada uno de los componentes
        txt1 = new JLabel("Seleccione su estado civil");    //Texto del JLable
        est1 = new JRadioButton("Soltero");                 //Texto del primer JRadioButton
        est1.setBackground(Color.yellow);                   //Agrega un color de fondo al JRadioButton
        est2 = new JRadioButton("Casado");                  //Texto del segundo JRadioButton
        est2.setBackground(Color.ORANGE);                   //Agrega un color de fondo al JRadioButton
        est3 = new JRadioButton("Unión Libre");             //Texto del tercer JRadioButton
        est3.setBackground(Color.red);                      //Agrega un color de fondo al JRadioButton
        votado = new JLabel("");                            //Inicializa el label que mostrará el RadioButton seleccionado
        
        ItemListener li = new VoteItemListener();           //Nueva instancia de la clase privada (Linea 63)
        est1.addItemListener(li);                           //Agrega un listener a cada JRadioButton
        est2.addItemListener(li);
        est3.addItemListener(li);
        //Agrega al BottonGroup cada JRadioButton para que solamente uno de los tres sean seleccionables y no dos o los tres
        grupo.add(est1);
        grupo.add(est2);
        grupo.add(est3);
        //Agrega al panel cada uno de los componentes.
        estados.add(txt1);
        estados.add(est1);
        estados.add(est2);
        estados.add(est3);
        estados.add(votado);
        //Agrega al JFrame principal el panel en la posición norte 
        add(estados,BorderLayout.NORTH);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     //Cerrar ventana    
        setVisible(true);                                   //Visibilidad activada
        setSize(350,180);                                   //Tamaño de la ventana
    }
    
    //Clase privada para recuperar el JRadioButon que haya sido seleccionado
    private class VoteItemListener implements ItemListener{
        /**
         * Método que recupera el JRadioButton seleccionado y lo muestra en un label
         * @param e RadioButton seleccioando 
         */
        public void itemStateChanged(ItemEvent e){
            JRadioButton boton = (JRadioButton) e.getItemSelectable();
            votado.setText("\tEstado Civil: "+boton.getActionCommand());
        }
    }
    
    public static void main(String [] args){
        EstadoCivil c1 = new EstadoCivil();
    }
}