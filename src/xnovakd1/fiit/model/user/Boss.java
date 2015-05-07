package xnovakd1.fiit.model.user;

import xnovakd1.fiit.model.Commands;
import xnovakd1.fiit.model.problem.DamagedPipe;
import xnovakd1.fiit.model.problem.DirtProblem;
import xnovakd1.fiit.model.problem.InjuryProblem;
import xnovakd1.fiit.model.problem.Tasks;

/**
 * Trieda Boss reprezentuje specificky typ uzivatela, ktory sa vie prihlasit do systemu.
 * Specificky preto, lebo funguje ako administrator, teda jedine on vie explicitne pridavat ulohy
 * pre ostatne povolania. Implementuje rozhranie LoggedUser aby ziskal pristup k metode interpret.
 */

public class Boss implements LoggedUser {

	private Tasks list; 													// agregacia

	public Boss() {

		list = Tasks.getInstance();
		System.out.println("Prihlasil sa Boss");
	}

	/**
	 * Podla enumeracie tato metoda zisti, komu bola
	 * pridana/vygenerovana uloha.
	 * @param command
	 */

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
