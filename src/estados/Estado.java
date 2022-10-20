/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estados;

import controladores.Juego;

/**
 *
 * @author jpgonzalez
 */
public class Estado {
    
    protected Juego juego;
    
    public Estado(Juego juego) {
        this.juego = juego;
    }

    /**
     * @return the juego
     */
    public Juego getJuego() {
        return juego;
    }

    /**
     * @param juego the juego to set
     */
    public void setJuego(Juego juego) {
        this.juego = juego;
    }
}
