package xnovakd1.fiit.model.user;

import xnovakd1.fiit.model.Commands;

/**
 * Created by Daniel on 18.4.2015.
 * Rozhranie LoggedUser s jedinou metodou Interpret, ktora podla argumentu
 * vykonava v programe rozdielne ulohy.
 */
public interface LoggedUser {

     void interpret(Commands command);

}
