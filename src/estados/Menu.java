/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estados;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import controladores.Juego;
import controladores.SClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author jpgonzalez
 */
public class Menu extends Estado implements MetodosEstado {
    
    // Audio de menu
    SClip soundtrack = new SClip("src/recursos/soundtrack.wav");
    
    public Menu(Juego juego) {
        super(juego);
        
    }

    @Override
    public void actualizar() {
        this.soundtrack.loop();
    }

    @Override
    public void actualizarRenderizado(Graphics g) {
        //fondo
        Toolkit t = Toolkit.getDefaultToolkit();
        Image img = t.getImage("src/recursos/6356f81442421.jpg");
        g.drawImage(img, 0, 0, MetodosEstado.WIDTH, MetodosEstado.HEIGH, null);
        g.setFont(new Font( "Tahoma", Font.BOLD, 46 ) );
        Color c = new Color(174,149,179);
        g.setColor(c);
        g.drawString("PRESS ENTER TO PLAY", (MetodosEstado.WIDTH/2)-250, (MetodosEstado.HEIGH/2)-100);
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

