import javax.swing.*; //Importa las librerias necesarias
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Examen extends JFrame{
    private JLabel enc;
    private JLabel nmed;
    private JLabel tlec;
    private JLabel tlac;
    private JLabel cons;
    private JLabel tcons;
    private JLabel serv;
    private JTextField  nomed;
    private JSpinner anterior, actual;
    private JRadioButton serv1;
    private JRadioButton serv2;
    private JRadioButton serv3;
    private final ButtonGroup grupo = new ButtonGroup();
    private JButton calc;
    private JLabel rel;
    private JLabel encab;
    private JTextArea tot;
    public Examen()  {
        anterior = new JSpinner(new SpinnerNumberModel(0,0,10,1));
        actual = new JSpinner(new SpinnerNumberModel(0,0,10,1));
        
        enc = new JLabel("Calculo de importe de consumo de agua");
        nmed = new JLabel("No. medidor");
        nomed = new JTextField(3);
        tlec = new JLabel("Lectura anterior (mt3)");
        tlac = new JLabel("Lectura actual (mt3)");
        cons = new JLabel("Consumo");
        tcons = new JLabel("");
        serv = new JLabel("Tipo de servicio");
        serv1 = new JRadioButton("Residencial A");
        serv2 = new JRadioButton("Residencial B");
        serv3 = new JRadioButton("Residencial C");
        
        calc = new JButton("Calcular");
        rel = new JLabel("Relacion de pagos");
        encab = new JLabel("Medidor Consumo Importe");
        tot      = new JTextArea(110,110);
        JPanel encabezado = new JPanel();
        encabezado.setLayout(new GridLayout(1,1));
        encabezado.add(enc);
        
        JPanel datos = new JPanel();
        datos.setLayout(new GridLayout(5,2));
        
        datos.add(nmed);
        datos.add(nomed);
        datos.add(tlec);
        datos.add(anterior);
        datos.add(tlac);
        datos.add(actual);
        datos.add(cons);
        datos.add(tcons);
        datos.add(serv);
        
        grupo.add(serv1);
        grupo.add(serv2);
        grupo.add(serv3);
        
        JPanel servicios = new JPanel();
        servicios.setLayout(new GridLayout(1,3));
        servicios.add(serv1);
        servicios.add(serv2);
        servicios.add(serv3);
        JPanel datose = new JPanel();
        datose.setLayout(new GridLayout(3,1));
        
        datose.add(encabezado);
        datose.add(datos);
        datose.add(servicios);
        
        
        JPanel resultados = new JPanel();
        resultados.setLayout(new GridLayout(4,1));
        resultados.add(calc);
        resultados.add(rel);
        resultados.add(encab);
        
        JPanel index = new JPanel();
        index.setLayout(new GridLayout(2,1));
        index.add(datose);
        index.add(resultados);
        add(tot);
        add(index,BorderLayout.NORTH);
       
        calc.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent ae) {
                    int no;
                    
                    try{ 
                        no = Integer.parseInt(nomed.getText()); 
                        if ((int)actual.getValue() < (int)anterior.getValue()){
                            JOptionPane.showMessageDialog(null, "El consumo actual tiene que ser mayor que el anterior");  
                        }
                    } catch (Exception e){ 
                        JOptionPane.showMessageDialog(null, "Introduce un numero de medidor valido");
                        nomed.setText("");
                    }
                }
            }
            );
        setSize(400,380);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
}
    
    public static void main (String [] args){
        new Examen();
    }
}