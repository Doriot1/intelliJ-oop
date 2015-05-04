package xnovakd1.fiit.model.problem;
	
public class DirtProblem extends Problem{
	
	private static final long serialVersionUID = 4754938463095875910L;
	

	private String district;
	private String description;

	public DirtProblem() {
		super();
		if(randomInt > 75)
			district = "Severna";
		else if(randomInt > 50)
			district = "Juzna";
		else if(randomInt > 25)
			district = "Vychodna";
		else if(randomInt >= 0)
			district = "Zapadna";
		this.description = district + " cast Zoo je spinava";
	}
	
	public DirtProblem(String description){
		this.description = "Vznikol neporiadok po osetreni v klietke " + randomInt;
	}

	public String toString() {
		return description;
	}
}
	