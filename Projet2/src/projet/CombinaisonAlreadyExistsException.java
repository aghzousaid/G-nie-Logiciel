package projet;

public class CombinaisonAlreadyExistsException extends Exception {
	public CombinaisonAlreadyExistsException(CombinaisonRessource combinaison) {
		super("Cette combinaison existe d�j�  : " + combinaison.toString());
	}

}
