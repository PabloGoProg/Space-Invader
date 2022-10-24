/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import static animaciones.constantes.Direccion.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

/**
 *
 * @author jpgonzalez
 */
public class Nave extends Imagen implements Config {
    
    private ArrayList<Imagen> posiblesNaves;
    private int naveUsada = 0;
    private boolean up, down, left, right;
    private float velocidad = 2.0f;
    private int direccionJugador = -1;
    private boolean moviendose = false;
    private int ultimaAni = 0;
    private int cambioAni = 30, velocidadAni = 0;
    private ArrayList<Disparo> disparos;
    private ArrayList<Image> movAni;
    
    public Nave(boolean maquina, float x, float y, int ancho, int alto) {
        super(maquina, x, y, ancho, alto);
        this.posiblesNaves = new ArrayList<>();
        this.disparos = new ArrayList<>();
        this.movAni = new ArrayList<>();
        sacarImagenes(); // Agrega las imagenes al arraylist
        sacarImgAni();
    }
    
    /**
     * Se encarga de actualzar la pantlla con la ultima información recogida
     */
    public void actualizarEstdo() {
        actualizarPosicion();
        actualizarDiapros();
        actualizarAnimacion();
        for(Disparo cur : disparos) {
            cur.actualizarEstado();
        }
    }
    
    /**
     * Realiza la acción de disparar, agregando un nuevo proyectil al arreglo
     */
    public void disparar() {
        getDisparos().add(new Disparo(false, getX(), getY()-32, 128, 128, 1));
    }
    
    /**
     * Actualiza la posicion de los disparos, verificando si estos 
     * todavia deberían ser impresos en pantalla.
     */
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
    
    /**
     * Soluciona los problemas con los inputs de teclado para el 
     * movimiento del jugador y da la posibilidad de mover en vertical
     * al mismo.
     */
    @Override
    public void actualizarPosicion() {
       if(isLeft() && !isRight() && this.getX() > 0) {
           this.setX(this.getX() - getVelocidad());
           this.setDireccionJugador(IZQUIERDA);
       } else if(!isLeft() && isRight() && this.getX() <Config.WIDTH - this.getAncho()) {
           this.setX(this.getX() + getVelocidad());
           this.setDireccionJugador(DERECHA);
       }
     
       if(isUp() && !isDown() && this.getY() > 0) this.setY(this.getY() - getVelocidad());
       else if(!isUp() && isDown() && this.getY() < Config.HEIGH - this.getAlto()) {
           this.setY(this.getY() + getVelocidad());
       }
    }
    
    /**
     * Se encarga de dibujar la nave en pantalla
     * @param g 
     */
    @Override
    public void renderizar(Graphics g) {
        Toolkit t = Toolkit.getDefaultToolkit();
        Image imagen = t.getImage(getPosiblesNaves().get(getNaveUsada()).getRuta());
        g.drawImage(movAni.get(ultimaAni), (int) getX()-35, (int) getY(),64, 64, null);
        g.drawImage(imagen, (int) getX(), (int) getY(), 64, 64, null);
        for(Disparo temp : getDisparos()) {
            temp.renderizar(g);
        }
    }
    
    /**
     * Mete las imagenes de las naves a su respectivo arraylist
     */
    public void sacarImagenes() {
        getPosiblesNaves().add(new Imagen("src/recursos/Ship1.png", false));
        getPosiblesNaves().add(new Imagen("src/recursos/Ship2.png", false));
        getPosiblesNaves().add(new Imagen("src/recursos/Ship4.png", false));
        getPosiblesNaves().add(new Imagen("src/recursos/Ship5.png", false));
        getPosiblesNaves().add(new Imagen("src/recursos/Ship6.png", false));
    }
    
    /**
     * Añade las imagenes para animacion de movimiento al arraylist correspondiente
     */
    public void sacarImgAni() {
        Toolkit t = Toolkit.getDefaultToolkit();
        movAni.add(t.getImage("src/recursos/exhaust1.png"));
        movAni.add(t.getImage("src/recursos/exhaust2.png"));
        movAni.add(t.getImage("src/recursos/exhaust3.png"));
        movAni.add(t.getImage("src/recursos/exhaust4.png"));
    }
    
    /**
     * Se encarga de determinar el timing para la actualuzacion de la animacionde
     * del movimiento de la nave
     */
    public void actualizarAnimacion() {
        if(moviendose && direccionJugador == DERECHA) {
            acelerar();
        } else {
            desacelerar();
        }
    }
    
    public void acelerar() {
        if(velocidadAni < cambioAni) {
            velocidadAni++;
            if(velocidadAni == cambioAni && ultimaAni < movAni.size()-1) {
                ultimaAni++;
                velocidadAni = 0;
            }
        }
    }
    
    public void desacelerar() {
        if(velocidadAni > 0) {
            velocidadAni--;
            if(velocidadAni == 0 && ultimaAni > 0) {
                ultimaAni--;
                velocidadAni = cambioAni;
            }
        }
    }

    /**
     * Devuelve algo
     * @return 
     */
    public boolean isUp() {
        return up;
    }

    public boolean isDown() {
        return down;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    /**
     * @return the posiblesNaves
     */
    public ArrayList<Imagen> getPosiblesNaves() {
        return posiblesNaves;
    }

    /**
     * @param posiblesNaves the posiblesNaves to set
     */
    public void setPosiblesNaves(ArrayList<Imagen> posiblesNaves) {
        this.posiblesNaves = posiblesNaves;
    }

    /**
     * @return the naveUsada
     */
    public int getNaveUsada() {
        return naveUsada;
    }

    /**
     * @param naveUsada the naveUsada to set
     */
    public void setNaveUsada(int naveUsada) {
        this.naveUsada = naveUsada;
    }

    /**
     * @return the velocidad
     */
    public float getVelocidad() {
        return velocidad;
    }

    /**
     * @param velocidad the velocidad to set
     */
    public void setVelocidad(float velocidad) {
        this.velocidad = velocidad;
    }

    /**
     * @return the disparos
     */
    public ArrayList<Disparo> getDisparos() {
        return disparos;
    }

    /**
     * @param disparos the disparos to set
     */
    public void setDisparos(ArrayList<Disparo> disparos) {
        this.disparos = disparos;
    }

    /**
     * @return the direccionJugador
     */
    public int getDireccionJugador() {
        return direccionJugador;
    }

    /**
     * @param direccionJugador the direccionJugador to set
     */
    public void setDireccionJugador(int direccionJugador) {
        this.direccionJugador = direccionJugador;
    }

    /**
     * @return the moviendose
     */
    public boolean isMoviendose() {
        return moviendose;
    }

    /**
     * @param moviendose the moviendose to set
     */
    public void setMoviendose(boolean moviendose) {
        this.moviendose = moviendose;
    }
}
