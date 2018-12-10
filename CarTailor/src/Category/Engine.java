package CarTailor.src.Category;

import CarTailor.src.CarTailor.PartImpl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

enum nb_serie {
	EG100,
	EG133,
	EG210,
	ED110,
	ED180,
	EH120;
}


public class Engine extends PartImpl {

	private nb_serie printname = nb_serie.EG100;//par d?faut

	public Engine(){
		possible_Name.add(nb_serie.EG100.name());possible_Name.add(nb_serie.EG133.name());possible_Name.add(nb_serie.EG210.name());
		possible_Name.add(nb_serie.ED110.name());possible_Name.add(nb_serie.ED180.name());possible_Name.add(nb_serie.EH120.name());

	}
	
	public String getName() {
		return possible_Name.iterator().next();
	}
	Set<String> possible_Name=new HashSet<>();

	public Iterator<String> getContent(){
		return possible_Name.iterator();
	}

}