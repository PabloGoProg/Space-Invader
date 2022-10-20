/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inputs;

import controladores.PanelJuego;
import estados.EstadosDeJuego;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author jpgonzalez
 */
public class InputTeclado implements KeyListener {
    private PanelJuego panelJuego;

    public InputTeclado(PanelJuego panelJuego) {
        this.panelJuego = panelJuego;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }
    
}
