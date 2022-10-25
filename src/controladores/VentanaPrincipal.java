/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;
import javax.swing.JFrame;

/**
 *
 * @author jpgonzalez
 */
public class VentanaPrincipal {
    private JFrame ventana;

    public VentanaPrincipal(PanelJuego panel) {
        this.ventana = new JFrame("SPICY SHIPS");
        
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(panel); 
        
        ventana.setResizable(false);
        ventana.pack();
        ventana.setLocationRelativeTo(null);  
        ventana.setVisible(true);
    }
}
