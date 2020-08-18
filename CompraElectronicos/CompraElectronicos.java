import javax.swing.*; //Importa las librerias necesarias
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Clase que implementa JCheckBox como opciones de compra de electronicos, 
 * realiza el calculo de los objetos marcados
 * 
 * @author: Alejandro Diaz Ruiz
 * @version: 17/02/2020
 */

public class CompraElectronicos extends JFrame{
    private int    suma;     //Cantidad de articulos
    private double sumat;    //Importe total
    private JLabel txt0;     //Titulo 1
    private JLabel txt1;     //Titulo 2
    private JCheckBox art[]; //Arreglo de CheckBox que mostrarán los articulos.
    private JLabel prec[];   //Arreglo de Labels que mostrarán los precios de los articulos.    
    private String articulo [] = {"Memoria 128 gb","Disco Sólido 512 GB","Unidad Óptica","Mouse Inalámbrico"}; //Arreglo de String con el nombre de los articulos
    private double precio   [] = {245.00,767.8,498.00,103.00};                                                 //Arreglo con los precios de cada objeto
    private JButton calcular;//Botón para realizar el calculo
    private JLabel importe;  //Label donde muestra el importe
    private JLabel cantidad; //Label que muestra la cantidad de articulos seleccionados

    /**
     * Constructor de la clase CompraElectronicos
     */
    public CompraElectronicos(){
        //Instancia los objetos y asigna las propiedades necesarias
        txt0 = new JLabel(" Selecciona los articulos a comprar: "); //Instancia del objeto importe
        txt0.setFont(new Font("Dialog",1,16));         //Asigna un tipo de letra

        txt1 = new JLabel("Articulos");                //Instancia del objeto importe
        txt1.setFont(new Font("Dialog",1,16));         //Asigna un tipo de letra

        art  = new JCheckBox[articulo.length];
        prec = new JLabel[articulo.length];
        calcular = new JButton("Calcular");

        importe  = new JLabel("Importe total:  ");     //Instancia del objeto importe
        importe.setFont(new Font("Dialog",1,14));      //Asigna un tipo de letra
        importe.setHorizontalAlignment(JLabel.CENTER); //Alineacion

        cantidad = new JLabel("No. Articulos: ");      //Instancia del objeto cantidad
        cantidad.setFont(new Font("Dialog",1,14));     //Asigna un tipo de letra

        AdmItem aditem = new AdmItem();                //Instancia de la clase anónima---------
        JPanel encabezado = new JPanel();              //Nuevo panel
        encabezado.setLayout(new GridLayout(2,1));     //Con distribucion de dos filas por una columna
        encabezado.setBackground(Color.ORANGE);        //Agrega en color de fondo
        encabezado.add(txt0);                          //Agrega los dos labels...
        encabezado.add(txt1);

        JPanel articulos = new JPanel();               //Nuevo panel
        articulos.setLayout(new GridLayout(4,1));      //Con distribucion de cuatro filas por una columna
        articulos.setBackground(Color.yellow);         //Agrega en color de fondo

        JPanel precios = new JPanel();                 //Nuevo panel
        precios.setLayout(new GridLayout(4,1));        //Con distribucion de cuatro filas por una columna
        precios.setBackground(Color.WHITE);            //Agrega en color de fondo

        JPanel opciones = new JPanel();                //Nuevo panel
        opciones.setLayout(new GridLayout(1,2));       //Con distribucion de una fila por dos columnas
        
        opciones.add(articulos);                       //Al panel opciones se agregan los paneles articulos y precios
        opciones.add(precios);
        
        JPanel resultados = new JPanel();              //Nuevo panel
        resultados.setLayout(new GridLayout(3,1));     //Con distribucion de una fila por dos columnas
        resultados.setBackground(Color.ORANGE);        //Agrega en color de fondo
        resultados.add(calcular);                      //Al panel resultados se agregan los lables correspondientess
        resultados.add(cantidad);
        resultados.add(importe);
        
        //Ciclo for que se encarga de inicializar los objetos JCheckBox y asociarlos con los nombres y precios correspondientes
        for (int i = 0 ; i < articulo.length ; i++){
            art[i] = new JCheckBox();                   //Nuevo objeto
            art[i].setText(articulo[i]);                //Agrega nombre del arreglo de los artiulos
            art[i].setFont(new Font("Dialog",1,14));    //Establece un formato de letra
            articulos.add(art[i]);                      //Agrega al panel articulos
            art[i].addItemListener(aditem);             //Agrega el listener a cada objeto
            
            prec[i] = new JLabel();                     //Nuevo objeto
            prec[i].setText(""+precio[i]);              //Asigna el precio del arreglo precio
            prec[i].setFont(new Font("Dialog",1,14));   //Establece un formato de letra
            prec[i].setHorizontalAlignment(JLabel.CENTER);
            precios.add(prec[i]);                       //Añade los precios al panel correspondiente
        }
        
        calcular.addActionListener(                                 //Agrega un listener al botón calcular
            new ActionListener(){                                   //Inicio de la clase anónima
                /**
                 * Método que permite recuperar el evento generado por el botón calcular
                 * @param ev Evento del botón
                 */
                public void actionPerformed(ActionEvent ev) {
                    int bact;                                       
                    for(bact = 0 ; bact < art.length; bact++){      //Recorre el arreglo de articulos
                        if (art[bact].isSelected() == true){        //Si un articulo es seleccionado
                            sumat = sumat+precio[bact];             //realiza la suma de los pruductos
                        }
                        importe.setText("Importe total:  "+sumat);  //Asigna el importe total
                    } 
                    sumat = 0;
                }  
            }
        );                                                          //Fin de la clase anónima
          
        add(encabezado,BorderLayout.NORTH);                         //Agrega los panels al JFrame
        add(opciones,BorderLayout.CENTER); 
        add(resultados,BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             //Cerrar ventana
        setVisible(true);                                           //Visibilidad activada
        setSize(380,300);                                           //Tamaño de la ventana
    }
    
    //Clase privada 
    private class AdmItem implements ItemListener{
        /*
         * Método que recupera si un CheckBox está selecciado
         * @param event Item seleccionado
         */
        public void itemStateChanged(ItemEvent event){
            Object e = event.getSource();                           //Almacena en un objeto el evento generado
            if(event.getStateChange() == ItemEvent.SELECTED){       //Condición si se encuentra seleccionado
                suma++;
                cantidad.setText("No. Articulos: "+suma);           //Incrementa en uno la suma de los articulos
            }else{                                                  //De lo contrario
                suma--;                                             //Resta uno según el item seleccionado
                cantidad.setText("No. Articulos: "+suma);           //Asigna la cantidad de articulos
            }
        }
    }//Fin de la clase privada

    /*
     * Método principal
     */
    public static void main(String [] args){
        CompraElectronicos c1 = new CompraElectronicos();
    }
}