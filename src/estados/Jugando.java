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
    private boolean juegoEnCurso;
    private int vida = 3;
    private Nave nave;

    public Jugando(Juego juego) {
        super(juego);
        this.enemigos = new ArrayList<>();
        this.estrellas = new ArrayList<>();
        this.setJuegoEnCurso(true);
        desplegarComponentes();
    }

    /**
     * Imprime los componentes queridos dentro del frame
     */
    private void desplegarComponentes() {
        setNave(new Nave(false, 368f, 278f, 64, 64));
        for (int i = 0; i < (int) Math.random() * 100 + 80; i++) {
            this.getEstrellas().add(new Estrella(false,
                    Math.round(Math.random() * Config.WIDTH + 10),
                    Math.round(Math.random() * Config.HEIGH + 10), 7, 7));
        }
        this.crearEnemigos();
    }

    /**
     * Genera las naves enemigas dentro de la pantalla
     */
    public void crearEnemigos() {
        for (int i = 0; i < 5; i++) {
            this.getEnemigos().add(new Enemigo(true,
                    Math.round(Math.random() * Config.WIDTH + 100 + 1100),
                    Math.round(Math.random() * Config.HEIGH - 48 + 5), 48, 48));
        }
    }

    @Override
    public void actualizar() {
        if(isJuegoEnCurso()) {
            this.getNave().actualizarEstdo();
            for (Enemigo temp : getEnemigos()) {
                temp.actualizarEstdo();
            }
            validarColDispario();
            for (Estrella temp : getEstrellas()) {
                temp.actualizarPosicion();
            }
        }
    }

    @Override
    public void actualizarRenderizado(Graphics g) {
        
    for (Estrella actu : getEstrellas()) {
        actu.renderizar(g);
    }
    this.getNave().renderizar(g);
    for (Enemigo temp : getEnemigos()) {
        temp.renderizar(g);
    }
        
    }

    /**
     * Valida que los disparos inpacten con agfluna nave enemiga en su trayecto
     */
    public void validarColDispario() {
        for (Disparo disp : getNave().getDisparos()) {
            for (Enemigo enemigo : getEnemigos()) {
                if (disp.getHitbox().intersects(enemigo.getHitbox()) && enemigo.isViva()) {
                    disp.setEnRango(false);
                    enemigo.setViva(false);
                    System.out.println("BOOm");
                }
            }
        }
    }

    

    public void choque() {
        for (Enemigo cur : getEnemigos()) {
            if (cur.getHitbox().intersects(getNave().getHitbox()) && cur.isViva()) {
                this.juego.reiniciarJuego();
                
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    /**
     * Retorna la nave
     *
     * @return
     */
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

    /**
     * @return the vida
     */
    public int getVida() {
        return vida;
    }

    /**
     * @param vida the vida to set
     */
    public void setVida(int vida) {
        this.vida = vida;
    }

    /**
     * @return the juegoEnCurso
     */
    public boolean isJuegoEnCurso() {
        return juegoEnCurso;
    }

    /**
     * @param juegoEnCurso the juegoEnCurso to set
     */
    public void setJuegoEnCurso(boolean juegoEnCurso) {
        this.juegoEnCurso = juegoEnCurso;
    }

}
