/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estados;

import controladores.Juego;
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
    
    private ArrayList<Imagen> imagenes;
    private ArrayList<Estrella> estrellas;
    private Nave nave; 
    
    public Jugando(Juego juego) {
        super(juego);
        this.imagenes = new ArrayList<>();
        this.estrellas = new ArrayList<>();
        desplegarComponentes();
        
    }
    
    /**
     * Imprime los componentes queridos dentro del frame
     */
    private void desplegarComponentes() {
        setNave(new Nave(false, 368f, 278f, 64, 64));
        getImagenes().add(getNave());
        for(int i = 0; i < (int)Math.random()*50+25; i++){
            this.estrellas.add(new Estrella(false, 
                    Math.round(Math.random()*800+10), 
                    Math.round(Math.random()*620+10), 7, 7));
        }
    }
    
    @Override
    public void actualizar() {
        this.nave.actualizarEstdo();
    }

    @Override
    public void actualizarRenderizado(Graphics g) {
        for(Estrella actu : estrellas) {
            actu.renderizar(g);
        }
        this.nave.renderizar(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                nave.setUp(false);
                break;
            case KeyEvent.VK_A:
                nave.setLeft(false);
                break;
            case KeyEvent.VK_S:
                nave.setDown(false);
                break;
            case KeyEvent.VK_D:
                nave.setRight(false);
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                nave.setUp(true);
                break;
            case KeyEvent.VK_A:
                nave.setLeft(true);
                break;
            case KeyEvent.VK_S:
                nave.setDown(true);
                break;
            case KeyEvent.VK_D:
                nave.setRight(true);
                break;
            case KeyEvent.VK_L:
                nave.disparar();
                break;
        }
    }
    
    public Nave getNave() {
        return nave;
    }

    /**
     * @return the imagenes
     */
    public ArrayList<Imagen> getImagenes() {
        return imagenes;
    }

    /**
     * @param imagenes the imagenes to set
     */
    public void setImagenes(ArrayList<Imagen> imagenes) {
        this.imagenes = imagenes;
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
    
    
    
}
