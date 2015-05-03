package xnovakd1.fiit.model.exception;

/**
 * Created by Daniel on 2.5.2015.
 * Vytvoril som si vlastnu vynimku - RegisterException,
 * ktora sa vyhodi vtedy, ak sa cloven pokusa zaregistrovat do
 * programu s neplatnymi udajmi. (Napriklad ked nezada ID udaj).
 */
public class RegisterException extends Exception {

    private static final long serialVersionUID = 7636487858905548571L;      // konvencia

}
