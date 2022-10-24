/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 *
 * @author jpgonzalez
 */
public class Disparo extends Imagen implements Config{
    private Rectangle2D.Float hitbox;
    private float velocidadProyectil = 2.0f;
    private int direccion = -1;
    private boolean enRango = true;
    private ArrayList<Image> imagenesAni;
    private int ultimaAni = 0;
    private int cambioAni = 15, velocidadAni = 0;
    
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
        hitbox = new Rectangle2D.Float(this.getX(), this.getY(), 16, 16);
        this.imagenesAni = new ArrayList<>();
        imagenesAnimacion();
        this.direccion = direccion;
    }
    
    public void actualizarEstado() {
        actualizarPosicion();
        actualizarAnimacion();
    }
    
    @Override
    public void renderizar(Graphics g) {
        g.drawImage(imagenesAni.get(ultimaAni), (int) this.getX(), (int) this.getY(), 128, 128, null);
        g.setColor(Color.WHITE);
        g.drawRect((int) hitbox.x, (int) hitbox.y, (int) hitbox.width, (int) hitbox.height);
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
        hitbox.x = this.getX()+45;
        hitbox.y = this.getY()+57;
    }
    
    public void imagenesAnimacion() {
        Toolkit t = Toolkit.getDefaultToolkit();
        imagenesAni.add(t.getImage("src/disparoNave/disp1.png"));
        imagenesAni.add(t.getImage("src/disparoNave/disp2.png"));
        imagenesAni.add(t.getImage("src/disparoNave/disp3.png"));
        imagenesAni.add(t.getImage("src/disparoNave/disp4.png"));
    }
    
    public void actualizarAnimacion() {
        if(ultimaAni < imagenesAni.size()-1) {
            velocidadAni++;
            if(velocidadAni >= cambioAni) {
                ultimaAni++;
                velocidadAni = 0;
                cambioAni += 5;
            }
        }
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
