import javax.swing.*; //Importa las librerias necesarias
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Clase que calcula el importe de dos cantidades con su descripción y muestra en una caja de texto
 * los registros que se vayan introduciendo. Al final muestra el importe total acumulado
 * 
 * @author: Alejandro Diaz Ruiz
 * @version: 17/02/2020
 */
public class CalculoImportAbsulute extends JFrame{
    //Declaración de las variables (Componentes)
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

    /**
     * Constructor de la clase CalculoImportAbsolute
     */
    public CalculoImportAbsulute(){
        setTitle("Calculo importe");       //Asigna el titulo al JFrame
        JPanel panel = new JPanel(null);   //Crea un nuevo panel
        panel.setLayout(null);             //Sin ningún tipo de distribución
        global = 0.0;                      //Inicializa la variable que almacenará el importe global
        
        //Instancía y asigna las propiedades a los JLabels que aparecerán en el JFrame
        tCantidad = new JLabel ("Cantidad: ");      
        tPrecio   = new JLabel ("Precio: ");    
        timporte  = new JLabel ("Importe:");
        tdescrp   = new JLabel ("Descripcion:");
        globalim  = new JLabel (""); 
        txtg      = new JLabel ("Importe Total"); 
        importe   = new JLabel("");

        //Instancía y asigna el texto que aparecerá dentro del botón
        calculo   = new JButton("Calcular"); 

        //Instancía y asigna el tamaño de las cajas de texto
        cantidad  = new JTextField(6);        
        precio    = new JTextField(6);
        descrp    = new JTextField(6);
        
        //Instancía y asigna el tamaño a la caja de texto
        area      = new JTextArea(110,500);
        
        //Variables finales para establecer tamaño de ancho y largo de cada objeto
        final int alt = 20;
        final int anch = 165;
        
        //Asigna la posición dentro del JFrame de los titulos, 
        //setBounds(Respecto al eje x, Respecto al eje y, ancho del componente, largo del componente)
        tdescrp.setBounds(40, 30, anch, alt);
        tCantidad.setBounds(40, 70, anch, alt);
        tPrecio.setBounds(40, 110, anch, alt);
        timporte.setBounds(40, 150, anch, alt);
        //Añade los componenetes al panel.
        panel.add(tdescrp);
        panel.add(tCantidad);
        panel.add(tPrecio);
        panel.add(timporte);
        //Asigna la posición dentro del JFrame de las cajas de texto, 
        descrp.setBounds(anch+40, 30, anch, alt);
        cantidad.setBounds(anch+40 , 70, anch, alt);
        precio.setBounds(anch+40, 110, anch, alt);
        importe.setBounds(anch+40, 150, anch, alt);
        //Añade los componenetes al panel
        panel.add(descrp);
        panel.add(cantidad);
        panel.add(precio);
        panel.add(importe);
        //Asigna y añade al panel la posición del botón
        calculo.setBounds(100, 190, anch, alt);
        panel.add(calculo);
        //Asigna y añade al panel el area de texto que registrará el historial de los productos registrados
        area.setBounds(40, 230, 340, 330);
        panel.add(area);
        //Asigna y añade al panel el titulo del importe global
        txtg.setBounds(40, 600, anch, alt);
        panel.add(txtg);
        //Asigna y añade el lugar donde mostrará el importe global
        globalim.setBounds(40+anch, 600, anch, alt);
        panel.add(globalim);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar la ventana
        
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
        );                                          //Fin de la clase anónima


        precio.addKeyListener(                                          //Al componente precio se le agrega un listener 
            new KeyAdapter(){                                           //Nuevo objeto de la clase KeyAdapter (Teclado)
                /**
                 *  Método que recupera el evento generado por el teclado
                 *  @param ek Tecla pulsada por el usuario
                 */
                public void keyTyped(KeyEvent ek){                                  
                    char car = ek.getKeyChar();                         //Recupera en una variable char la tecla pulsada 

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
        );								//Fin de la clase anónima
        


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
        );								//Fin de la clase anónima

        JFrame frame = new JFrame();					//Instancia de un nuevo frame
          frame.add(panel);						//Añade el panel
          frame.setPreferredSize(new Dimension(440,700));		//Establece las dimenciones
          frame.pack();							//Propiedad que permite que no cambie el tamaño de los componentes respecto al tamaño de la ventana
          frame.setVisible(true);					//Visibilidad activada
    }
    
    /**
    * Método principal
    */  
    public static void main (String [] args){ 
        CalculoImportAbsulute calc = new CalculoImportAbsulute();
    }
}
