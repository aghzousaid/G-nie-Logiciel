package projet;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;

 
public class Calendrier implements CalendrierInterface{
 
    private final ArrayList<CombinaisonRessource> alCombinaison = new ArrayList<CombinaisonRessource>();
 
    public ArrayList<CombinaisonRessource> getCombinaison() {
    return alCombinaison;
    }
    
    
    public void add(CombinaisonRessource combi) throws CombinaisonAlreadyExistsException {
		 if (alCombinaison.contains(combi)) {
				throw new CombinaisonAlreadyExistsException(combi);
			} else {
				alCombinaison.add(combi);
			}
	 }
    
    public String toString () {
		 String tmp = "Contenu du calendrier : \n";
		 for (int i=0; i<alCombinaison.size(); i++) {
			 tmp += alCombinaison.get(i).toString();
		 }
		 return tmp;
	 }
 
}