package xnovakd1.fiit.model.problem;

public class InjuryProblem extends Problem{

	private static final long serialVersionUID = 3329351849064764473L;

	private String animal;

	public InjuryProblem() {
		super();
		if(randomInt > 90)
			animal = "Lev";
		else if(randomInt > 80)
			animal = "Hroch";
		else if(randomInt > 70)
			animal = "Slon";
		else if(randomInt > 60)
			animal = "Jaguar";
		else if(randomInt > 50)
			animal = "Skunk";
		else if(randomInt > 40)
			animal = "Mravenciar";
		else if(randomInt > 30)
			animal = "Gepard";
		else if(randomInt > 20)
			animal = "Kon";
		else if(randomInt > 10)
			animal = "Netopier";
		else if(randomInt >= 0)
			animal = "Pakon";
	}

	@Override
	public String toString() {
		return animal + " je zraneny v klietke " + randomInt;
	}
	
	
}
