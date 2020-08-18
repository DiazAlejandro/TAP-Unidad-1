import javax.swing.*; //Importa las librerias necesarias
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Clase que realiza y guarda el historial del calculo de los importes correspondientes.
 * usando como tipo de distribución GridLayout
 * 
 * @author: Alejandro Diaz Ruiz
 * @version: 17/02/2020
 */

public class CalculoImporte extends JFrame{
    //Declaración de los componentes
    private JLabel tdescrp;     //Titulo "Descripción"
    private JLabel tCantidad;   //Titulo "Cantidad" 
    private JLabel tPrecio;     //Titulo "Precio" 
    private JLabel timporte;    //Titulo "Importe" 
    private JLabel importe;     //Lugar donde mostrará el importe
    private JLabel globalim;    //Lugar donde mostrará el importe global
    private JLabel txtg;        //Titulo "Importe global"
    private JTextField cantidad;//Ingresar la cantidad 
    private JTextField precio;  //Ingresar el precio
    private JTextField descrp;  //Ingresar la descripción
    private JButton    calculo; //Botón para calcular
    private JTextArea  area;    //Area de texto donde mostrará el historial de productos registrados
    private double global;      //Variable global que almacenará la suma de los importes

    /*
     * Constructor de la clase
     */
    public CalculoImporte(){
        setTitle("Calculo importe");			 //Asigna el titulo al JFrame
        JPanel index     = new JPanel();		 //Panel que almacenará otros panels cuerpo y el botón calculo
        index.setLayout(new GridLayout(3,1));            //Tipo de distribución tres filas x una columna
        JPanel cuerpo    = new JPanel();		 //Panel que contendrá los componentes para ingresar los datos del pruducto
        cuerpo.setLayout(new GridLayout(1,2));	         //Tipo de distribución una fila x dos columnas 
        JPanel izquierdo = new JPanel();		 //Panel que contendrá los componentes "Titulo"
        izquierdo.setLayout(new GridLayout(4,1));        //Tipo de distribución cuatro filas x una columna
        JPanel derecho   = new JPanel();		 //Panel que contendrá los componentes para ingresar los datos
        derecho.setLayout(new GridLayout(4,1));	         //Tipo de distribución cuatro filas x una columna
        JPanel pie   = new JPanel();			 //Panel que contendrá los compoenentes de importe global
        pie.setLayout(new GridLayout(1,2));		 //Tipo de distribución una fila x dos columnas
        global = 0.0;                                    //Variable global donde se almacenará el importe global
        
        //Inicializa y asigna el texto que contendrán los componentes
        tCantidad = new JLabel ("Cantidad: ");  
        tPrecio   = new JLabel ("Precio: ");    
        timporte  = new JLabel ("Importe:");
        tdescrp   = new JLabel ("Descripcion:");
        globalim  = new JLabel (""); 
        txtg      = new JLabel ("Importe Total"); 
        calculo   = new JButton("Calcular");  
        importe   = new JLabel("");
        //Inicializa y asigna el tamaño a los componentes para ingresar datos
        cantidad  = new JTextField(6);        
        precio    = new JTextField(6);
        descrp    = new JTextField(6);
        //Inizializa el area de texto
        area      = new JTextArea(110,500);
        
        calculo.setPreferredSize(new Dimension(25,30)); //Tamaño del botón calcular
        //Añade los componentes de tipo titulo al panel izquierdo
        izquierdo.add(tdescrp);
        izquierdo.add(tCantidad);
        izquierdo.add(tPrecio);
        izquierdo.add(timporte);
        //Añade los componentes de tipo ingresar datos al panel derecho
        derecho.add(descrp);        
        derecho.add(cantidad);
        derecho.add(precio);
        derecho.add(importe);
        //Añade los panels al panel principal
        cuerpo.add(izquierdo);
        cuerpo.add(derecho); 
        //Añade el panel y el botón correspondiente
        index.add(cuerpo);
        index.add(calculo);
        //Añade al JFrame el area de texto
        add(area);
        //Al panel pie se agregan los labels correspondientes al importe global
        pie.add(txtg);
        pie.add(globalim);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Cerrar ventana
        //Añade el index y pie correspondientes añadiendo la ubicacion
        add(index,BorderLayout.NORTH);
        add(pie,BorderLayout.SOUTH);
            
        //Implementación de las clases anónimas para definir las acciones de los componentes

        cantidad.addKeyListener(                    //Al componente cantidad se le agrega un Listener 
            new KeyAdapter(){                       //Nuevo objeto de clase KeyAdapter (Teclado)
                /**
                 *  Método que recupera el evento generado por el teclado
                 *  @param ke Tecla pulsada por el usuario
                 */
                public void keyTyped(KeyEvent ke){  //Método que permite definir los eventos del teclado
                char k = ke.getKeyChar();           //Recupera en una variable char la tecla pulsada 
                    if (!Character.isDigit(k))      //Cuando no sea un caracter
                        ke.consume();               //No registra la entrada (.consume() - El evento se consume)
                }                                   //Fin del método
            }                                       //fin del objeto
        );
        
        precio.addKeyListener(                                          //Al componente precio se le agrega un listener 
            new KeyAdapter(){                                           //Nuevo objeto de la clase KeyAdapter (Teclado)
                /**
                 *  Método que recupera el evento generado por el teclado
                 *  @param ek Tecla pulsada por el usuario
                 */
                public void keyTyped(KeyEvent ek){                                  
                    char car = ek.getKeyChar();                         //Recupera en una variable char la tecla pulsada 
                    if (ek.getSource() == cantidad){
                        if(!Character.isDigit(car)){
                            ek.consume();
                        }
                    } 
                    
                    if(ek.getSource() == precio){			//Valida si el productor del evento esta generado por el componente precio
                        if(car == '.'){					//Valida si el caracter es igual a un punto
                            if (precio.getText().contains(".")){	//Recupera el contenido de la caja de texto, si contiene un punto
                                ek.consume();				//Da por consumido el evento
                            } else 					//De lo contrario...
                                precio.setText(precio.getText()+car);	//Al precio le agrega el texto (recuperando el evento antes producido)
                        }													
                        if (!Character.isDigit(car)){			//si el caracter no es un dígito...
                            ek.consume();				//consume el evento.
                        }
                    }
                }
            }
        );	                                                         //Fin de la clase anónima
        
        
        calculo.addActionListener(					//Al componente precio se le agrega un listener 
            new ActionListener(){					//Nuevo objeto de la clase ActionListener (Evento del mouse)
            	/**
                 *  Método que se ejecuta cuando se realiza un evento dentro de un botón
                 *  @param ae Evento del mouse sobre un botón
                 */
                public void actionPerformed(ActionEvent ae) {
                    Double imp = 0.0;					  //Varible local para calcular el importe de un solo producto
                    try{ 						  //Inicio del bloque try-catch
                        imp = Double.parseDouble(cantidad.getText())*		
                                     Double.parseDouble(precio.getText());//Calculo del importe de un producto
                        importe.setText(""+imp); 			  //Asigna el importe al componente
                    } catch (Exception e){ 				  //Muestra el error
                        JOptionPane.showMessageDialog(null, "Error, no está introduciendo datos correctos.");
                    }							  //Fin del bloque try-catch

                    area.setText(" Descripcion: "+ descrp.getText() +	  //Agrega al área del texto los datos que introducimos
                    			"\n Cantidad:  "+cantidad.getText()+ 
                        		" \n Precio:  " + precio.getText() +
                        		" \t Importe:  "+ imp + "\n\n"+area.getText());
                        
                    cantidad.setText("");				//Restablece los valores por defecto de cada uno de los componentes
                    precio.setText("");										
                    descrp.setText("");

                    global = global + imp;				//Realiza la suma global de los importes generados
                    globalim.setText(""+global);			//Muestra la suma en el componente indicado
                }  
            }
        );                                                              //Fin de la clase anónima
        setVisible(true);                                               //Visibilidad activada
        setSize(350,400);                                               //Tamaño del JFrame
    }
    
    /**
     * Método principal
     */
    public static void main (String [] args){ 
        CalculoImporte calc = new CalculoImporte();
    }
}