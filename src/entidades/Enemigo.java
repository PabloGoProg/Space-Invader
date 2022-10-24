/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import static animaciones.constantes.Direccion.DERECHA;
import static animaciones.constantes.Direccion.IZQUIERDA;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author 57301
 */
public class Enemigo extends Nave implements Config {

    public Enemigo(boolean maquina, float x, float y, int ancho, int alto) {
        super(maquina, x, y, ancho, alto);
    }

    /**
     * Se encarga de dibujar la nave en pantalla
     * @param g 
     */
    @Override
    public void renderizar(Graphics g) {
        Image imagen = super.definirNave();
//        g.drawImage(movAni.get(ultimaAni), (int) getX()-35, (int) getY(),64, 64, null);
        g.drawImage(imagen, (int) getX(), (int) getY(), 64, 64, null);
//        for(Disparo temp : getDisparos()) {
//            temp.renderizar(g);
//        }
    }
    @Override
    public void actualizarEstdo() {
        actualizarPosicion();
        actualizarDiapros();
        actualizarAnimacion();
        for(Disparo cur : disparos) {
            cur.actualizarEstado();
        }
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
        }
        this.setX(this.getX() - 1.5f);
    }
    
}
