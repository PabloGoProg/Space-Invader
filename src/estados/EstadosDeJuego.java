/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package estados;

/**
 *
 * @author jpgonzalez
 */
public enum EstadosDeJuego {
    
    JUGANDO, MENU;
    
    /**
     * Se encarga de definir el estado en el que se encuentra
     * el programa en tiempo de ejecucuion
     */
    public static EstadosDeJuego estadoActual = MENU;
    
}
