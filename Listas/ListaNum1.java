import java.util.List;
import javax.swing.*;
import java.awt.*;
import javax.swing.DefaultListModel;
import java.awt.event.*;

/**
 * Clase que muestra una lista de numeros, y muestra las opciones de copiar y mover de una lista a otra
 * 
 * @author: Alejandro Diaz Ruiz
 * @version: 19/02/2020
 */

public class ListaNum1 extends JFrame{
    private JList listaNumeros;                     //Lista para guardar numeros enteros   
    private JList copiaLista;                       //Lista para contener elementos que se copien o muevan   
    private JButton botonJButtonCopiar;             //Botón para copiar
    private JButton botonJButtonMover;              //Botón para mover  
    private DefaultListModel modelo;                //Modelo para almacenar los numeros
    private DefaultListModel modelo1;               //Modelo para almacenar los numeros copiados o movidos
    private final int NV=10;                        //Numero de valores   
    /**
     * Constructor de la clase 
     */
    public ListaNum1(){  
        super("Listas con seleccion multiple");      
        JPanel panel1= new JPanel();                //Panel que contendrá los componentes
        listaNumeros = new JList();                 //Modelo de la lista 2
        copiaLista   = new JList();                 //Modelo de la lista 1
        listaNumeros.setFixedCellWidth(30);         //Tamaño de la lista
        //Modelo y modelo1 son los modelos de las listas      
        modelo  = new DefaultListModel();      
        modelo1 = new DefaultListModel();      
        agregar(modelo);                            //Agrega los elementos del 1 al 10 al modelo 
        listaNumeros.setModel(modelo);              //Muestra en el componente los elementos
        listaNumeros.setVisibleRowCount(5);         //Muestra cinco filas      
        listaNumeros.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);  //Propiedad que permite seleccionar más de un renglón en la lista 
        //Agrega la lista con panel de desplazamiento      
        botonJButtonCopiar = new JButton( "Copiar >>>" ); //Crea botón para copiar      
        botonJButtonMover = new JButton( "Mover >>>" );   //Crea botón para mover      
        
        botonJButtonMover.addActionListener(          
        new ActionListener(){                                       //Clase interna anónima          
            /**
             * Método que maneja el evento del botón mover
             * coloca los valores seleccionados en copiaLista  
             * @param evento Evento al hacer clic en el botón
             */
            public void actionPerformed( ActionEvent evento ){                           
                int ind[]= listaNumeros.getSelectedIndices();       //Recupera en un arreglo los numeros seleccionados              
                for(int i=ind.length-1;i>=0; i--){
                    modelo1.addElement(modelo.get(ind[i]));         //Añade el elemento seleccionado del modelo al modelo1
                    modelo.removeElementAt(ind[i]);                 //Elimina el elemento del modelo principal
                }                
                listaNumeros.clearSelection();                      //Borra la selección de los números 
                copiaLista.setModel(modelo1);                                  
            }                                                       //Fin del método actionPerformed         
        }                                                           //Fin de la clase interna anónima      
        );                                                          //Fin de la llamada a addActionListener
        
        botonJButtonCopiar.addActionListener(          
        new ActionListener(){                                       //Clase interna anónima         
            /**
             * Método que maneja el evento del botón copiar
             * coloca los valores seleccionados en copiaLista  
             * @param evento Evento al hacer clic en el botón
             */          
            public void actionPerformed(ActionEvent evento){        //Coloca los valores seleccionados en copiaLista
                int ind[]= listaNumeros.getSelectedIndices();       //Recupera en un arreglo los numeros seleccionados    
                for(int i=ind.length-1;i>=0; i--){
                    modelo1.addElement(modelo.get(ind[i]));         //Añade el elemento seleccionado del modelo al modelo1                     
                }  
                listaNumeros.clearSelection();       
                copiaLista.setModel(modelo1);  
            }                                                       //Fin del método actionPerformed         
        }                                                           //Fin de la clase interna anónima      
        );                                                          //Fin de la llamada a addActionListener
        
        panel1.add(botonJButtonCopiar);                             //Agrega el botón copiar al panel      
        panel1.add(botonJButtonMover);                              //Agrega el botón mover al panel      
        add(panel1,BorderLayout.CENTER);                            //Orientacion dentro del panel
        copiaLista = new JList();      
        copiaLista.setVisibleRowCount(5);                           //Muestra 5 filas      
        copiaLista.setFixedCellWidth(30);                           //Establece el ancho      
        copiaLista.setFixedCellHeight(15);                          //Establece la altura      
        copiaLista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); //Propiedad que permite seleccionar más de un renglón en la lista 
        // JScrollPane es un elemento que sirve para desplazar los elementos que ahi se incluye      
        add(new JScrollPane(listaNumeros),BorderLayout.WEST);      
        add(new JScrollPane(copiaLista),BorderLayout.EAST); // agrega lista con panel de desplazamiento   
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(380,300);
    } // fin del constructor de MarcoListaNum  
        
    /**
     * Método para agregar los elementos a la lista 1
     */
    public void agregar(DefaultListModel modelo)  {  
        for(int e=0; e< NV;e++){
        modelo.addElement(e);}
    }
    
    /**
     * Método principal
     */
    public static void main(String [] args){
        ListaNum1 l1 = new ListaNum1();
    }
}

