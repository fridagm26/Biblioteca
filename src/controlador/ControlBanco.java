package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.ModeloBanco;
import vista.VentanaCuenta;

public class ControlBanco implements ActionListener{
    private ModeloBanco modelo;
    private VentanaCuenta vista;
    
    public ControlBanco(ModeloBanco modelo, VentanaCuenta vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.txtCuenta1.addActionListener(this);
        this.vista.txtCuenta2.addActionListener(this);
        this.vista.txtTotal.addActionListener(this);
        this.vista.btnTransferir.addActionListener(this);
    }
    
    public void iniciarVista() {
        vista.setTitle("Ventana de Cuenta");
        vista.pack();
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent evento) {
        if(vista.btnTransferir == evento.getSource()){
            if(modelo.contactosActualizar(
                    vista.txtCuenta1.getText(), vista.txtCuenta2.getText(), 
                    Double.parseDouble(vista.txtTotal.getText())));
            }
        }
    }
