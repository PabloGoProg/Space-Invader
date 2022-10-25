/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estados;

import controladores.Juego;
import entidades.Config;
import entidades.Disparo;
import entidades.Enemigo;
import entidades.Estrella;
import entidades.Imagen;
import entidades.Nave;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author jpgonzalez
 */
public class Jugando extends Estado implements MetodosEstado {
    
    private ArrayList<Enemigo> enemigos;
    private ArrayList<Estrella> estrellas;
    private Nave nave; 
    
    public Jugando(Juego juego) {
        super(juego);
        this.enemigos = new ArrayList<>();
        this.estrellas = new ArrayList<>();
        desplegarComponentes();
    }
    
    /**
     * Imprime los componentes queridos dentro del frame
     */
    private void desplegarComponentes() {
        setNave(new Nave(false, 368f, 278f, 64, 64));
        for(int i = 0; i < (int)Math.random()*100+80; i++){
            this.getEstrellas().add(new Estrella(false, 
                    Math.round(Math.random()*Config.WIDTH+10), 
                    Math.round(Math.random()*Config.HEIGH+10), 7, 7));
        }
        this.crearEnemigos();
    }
    
    public void crearEnemigos(){
        for (int i = 0; i < 5; i++) {
            this.getEnemigos().add(new Enemigo(true, Math.round(Math.random()*Config.WIDTH+1100),Math.round(Math.random()*540+5) , 48, 48));
        }
    }
    
    @Override
    public void actualizar() {
        for(Estrella temp : getEstrellas()) {
            temp.actualizarPosicion();
        }
        this.getNave().actualizarEstdo();
        for (Enemigo temp : getEnemigos()) {
            temp.actualizarEstdo();
        }  
        
        validarColDispario();
    }

    @Override
    public void actualizarRenderizado(Graphics g) {
        for(Estrella actu : getEstrellas()) {
            actu.renderizar(g);
        }
        this.getNave().renderizar(g);
        for (Enemigo temp : getEnemigos()) {
            temp.renderizar(g);
        }
    }
    
    public void validarColDispario() {
        for(Disparo disp : getNave().getDisparos()) {
            for(Enemigo enemigo : getEnemigos()) {
                if(disp.getHitbox().intersects(enemigo.getHitbox()) && enemigo.isViva()) {
                    disp.setEnRango(false); 
                    enemigo.setViva(false);
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                getNave().setUp(false);
                break;
            case KeyEvent.VK_A:
                getNave().setLeft(false);
                break;
            case KeyEvent.VK_S:
                getNave().setDown(false);
                break;
            case KeyEvent.VK_D:
                getNave().setRight(false);
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                getNave().setUp(true);
                break;
            case KeyEvent.VK_A:
                getNave().setLeft(true);
                break;
            case KeyEvent.VK_S:
                getNave().setDown(true);
                break;
            case KeyEvent.VK_D:
                getNave().setRight(true);
                break;
            case KeyEvent.VK_L:
                getNave().disparar();
                break;
        }
    }
    
    public Nave getNave() {
        return nave;
    }

    /**
     * @return the estrellas
     */
    public ArrayList<Estrella> getEstrellas() {
        return estrellas;
    }

    /**
     * @param estrellas the estrellas to set
     */
    public void setEstrellas(ArrayList<Estrella> estrellas) {
        this.estrellas = estrellas;
    }

    /**
     * @param nave the nave to set
     */
    public void setNave(Nave nave) {
        this.nave = nave;
    }

    /**
     * @return the enemigos
     */
    public ArrayList<Enemigo> getEnemigos() {
        return enemigos;
    }

    /**
     * @param enemigos the enemigos to set
     */
    public void setEnemigos(ArrayList<Enemigo> enemigos) {
        this.enemigos = enemigos;
    }
    
    
    
}
