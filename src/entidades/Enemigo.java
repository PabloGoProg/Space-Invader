/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author 57301
 */
public class Enemigo extends Nave implements Config {
    
    private Rectangle2D.Float hitbox;
    private boolean viva = true;

    public Enemigo(boolean maquina, float x, float y, int ancho, int alto) {
        super(maquina, x, y, ancho, alto);
        this.hitbox = new Rectangle2D.Float(this.getX(), this.getY()+20, this.getAncho(), this.getAlto()-13);
    }

    /**
     * Se encarga de dibujar la nave en pantalla
     * @param g 
     */
    @Override
    public void renderizar(Graphics g) {
        Image imagen = super.definirNave();
        if(isViva()) g.drawImage(imagen, (int) getX(), (int) getY(), 64, 64, null);
    }
    
    @Override
    public void actualizarEstdo() {
        actualizarPosicion();
        actualizarDiapros();
        actualizarAnimacion();
        actualizarHitbox();
        for(Disparo cur : disparos) {
            cur.actualizarEstado();
        }
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
    
}
