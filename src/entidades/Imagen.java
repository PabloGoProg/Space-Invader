/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.awt.geom.Rectangle2D;

/**
 *
 * @author 57301
 */
public class Imagen {
    
    protected String ruta;
    protected boolean maquina;
    protected float x;
    protected float y;
    protected int ancho;
    protected int alto;
    protected Rectangle2D.Float hitbox;

    public Imagen(boolean maquina, float x, float y, int ancho, int alto) {
        this.maquina = maquina;
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        hitbox = new Rectangle2D.Float(x, y, x, y);
    }
    
    public Imagen(String ruta, boolean maquina) {
        this.ruta = ruta;
        this.maquina = true;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public boolean isMaquina() {
        return maquina;
    }

    public void setMaquina(boolean maquina) {
        this.maquina = maquina;
    }

    public float getX() {
        return x;
    }
    
    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public Rectangle2D.Float getHitbox() {
        return hitbox;
    }

    public void setHitbox(Rectangle2D.Float hitbox) {
        this.hitbox = hitbox;
    }

}
