package xnovakd1.fiit.model.user;

import xnovakd1.fiit.model.Commands;

public class Plumber implements LoggedUser {

	public Plumber(){
		System.out.println("Prihlasil sa instalater");
	}

	@Override
	public void interpret(Commands command) {
		if (command == Commands.TASK_RESOLVE)
			System.out.println("Instalater prijal a vykonal ulohu");

	}

}
