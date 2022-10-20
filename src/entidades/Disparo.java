/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author jpgonzalez
 */
public class Disparo extends Imagen implements Config{
    private Rectangle2D.Float hitbox;
    private float velocidadProyectil = 3.0f;
    private int direccion = 1;
    private boolean enRango = true;
    
    /**
     * Genera un vuevo proyectil de disparo con las coordenadas dadas
     * @param x coordenada en x
     * @param y coordenada en y
     * @param maquina define si el objeto sera usado por la maquina o n
     * @param ancho el ancho de la imagen
     * @param alto el ato de la imagen
     * @param direccion la direccion en la que se moverá el proyectil
     */
    public Disparo(boolean maquina, float x, float y, int ancho, int alto, int direccion) {
        super(maquina, x, y, ancho, alto);
        hitbox = new Rectangle2D.Float(x, y, 16, 16);
        this.direccion = direccion;
    }
    
    @Override
    public void renderizar(Graphics g) {
        Toolkit t = Toolkit.getDefaultToolkit();
        Image temp = t.getImage("src/recursos/shot6_3.png");
        g.drawImage(temp, (int) this.getX(), (int) this.getY(), 128, 128, null);
    }
    
    /**
     * Actualiza la posicion del disparo
     */
    @Override
    public void actualizarPosicion() {
        if(this.getX() > Config.WIDTH) {
            setEnRango(false);
        } 
        this.x += getDireccion() * getVelocidadProyectil();
    }
    
    
    /**
     * Setea la posicion inicial del siapro
     * @param x coordenanda en x
     * @param y coordenada en y
     */
    public void setPos(int x, int y) {
        hitbox.x = x;
        hitbox.y = y;
    }
    
    public Rectangle2D.Float getHitbox() {
        return hitbox;
    }

    public boolean isEnRango() {
        return enRango;
    }

    public void setEnRango(boolean enRango) {
        this.enRango = enRango;
    }

    /**
     * @param hitbox the hitbox to set
     */
    public void setHitbox(Rectangle2D.Float hitbox) {
        this.hitbox = hitbox;
    }

    /**
     * @return the velocidadProyectil
     */
    public float getVelocidadProyectil() {
        return velocidadProyectil;
    }

    /**
     * @param velocidadProyectil the velocidadProyectil to set
     */
    public void setVelocidadProyectil(float velocidadProyectil) {
        this.velocidadProyectil = velocidadProyectil;
    }

    /**
     * @return the direccion
     */
    public int getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }
    
}
