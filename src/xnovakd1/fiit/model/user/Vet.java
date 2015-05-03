package xnovakd1.fiit.model.user;

import xnovakd1.fiit.model.Commands;

public class Vet implements LoggedUser {


    public Vet() {
        System.out.println("Prihlasil sa veterinar");
    }

    @Override
    public void interpret(Commands command) {
        if (command == Commands.TASK_RESOLVE) {
            System.out.println("Veterinar prijal a vykonal ulohu");

        }
    }
}
