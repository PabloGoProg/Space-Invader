/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animaciones;

/**
 *
 * @author jpgonzalez
 */
public class constantes {
    
    public static class Direccion {
        public static final int DERECHA = 0;
        public static final int IZQUIERDA = 1;
    }
    
    public static class constantesJugador {
        public static final int REPOSO = 1;
        public static final int ACELERANDO = 2;
        public static final int FRENANDO = 3;
        public static final int DISPARANDO = 4;
        public static final int MURIENDO = 5;
        
        public static void CantidadAnimaciones(int accion) {
        switch (accion) {
            case ACELERANDO:
                break;
            case FRENANDO:
                break;
            case DISPARANDO:
                break;
            case MURIENDO:
                break;
            default:
                throw new AssertionError();
        }
    }
    }

}
