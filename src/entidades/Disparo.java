/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

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
        this.direccion = direccion;
        imagenesAnimacion();
    }
    
    public void actualizarEstado() {
        actualizarPosicion();
        actualizarAnimacion();
    }
    
    @Override
    public void renderizar(Graphics g) {
        g.drawImage(getImagenesAni().get(getUltimaAni()), (int) this.getX(), (int) this.getY(), 128, 128, null);
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
        hitbox.x = this.getX()+38;
        hitbox.y = this.getY()+57;
    }
    
    public void imagenesAnimacion() {
        Toolkit t = Toolkit.getDefaultToolkit();
        getImagenesAni().add(t.getImage("src/disparoNave/disp1.png"));
        getImagenesAni().add(t.getImage("src/disparoNave/disp2.png"));
        getImagenesAni().add(t.getImage("src/disparoNave/disp3.png"));
        getImagenesAni().add(t.getImage("src/disparoNave/disp4.png"));
    }
    
    /**
     * Se encarga de animar el disparo desde el momento que sale de la nave
     */
    public void actualizarAnimacion() {
        if(getUltimaAni() < getImagenesAni().size()-1) {
            setVelocidadAni(getVelocidadAni() + 1);
            if(getVelocidadAni() >= getCambioAni()) {
                setUltimaAni(getUltimaAni() + 1);
                setVelocidadAni(0);
                setCambioAni(getCambioAni() + 5);
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

    /**
     * @return the imagenesAni
     */
    public ArrayList<Image> getImagenesAni() {
        return imagenesAni;
    }

    /**
     * @param imagenesAni the imagenesAni to set
     */
    public void setImagenesAni(ArrayList<Image> imagenesAni) {
        this.imagenesAni = imagenesAni;
    }

    /**
     * @return the ultimaAni
     */
    public int getUltimaAni() {
        return ultimaAni;
    }

    /**
     * @param ultimaAni the ultimaAni to set
     */
    public void setUltimaAni(int ultimaAni) {
        this.ultimaAni = ultimaAni;
    }

    /**
     * @return the cambioAni
     */
    public int getCambioAni() {
        return cambioAni;
    }

    /**
     * @param cambioAni the cambioAni to set
     */
    public void setCambioAni(int cambioAni) {
        this.cambioAni = cambioAni;
    }

    /**
     * @return the velocidadAni
     */
    public int getVelocidadAni() {
        return velocidadAni;
    }

    /**
     * @param velocidadAni the velocidadAni to set
     */
    public void setVelocidadAni(int velocidadAni) {
        this.velocidadAni = velocidadAni;
    }
    
}
