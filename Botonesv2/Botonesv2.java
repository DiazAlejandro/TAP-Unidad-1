//Importar librerías
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

/**
 * Clase que muestra dentro de un JFrame nueve botones.
 * Al presionar cada botón muestra un color diferente 
 * en los JLabel correspondientes, así como el fondo de cada botón
 * 
 * @author: Alejandro Diaz Ruiz
 * @version: 11/02/2020
 */

public class Botonesv2 extends JFrame implements MouseListener{
    private JButton bts[];              //Arreglo de botones
    private JLabel boton, texto;        //JLabel que mostrarán el texto y color.
    Container lienzo;                   //Contenedor que almacenará los objetos (JLabel y JButton)
    
    /**
     * Constructor de la clase Botonesv2
     */
    public Botonesv2(){
        super("Eventos botones");
        bts   = new JButton[9];                         //Arreglo de botones
        boton = new JLabel("Boton pulsado");            //JLabel inferior
        texto = new JLabel("Botones pulsado");          //JLabel superior
        JPanel botones = new JPanel();                  //JPanel que almacenará los objetos de tipo botones
        botones.setLayout(new GridLayout(3,3));         //Asigna un Layout con propiedad GridLayout de 3 filas por tres columnas 
        lienzo = this.getContentPane();                 //Obtiene el entorno donde se encuentra
        lienzo.setBackground(Color.YELLOW);     //Agrega la propiedad de color de fondo al contenedor principal
        setTitle("Botones");                //Agrega un titulo al JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cierra la ventana pero mantiene la ejecución

        for(int i = 0; i < bts.length ; i++){       //Ciclo que se encarga de recorrer el arreglo de botones                
            bts[i] = new JButton("Boton "+(i+1));   //Instancia los nuevos botones, agregando el nombre del botón.
            botones.add(bts[i]);            //Añade los botones al panel
            bts[i].addMouseListener(this);      //Agrega el listener a cada botón
        }
        
        add(texto,  BorderLayout.NORTH);        //Añade el texto superior al JFrame
        add(botones,BorderLayout.CENTER);       //Añade el JPanel que contiene los botones
        add(boton,  BorderLayout.SOUTH);        //Añade el texto inferior al JFrame
        
        setVisible(true);               //Activa la visibilidad del JFrame
        setSize(300,300);               //Tamaño de la ventana
    }

    //Métodos que se implementan de la interface MouseListener
    public void mouseExited(MouseEvent ev){}
    public void mouseEntered(MouseEvent ev){}
    public void mousePressed(MouseEvent ev){}
    public void mouseReleased(MouseEvent ev){}

    /**
     * Método que se ejecuta cuando se realiza un evento dentro del botón haciendo click.
     * La estructura que sigue es: 
     * Mediante una condición if, derermina si es el botón que genera el evento, 
     * si lo es, asigna el color de fondo al lienzo, así como el fondo del color.
     * En el texto inferior mustra el numero del botón que ha sido pulsado.
     */
    public void mouseClicked(MouseEvent ev){
        if (bts[0] == ev.getSource()){
            bts[0].setBackground(Color.BLUE);
            lienzo.setBackground(Color.BLUE);
            boton.setText("Botón 1 presionado");
            } else {
                if (bts[1] == ev.getSource()){
                    bts[1].setBackground(Color.CYAN);
                    lienzo.setBackground(Color.CYAN);
                    boton.setText("Botón 2 presionado");
                } else {
                    if (bts[2] == ev.getSource()){
                        bts[2].setBackground(Color.GRAY);
                        lienzo.setBackground(Color.GRAY);
                        boton.setText("Botón 3 presionado");
                    } else {
                        if (bts[3] == ev.getSource()){
                            bts[3].setBackground(Color.GREEN);
                            lienzo.setBackground(Color.GREEN);
                            boton.setText("Botón 4 presionado");
                            } else {
                                if (bts[4] == ev.getSource()){
                                    bts[4].setBackground(Color.MAGENTA);
                                    lienzo.setBackground(Color.MAGENTA);
                                    boton.setText("Botón 5 presionado");
                                } else {
                                    if (bts[5] == ev.getSource()){
                                        bts[5].setBackground(Color.ORANGE);
                                        lienzo.setBackground(Color.ORANGE);
                                        boton.setText("Botón 6 presionado");
                                    } else {
                                        if (bts[6] == ev.getSource()){
                                            bts[6].setBackground(Color.PINK);
                                            lienzo.setBackground(Color.PINK);
                                            boton.setText("Botón 7 presionado");
                                        } else {
                                            if (bts[7] == ev.getSource()){
                                                bts[7].setBackground(Color.RED);
                                                lienzo.setBackground(Color.RED);
                                                boton.setText("Botón 8 presionado");
                                            } else {
                                                if (bts[8] == ev.getSource()){
                                                    bts[8].setBackground(Color.WHITE);
                                                    lienzo.setBackground(Color.WHITE);
                                                    boton.setText("Botón 9 presionado");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
    }
    
    /**
     * Método principal 
     */
    public static void main (String [] args){
        Botonesv2 c1 = new Botonesv2();  //Instancia un nuevo objeto de esta misma clase
    }
}