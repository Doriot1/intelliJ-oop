package xnovakd1.fiit.model.user;

import xnovakd1.fiit.model.Commands;
import xnovakd1.fiit.model.problem.DamagedPipe;
import xnovakd1.fiit.model.problem.DirtProblem;
import xnovakd1.fiit.model.problem.InjuryProblem;
import xnovakd1.fiit.model.problem.Tasks;

/**
 * Trieda Boss reprezentuje specificky typ uzivatela, ktory sa vie prihlasit do systemu.
 * Specificky preto, lebo funguje ako administrator, teda jedine on vie explicitne pridavat ulohy
 * pre ostatne povolania. Implementuje rozhranie LoggedUser aby ziskal pristup k metode interpret,
 * ktora podla "enum-u" zisti, komu sa ma vygenerovat uloha.
 */

public class Boss implements LoggedUser {

	private Tasks list; 													// agregacia

	public Boss() {

		list = Tasks.getInstance();
		System.out.println("Prihlasil sa Boss");
	}

	public void interpret(Commands command) {
		if (command == Commands.GENERATE_TASK_VET) {
			System.out.println("Bola vytvorena uloha pre veterinara");
			list.add(new InjuryProblem()); 									// vyuzitie agregovaneho objektu
		}

		if (command == Commands.GENERATE_TASK_PLUMBER) {
			System.out.println("Bola vytvorena uloha pre instalatera");
			list.add(new DamagedPipe()); 									// vyuzitie agregovaneho objektu
		}

		if (command == Commands.GENERATE_TASK_JANITOR) {
			System.out.println("Bola vytvorena uloha pre upratovaca");
			list.add(new DirtProblem()); 									// vyuzitie agregovaneho objektu
		}
	}

}
