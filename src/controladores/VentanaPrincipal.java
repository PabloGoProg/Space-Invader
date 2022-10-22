/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.JFrame;

/**
 *
 * @author jpgonzalez
 */
public class VentanaPrincipal {
    private JFrame ventana;

    public VentanaPrincipal(PanelJuego panel) {
        this.ventana = new JFrame();
        
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(panel); 
        
        ventana.setResizable(false);
        ventana.pack();
        ventana.setLocationRelativeTo(null);  
        ventana.setVisible(true);
        ventana.addWindowFocusListener(new WindowFocusListener() {

                @Override
                public void windowLostFocus(WindowEvent e) {
                    panel.getJuego().windowFocusLost();
                }

                @Override
                public void windowGainedFocus(WindowEvent e) {
                        // TODO Auto-generated method stub

                }
        });
    }
}
