package projet;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CalendrierPersistence extends Calendrier implements CalendrierInterfacePersistence  {
	
	public void serializationSave(String fileName) {
		ObjectOutputStream stream;
		try {
			stream = new ObjectOutputStream(new FileOutputStream(fileName));
			for (CombinaisonRessource cr : getCombinaison()) {
				stream.writeObject(cr);
			}
			stream.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	
	public void serializationRead(String fileName) {
		try {
			ObjectInputStream stream = new ObjectInputStream(new FileInputStream(fileName));
			CombinaisonRessource cr = null;
			while ((cr = (CombinaisonRessource) stream.readObject()) != null) {
				try {
					add(cr);
				} catch (CombinaisonAlreadyExistsException e) {
					System.err.println(e.getMessage());
				}
			}
			stream.close();
		} catch (EOFException e) {
			// No message predefined, we have to write here our own message.
			System.out.println("End of file reading");
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	
	public void removeAll() {
		getCombinaison().clear();
	}


}
