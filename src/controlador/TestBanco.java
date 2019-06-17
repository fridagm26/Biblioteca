package controlador;

import modelo.ModeloBanco;
import vista.VentanaCuenta;

public class TestBanco {

    public static void main(String[] args) {
        ModeloBanco modelo = new ModeloBanco();
            VentanaCuenta vista = new VentanaCuenta();
        ControlBanco controlador = new ControlBanco(modelo, vista);
        controlador.iniciarVista();
    }
    
}
