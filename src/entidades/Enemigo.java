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

/**
 *
 * @author 57301
 */
public class Enemigo extends Nave implements Config {
    
    private Rectangle2D.Float hitbox;
    private Disparo disparo;
    private boolean viva = false;
    private Image propulsor;

    public Enemigo(boolean maquina, float x, float y, int ancho, int alto) {
        super(maquina, x, y, ancho, alto);
        this.hitbox = new Rectangle2D.Float(this.getX(), this.getY()+13, 64, 32);
        this.disparo = new Disparo(true, getX(), getY(), 64, 64, -1);
        disparo.setEnRango(false);
        sacarImgAni();
    }

    /**
     * Se encarga de dibujar la nave en pantalla
     * @param g 
     */
    @Override
    public void renderizar(Graphics g) {
        Image imagen = super.definirNave();
        this.getDisparo().renderizar(g);
        if(isViva()) {
           g.drawImage(getPropulsor(), (int) getX(), (int) getY()-32, 128, 128, null);
           g.drawImage(imagen, (int) getX(), (int) getY(), 64, 64, null);
        }
    }
    
    @Override
    public void actualizarEstdo() {
        actualizarPosicion();
        actualizarHitbox();
        this.getDisparo().actualizarEstado();
        disparar();
    }
    
    @Override
    public void actualizarHitbox() {
        hitbox.x = this.getX();
        hitbox.y = this.getY()+13;
    }
    
    @Override
    public void actualizarDiapros() {
        int i = Integer.MAX_VALUE;
        for (Disparo actual : getDisparos()) {
            if(!actual.isEnRango()) i = getDisparos().indexOf(actual);
            else {
                actual.actualizarPosicion();
            }
        }
        if(i < getDisparos().size()) getDisparos().remove(i);
    }
    
    @Override
    public void actualizarPosicion() {
        if(this.getX() < 0) {
            this.setX(Config.WIDTH + 840);
            this.setY(Math.round(Math.random()*540+5));
            this.setViva(true);
        }
        this.setX(this.getX() - 1.5f);
    }

    public void sacarImgAni() {
        Toolkit t = Toolkit.getDefaultToolkit();
        setPropulsor(t.getImage("src/recursos/propEnemigo.png"));
    }
    
    @Override
    public void disparar() {
        this.getDisparo().setVelocidadProyectil(3f);
        if(!this.getDisparo().isEnRango() && isViva()) {
            this.setDisparo(new Disparo(true, this.getX(), this.getY()-32, 64, 64, -1));
        }
    }
    
    /**
     * @return the hitbox
     */
    public Rectangle2D.Float getHitbox() {
        return hitbox;
    }

    /**
     * @param hitbox the hitbox to set
     */
    public void setHitbox(Rectangle2D.Float hitbox) {
        this.hitbox = hitbox;
    }

    /**
     * @return the viva
     */
    public boolean isViva() {
        return viva;
    }

    /**
     * @param viva the viva to set
     */
    public void setViva(boolean viva) {
        this.viva = viva;
    }

    /**
     * @return the disparo
     */
    public Disparo getDisparo() {
        return disparo;
    }

    /**
     * @param disparo the disparo to set
     */
    public void setDisparo(Disparo disparo) {
        this.disparo = disparo;
    }

    /**
     * @return the propulsor
     */
    public Image getPropulsor() {
        return propulsor;
    }

    /**
     * @param propulsor the propulsor to set
     */
    public void setPropulsor(Image propulsor) {
        this.propulsor = propulsor;
    }
    
}
