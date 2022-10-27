/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inputs;

import controladores.PanelJuego;
import controladores.SClip;
import estados.EstadosDeJuego; 
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author jpgonzalez
 */
public class InputTeclado implements KeyListener {
    private PanelJuego panelJuego;
    private boolean puedeTeclear = true;
    SClip mario = new SClip("src/recursos/mario.wav");

    public InputTeclado(PanelJuego panelJuego) {
        this.panelJuego = panelJuego;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                panelJuego.getJuego().getJugando().getNave().setUp(false);
                break;
            case KeyEvent.VK_A:
                panelJuego.getJuego().getJugando().getNave().setLeft(false);
                panelJuego.getJuego().getJugando().getNave().setMoviendose(false);
                break;
            case KeyEvent.VK_S:
                panelJuego.getJuego().getJugando().getNave().setDown(false);
                break;
            case KeyEvent.VK_L:
                puedeTeclear = true;
                break;
            case KeyEvent.VK_D:
                panelJuego.getJuego().getJugando().getNave().setRight(false);
                panelJuego.getJuego().getJugando().getNave().setMoviendose(false);
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                panelJuego.getJuego().getJugando().getNave().setUp(true);
                break;
            case KeyEvent.VK_A:
                panelJuego.getJuego().getJugando().getNave().setLeft(true);
                panelJuego.getJuego().getJugando().getNave().setMoviendose(true);
                break;
            case KeyEvent.VK_S:
                panelJuego.getJuego().getJugando().getNave().setDown(true);
                break;
            case KeyEvent.VK_D:
                panelJuego.getJuego().getJugando().getNave().setRight(true);
                panelJuego.getJuego().getJugando().getNave().setMoviendose(true);
                break;
            case KeyEvent.VK_L:
                if(EstadosDeJuego.estadoActual == EstadosDeJuego.JUGANDO && puedeTeclear) {
                    panelJuego.getJuego().getJugando().getNave().disparar();
                    puedeTeclear = false;
                }
                break;
            case KeyEvent.VK_ENTER:
                if(EstadosDeJuego.estadoActual == EstadosDeJuego.MENU) {
                    EstadosDeJuego.estadoActual = EstadosDeJuego.JUGANDO;
                    this.panelJuego.getMenuSound().stop();
                    this.mario.play();
                }
                break;
            case KeyEvent.VK_R:
                this.panelJuego.getJuego().reiniciarJuego();
                this.panelJuego.getJuego().getMenu().actualizar();
                break;
            case KeyEvent.VK_P:
                this.panelJuego.getJuego().pausar();
                break;
        }
    }
}
