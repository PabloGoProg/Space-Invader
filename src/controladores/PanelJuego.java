/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import entidades.Config;

import inputs.InputTeclado;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author jpgonzalez
 */
public class PanelJuego extends JPanel {

    private Juego juego;
    private JButton play;
    private SClip menuSound = new SClip("src/recursos/menuSound.wav");
    private boolean paused = false;
    
    public PanelJuego(Juego juego) {
        this.juego = juego;
        setReslucion();
        addKeyListener(new InputTeclado(this));
        this.setBackground(Color.BLACK);
        this.menuSound.loop();
    }
    
    /**
     * Define la resolución que va a tener la venatana del juego
     */
    public void setReslucion() {
        Dimension res = new Dimension(Config.WIDTH, Config.HEIGH);
        setMinimumSize(res);
        setMaximumSize(res);
        setPreferredSize(res);
    }

    /**
     * Imprime los componentes seleccionados para el juego
     * @param g 
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        juego.renderizar(g);
        if(paused){
            g.setFont(new Font( "Tahoma", Font.BOLD, 46 ) );
            g.setColor(Color.WHITE);
            g.drawString("PAUSED", (Config.WIDTH/2)-70, (Config.HEIGH/2)-50);
        }
    }
    
    public Juego getJuego() {
        return juego;
    }

    public void setPlay(JButton play) {
        this.play = play;
    }

    public JButton getPlay() {
        return play;
    }

    public SClip getMenuSound() {
        return menuSound;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }
      
}
