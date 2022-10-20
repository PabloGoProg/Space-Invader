/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estados;

import controladores.Juego;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 *
 * @author jpgonzalez
 */
public class Menu extends Estado implements MetodosEstado {
    
    private Juego juego;
    
    public Menu(Juego juego) {
        super(juego);
        
    }

    @Override
    public void actualizar() {
        
    }

    @Override
    public void actualizarRenderizado(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawString("Menu de Juego", 400, 250);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_G:
                EstadosDeJuego.estadoActual = EstadosDeJuego.JUGANDO;
                System.out.println("Funciona");
                break;
        }
    }
     
}    


