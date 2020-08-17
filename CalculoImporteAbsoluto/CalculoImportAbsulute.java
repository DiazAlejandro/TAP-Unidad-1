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
    private JLabel tdescrp;     //Titulo "Descripción"
    private JLabel tCantidad;   //Titulo "Cantidad" 
    private JLabel tPrecio;     //Titulo "Precio" 
    private JLabel timporte;    //Titulo "Importe" 
    private JLabel importe; 	//Lugar donde mostrará el importe
    private JLabel globalim; 	//Lugar donde mostrará el importe global
    private JLabel txtg;	    //Titulo "Importe global"
    private JTextField cantidad;//Ingresae la cantidad 
    private JTextField precio;
    private JTextField descrp;
    private JButton    calculo; 
    private JTextArea  area;
    private double global;
    public CalculoImportAbsulute(){
        setTitle("Calculo importe");
        JPanel panel = new JPanel(null);
        panel.setLayout(null);
        global = 0.0;
        
        tCantidad = new JLabel ("Cantidad: ");  
        tPrecio   = new JLabel ("Precio: ");    
        timporte  = new JLabel ("Importe:");
        tdescrp   = new JLabel ("Descripcion:");
        globalim  = new JLabel (""); 
        txtg      = new JLabel ("Importe Total"); 
        calculo   = new JButton("Calcular"); 
        cantidad  = new JTextField(6);        
        precio    = new JTextField(6);
        descrp    = new JTextField(6);
        importe   = new JLabel("");
        area      = new JTextArea(110,500);
        
        final int alt = 20;
        final int anch = 165;
        
        tdescrp.setBounds(40, 30, anch, alt);
        tCantidad.setBounds(40, 70, anch, alt);
        tPrecio.setBounds(40, 110, anch, alt);
        timporte.setBounds(40, 150, anch, alt);
        panel.add(tdescrp);
        panel.add(tCantidad);
        panel.add(tPrecio);
        panel.add(timporte);
        descrp.setBounds(anch+40, 30, anch, alt);
        cantidad.setBounds(anch+40 , 70, anch, alt);
        precio.setBounds(anch+40, 110, anch, alt);
        importe.setBounds(anch+40, 150, anch, alt);
        panel.add(descrp);
        panel.add(cantidad);
        panel.add(precio);
        panel.add(importe);
        calculo.setBounds(100, 190, anch, alt);
        panel.add(calculo);
        area.setBounds(40, 230, 340, 330);
        panel.add(area);
        txtg.setBounds(40, 600, anch, alt);
        panel.add(txtg);
        globalim.setBounds(40+anch, 600, anch, alt);
        panel.add(globalim);
        //calculo.setPreferredSize(new Dimension(25,30));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
            
        cantidad.addKeyListener(
            new KeyAdapter(){
                public void keyTyped(KeyEvent ke){
                char k = ke.getKeyChar();
                    if (!Character.isDigit(k))
                        ke.consume();  
                }
            }
        );
        precio.addKeyListener(
            new KeyAdapter(){
                public void keyTyped(KeyEvent ek){
                    char car = ek.getKeyChar();
                    if (ek.getSource() == cantidad){
                        if(!Character.isDigit(car)){
                            ek.consume();
                        }
                    } 
                    
                    if(ek.getSource() == precio){
                        if(car == '.'){
                            if (precio.getText().contains(".")){
                                ek.consume();
                            } else 
                                precio.setText(precio.getText()+car);
                        }
                        if (!Character.isDigit(car)){
                            ek.consume();
                        }
                    }
                }
            }
        );
        
        calculo.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent ae) {
                    Double imp = 0.0;
                    try{ 
                        imp = Double.parseDouble(cantidad.getText())*
                                     Double.parseDouble(precio.getText()); 
                        importe.setText(""+imp); 
                        
                    } catch (Exception e){ 
                        JOptionPane.showMessageDialog(null, "Error, no está introduciendo datos correctos.");
                    }
                    area.setText(" Descripcion: "+ descrp.getText() +"\n Cantidad:  "+cantidad.getText()+ 
                        " \n Precio:  " + precio.getText() +" \t Importe:  "+ imp + "\n\n"+area.getText());
                        
                    cantidad.setText("");
                    precio.setText("");
                    descrp.setText("");
                    //importe.setText("");

                    global = global + imp;
                    globalim.setText(""+global);
                }  
            }
        );
        JFrame frame = new JFrame();
          frame.add(panel);
          frame.setPreferredSize(new Dimension(440,700));
          frame.pack();
          frame.setVisible(true);
    }
    
   
    
    public static void main (String [] args){ 
        CalculoImportAbsulute calc = new CalculoImportAbsulute();
    }
}
