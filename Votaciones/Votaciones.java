import javax.swing.*;    //Importación de las librerias
import java.awt.*;       //Importación de las librerias
import java.awt.event.*; //Importación de las librerias
import java.awt.Color;   //Importación de las librerias

/**
 * Clase que registra la cantidad de votos según las veces que presionemos un botón
 * 
 * @author: Alejandro Diaz Ruiz
 * @version: 13/02/2020
 */
public class Votaciones extends JFrame{             //Clase Votaciones
    private JButton    planilla[];                  //Arreglo de botones
    private JLabel     resultados[];                //Arreglo de JLabels para imprimir resultados
    private int        cantidad[]  = {1,1,1,1,1,1}; //Arreglo de la cantodad de botos a almacenar según el botón presionado
    private Color      color[]   = {Color.BLUE,Color.GRAY,Color.GREEN,  //Arreglo de los colores.
                                 Color.MAGENTA,Color.RED,Color.YELLOW}; 
    private String     colores[] = {"Azul", "Gris", "Verde", "Rosa", "Rojo","Amarillo"};  //Arreglo de String con el nombre de los colores de acuerdo al boton.
    private JTextField votante;                     //Caja para ingresar el nombre del votante
    private JLabel nombre;                          //Nombre del votante en un label
    
    public Votaciones() {                               //Constructor de la clase Votaciones
        setTitle("Votaciones");                         //Asigna el titulo a la ventana
        planilla               = new JButton[6];        //Crea el arreglo de los botones
        resultados             = new JLabel[6];         //Crea el arreglo de los resuldados
        JPanel opciones        = new JPanel();          //Crea un contenedor "JPanel" para los botones
        JPanel encabezado      = new JPanel();          //Crea un contenedor "JPanel" para el nombre
        JPanel pie             = new JPanel();          //Crea un contenedor "JPanel" para los labels de los resuldatos
        votante                = new JTextField(10);    //Crea el campo para ingresar el nombre
        nombre                 = new JLabel("Nombre: ");//Imprime en un label con "Nombre"
        AdmEveAction admAccion = new AdmEveAction();    //Crea un objeto de la clase AdmEveAction 
        
        
        opciones.setLayout(new GridLayout(2,3));        //Asigna al Panel, la cantidad de filas y columnas para mostrar los botones
        pie.setLayout(new GridLayout(3,2));             //Asigna al Panel, la cantidad de filas y columnas para mostrar los labels
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Finaliza la ejecución del programa al cerrar la ventana
        
        encabezado.add(nombre);                         //Añade al encabezado los elementos JLabel nombre
        encabezado.add(votante);                        //Añade al encabezado los elementos JTextFiel votante
        
        for(int i = 0; i < planilla.length ; i++){      //Ciclo para crear los 6 botones
            planilla[i] = new JButton();                //Crea un nuevo boton
            planilla[i].setBackground(color[i]);        //Asigna el color de fondo del boton de acuerdo a los colores del arreglo
            opciones.add(planilla[i]);                  //Añade los botones creados al JPanel opcionnes
            planilla[i].addMouseListener(admAccion);    //Añade el método de la clase MouseListener para generar el administrador del evento
        }
        
        for(int i = 0; i < resultados.length ; i++){            //Ciclo para crear los labels correspondientes a los resultados
            resultados[i] = new JLabel(colores[i] + " 0");      //Crea el label, con el nombre del color, incializado en cero
            pie.add(resultados[i]);                             //Añade los labels de resultado al pie
        }
        
        add(encabezado,BorderLayout.NORTH);                 //Define la posicion del encabezado dentro del BorderLayout
        add(opciones,BorderLayout.CENTER);                  //Define la posicion de las opciones dentro del BorderLayout
        add(pie,BorderLayout.SOUTH);                        //Define la posicion del pie dentro del BorderLayout
            
        setVisible(true);                                   //Visibilidad Activada
        setSize(400,300);                                   //Tamaño de la ventana
    }
    
    public static void main(String [] args){                //Método main de la clase Votaciones
        Votaciones v1 = new Votaciones();                   //Crea un objeto para generar las ventanas
    }
    
    private class AdmEveAction implements MouseListener{    //Clase interna para el MouseListener
        /**
         * Método que NO muestra el color cuando el mouse no esté encima del botón
         */
        public void mouseExited(MouseEvent ev){             //Firma del metodo mouseExited
            JButton act = (JButton) ev.getSource();         //Obtiene el evento generado del boton presionado
            int bact;                                       
            for(bact = 0 ; act != planilla[bact]; bact++);  //Ciclo que recorre el arreglo de botones
                act.setText("");                            //Texto vacío dentro del botón
        }
        
        /**
         * Método que muestra el nombre del color del botón cuando el mouse esté encima del mismo
         */
        public void mouseEntered(MouseEvent ev){            //Firma del metodo mouseEnterd
            JButton act = (JButton) ev.getSource();         //Obtiene el evento generado del botón presionado
            int bact;
            for(bact = 0 ; act != planilla[bact]; bact++);  //Ciclo que recorre el arreglo de botones
                act.setText(colores[bact]);                 //Texto con el nombre del color del botón
        }
        
        /**
         * Método que al mantener presionado un botón genera un evento
         */
        public void mousePressed(MouseEvent ev){            //Firma del método mousePressed

        }
        
        /**
         * Método que al clickear una vez, aumenta el contador de resultados en +1
         */
        public void mouseReleased(MouseEvent ev){           //Firma del método mouseRelaased
            JButton act = (JButton) ev.getSource();         //Obtiene el evento generado del botón presionado
            int bact;
            for(bact = 0 ; act != planilla[bact]; bact++);  //Ciclo que recorre el el arreglo de botones
                resultados[bact].setText(colores[bact]+"  "+//Asigna el texto asociado con el numero de botón la cantidad de votos
                Integer.toString(cantidad[bact]++));
        }
        
        public void mouseClicked(MouseEvent ev){}
    }
}