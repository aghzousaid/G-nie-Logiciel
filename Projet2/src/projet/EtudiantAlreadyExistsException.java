package projet;

public class EtudiantAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EtudiantAlreadyExistsException(Etudiant a)
	{
		super("Contact Exists :" +a.toString() );
	}
	
}
