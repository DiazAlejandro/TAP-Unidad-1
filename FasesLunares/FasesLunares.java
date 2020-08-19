import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.net.URL;

/**
 * Clase que muestra la ejecución e implementación de un JButtonGroup mediante estados civiles
 * 
 * @author: Alejandro Diaz Ruiz
 * @version: 18/02/2020
 */

public class FasesLunares extends JFrame implements ActionListener{
    final static int noImages = 8;                          //Varible que almacena el número de imágenes
    private ImageIcon[] images = new ImageIcon[noImages];   //Arreglo de imágenes
    private JComboBox selectImages;                         //Lista de los nombres de las fases
    private JPanel panel;                                   //Panel principal
    private JPanel selectP;                                 //Panel para el ComboBox
    private JPanel imagesP;                                 //Panel donde se muestran las imagenes
    private JLabel fasesLabel;                              //Label que contendrá la imagen
    
    /**
     * Constructor de la clase FasesLunares
     */
    public FasesLunares(){
        panel   = new JPanel(); //Panel principal
        selectP = new JPanel(); //Panel para el ComboBox
        imagesP = new JPanel(); //Panel para las imagenes
        addItems();             //Lamada al método
        panel.add(selectP);     //Agrega al panel, el panel que contendrá el JComboBox
        panel.add(imagesP);     //Agrega al panel, el panel de las imagenes
    }
    
    /**
     * Método que se encarga de añadir los items a los componentes correspondientes
     */
    private void addItems(){    
        //Ciclo que se encarga de recuperar las imagenes de la carpta images y agregarlas al arreglo correspondiente
        for (int i = 0 ; i < noImages ; i++) 
            images[i] = createImageIcon("images/"+"imagen"+(i+1)+".jpg");
        //Arreglo inicializado con los nombres de las fases        
        String [] fases = {"Luna nueva","Creciente cóncava","Cuarto Creciente",
                         "Creciente convexa","Luna Llena","Menguante convexa",
                        "Cuarto Menguante","Menguante cóncava"};
        selectImages = new JComboBox(fases);                        //Inicializa el comboBox y se le agrega el arreglo con el nombre de las fases
        selectImages.setSelectedIndex(0);                           //Establece el indice que se quiere mostrar cuando se ejecuta
       
        fasesLabel = new JLabel();                                  //Crea una etiqueta para desplegar las imagenes
        fasesLabel.setHorizontalAlignment(JLabel.CENTER);           //Alienacion del contenido del label
        fasesLabel.setVerticalAlignment(JLabel.CENTER);
        fasesLabel.setVerticalTextPosition(JLabel.CENTER);
        fasesLabel.setHorizontalTextPosition(JLabel.CENTER);

        /*FORMA 1 de crear el borde
        BorderFactory.createLoweredBevelBorder();               
        BorderFactory.createEmptyBorder(5, 5, 5, 5);                //Grosor del borde
        BorderFactory.createTitledBorder("Seleccione Fase");        //Texto del borde
        */
        //Agrega borde al panel de despliegue
        selectP.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder("Seleccione Fase"),    //Titulo del borde
            BorderFactory.createEmptyBorder(5,5,5,5)));             //Grosor del borde
        imagesP.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder("Desplegar Fase"),     //Titulo del borde
            BorderFactory.createEmptyBorder(5,5,5,5)));             //Grosor del borde 
            
        //Agregaa el combobox al panel
        imagesP.add(fasesLabel);
        selectP.add(selectImages);
        
        selectImages.addActionListener(this);                       //Agrega el listener al JComboBox
    }
    
    /**
     * Método heredado de la clase ActionListener
     * @param event Evento generado al seleccionar un item del JComboBox
     */
    public void actionPerformed(ActionEvent event){
        int indexO = selectImages.getSelectedIndex();           //Recupera la posición del Item seleccionado
        fasesLabel.setIcon(images[indexO]);                     //Agrega la imagen del arreglo de imágenes
    }
    
    /**
     * Método que se encarga de recuperar las imagenes y asiganarlas al arreglo de imagenes
     * @param path Imagen a recuperar con la ruta de ubicación y en formato .jpg
     * @return ubicación de la imagen
     */
    private static ImageIcon createImageIcon (String path){
        URL imageURL = FasesLunares.class.getResource(path);    //Objeto de tipo URL para guardar la ubicación de la imagén
        if (imageURL == null){
            System.err.println("Recurso no encontrado: "+path);
            return null;
        } else {
            return new ImageIcon(imageURL);
        }      
    }
    /**
     * Método principal
     */
    public static void main(String [] args){
        FasesLunares f = new FasesLunares();                    //Instancia de la clase  
        //Crear y activar la ventana
        JFrame fasesL = new JFrame("Fases Lunares");            //Nuevo Frame
        fasesL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //Cerrar ventana
        fasesL.setContentPane(f.panel);                         //Panel de contenido
        fasesL.pack();
        fasesL.setVisible(true);
    }
}