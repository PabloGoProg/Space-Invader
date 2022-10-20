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
    
    JUGANDO, MENU, PAUSA, MUERTE;
    
    public static EstadosDeJuego estadoActual = MENU;
    
}
