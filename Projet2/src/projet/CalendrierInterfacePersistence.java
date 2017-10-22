package projet;

public interface CalendrierInterfacePersistence extends CalendrierInterface {
	
	void serializationSave(String fileName);

	void serializationRead(String fileName);
	
	void removeAll();
	
}
