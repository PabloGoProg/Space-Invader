/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estados;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 * @author jpgonzalez
 */
public interface MetodosEstado {
    
    //Resolucion de la pantalla
    public final int WIDTH = 1280;
    public final int HEIGH = 680;
    
    /**
     * Actualiza el estado y posicion de los componentes
     */
    public void actualizar();
    
    /**
     * Renderiza la imgane actualizada de los componentes 
     * dentro de la pantalla
     * @param g 
     */
    public void actualizarRenderizado(Graphics g);
    
    public void keyTyped(KeyEvent e);
    
    public void keyPressed(KeyEvent e);
    
    public void keyReleased(KeyEvent e);
     
}
