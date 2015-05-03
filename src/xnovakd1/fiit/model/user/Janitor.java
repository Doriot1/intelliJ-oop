package xnovakd1.fiit.model.user;

import xnovakd1.fiit.model.Commands;

public class Janitor implements LoggedUser {

	public Janitor(){
		System.out.println("Prihlasil sa upratovac");
	}

	@Override
	public void interpret(Commands command) {
		if (command == Commands.TASK_RESOLVE)
			System.out.println("Upratovac prijal a vykonal ulohu");

	}
}
