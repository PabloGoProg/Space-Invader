/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.awt.Graphics;

/**
 *
 * @author jpgonzalez
 */
public interface Config {
    public final int WIDTH = 1280;
    public final int HEIGH = 680;
    
    public void renderizar(Graphics g);
    public void actualizarPosicion();
}
