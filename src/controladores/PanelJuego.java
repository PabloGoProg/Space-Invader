/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import entidades.Config;
import inputs.InputTeclado;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author jpgonzalez
 */
public class PanelJuego extends JPanel {

    private Juego juego;
    
    public PanelJuego(Juego juego) {
        this.setLayout(null);
        this.juego = juego;

        addKeyListener(new InputTeclado(this));
        this.setBackground(Color.BLACK);
        setReslucion();
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
    }
    
    public Juego getJuego() {
        return juego;
    }
}
