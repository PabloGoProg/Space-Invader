/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estados;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 *
 * @author jpgonzalez
 */
public interface MetodosEstado {
        
    public void actualizar();
    
    public void actualizarRenderizado(Graphics g);
    
    public void keyTyped(KeyEvent e);
    
    public void keyReleased(KeyEvent e);
    
    public void keyPressed(KeyEvent e);
     
}
