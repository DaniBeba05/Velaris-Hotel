package Main;

import javax.swing.JFrame;
import View.InitialView;

/**
 *
 * @author usuario
 */
public class RunVelaris {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Velaris Hotel");

        // Configurar las propiedades del marco
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(468, 321); 
        frame.setLocationRelativeTo(null);

        // Crear una instancia de la vista inicial
        InitialView initialView = new InitialView();

        // Agregar la vista al marco
        frame.setContentPane(initialView);

        // Hacer el marco visible
        frame.setVisible(true);
    }
}

